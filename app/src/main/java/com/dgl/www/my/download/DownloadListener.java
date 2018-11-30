package com.dgl.www.my.download;

/**
 * Created by dugaolong on 17/5/19.
 * 对下载过程中的各种状态进行监听和回调
 */

public interface DownloadListener {

    //当前下载进度
    void onProgress(int progress);

    //下载成功
    void onSuccess();

    //下载失败
    void onFialed();

    //暂停下载
    void onPaused();

    //取消下载
    void onCanceled();

}
