package com.dgl.www.my.download;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dugaolong on 17/5/19.
 * String:在执行AsyncTask异步任务的时候,需要传参数
 * Integer:用整数类型表示进度
 * Integer:反馈执行结果
 */

public class DownloadTask extends AsyncTask<String,Integer,Integer> {

    public static final int TYPE_SECCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_CANCELED = 3;

    private DownloadListener downloadListener;
    private boolean isCanceled = false;
    private boolean isPaused = false;
    private int lastProgress;

    public DownloadTask(DownloadListener downloadListener){
        this.downloadListener = downloadListener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile randomAccessFile = null;
        File file = null;
        try {
            long downloadedLength = 0;//记录文件已经下载的长度
            String downloadUrl = params[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory+ fileName);
            if(file.exists()){
                downloadedLength = file.length();
            }
            long contentLength = getContentLength(downloadUrl);
            if(contentLength == 0){
                return TYPE_FAILED;
            }else if(contentLength == downloadedLength){
                return TYPE_SECCESS;
            }
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE","bytes="+downloadedLength+"-")
                    .url(downloadUrl)
                    .build();
            Response response = client.newCall(request).execute();
            if(response != null){
                is = response.body().byteStream();
                randomAccessFile = new RandomAccessFile(file,"rw");
                randomAccessFile.seek(downloadedLength);//跳过已下载的字节
                byte[] b = new byte[1024];
                int total = 0;
                int len = 0;
                while ((len = is.read(b))!=-1){
                    if(isCanceled){
                        return TYPE_CANCELED;
                    }else if(isPaused){
                        return TYPE_PAUSED;
                    }else {
                        total +=len;
                        randomAccessFile.write(b,0,len);
                        //计算已经下载的百分比
                        int progress = (int)((total + downloadedLength)*100/contentLength);
                        publishProgress(progress);
                    }
                }
                response.body().close();
                return TYPE_SECCESS;
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(is != null){
                    is.close();
                }
                if(randomAccessFile!=null){
                    randomAccessFile.close();
                }
                if(isCanceled && file!= null){
                    file.delete();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    //根据url获得文件大小
    private long getContentLength(String downloadUrl) throws Exception{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response response = client.newCall(request).execute();
        if(response != null && response.isSuccessful()){
            long contentLength = response.body().contentLength();
            response.close();
            return contentLength;
        }
        return 0;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if(progress>lastProgress){
            downloadListener.onProgress(progress);
            lastProgress = progress;
        }
    }

    @Override
    protected void onPostExecute(Integer status) {
        switch (status){
            case TYPE_SECCESS:
                downloadListener.onSuccess();
                break;
            case TYPE_PAUSED:
                downloadListener.onPaused();
                break;
            case TYPE_CANCELED:
                downloadListener.onCanceled();
                break;
            case TYPE_FAILED:
                downloadListener.onFialed();
                break;
            default:
                break;
        }
    }

    public void pauseDownload(){
        isPaused = true;
    }

    public void cancelDownload(){
        isPaused = false;
    }
}
