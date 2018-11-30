package com.dgl.www.my.knowledgePoint;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dgl.www.my.R;
import com.dgl.www.my.utils.ImageTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by dugaolong on 16/9/5.
 */
public class GetPicture extends Activity {
    private static final int TAKE_PICTURE = 0;
    private static final int CHOOSE_PICTURE = 1;

    private static final int SCALE = 5;//照片缩小比例
    private ImageView iv_image = null;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getpicture);
        setTitle("Demo作者：@dgl");
        iv_image = (ImageView) this.findViewById(R.id.image);
        this.findViewById(R.id.takephoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(GetPicture.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(GetPicture.this, new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    showPicturePicker(GetPicture.this);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showPicturePicker(GetPicture.this);
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE:
                    //将保存在本地的图片取出并缩小后显示在界面上
                    Bitmap bitmap = BitmapFactory.decodeFile(getExternalCacheDir() + "/image.jpg");
                    Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
                    //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
                    bitmap.recycle();

                    //将处理过的图片显示在界面上，并保存到本地
                    iv_image.setImageBitmap(newBitmap);
                    ImageTools.savePhotoToSDCard(newBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), String.valueOf(System.currentTimeMillis()));
                    break;

                case CHOOSE_PICTURE:
                    ContentResolver resolver = getContentResolver();
                    //照片的原始资源地址
                    Uri originalUri = data.getData();
                    try {
                        //使用ContentProvider通过URI获取原始图片
                        Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                        if (photo != null) {
                            //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
                            Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
                            //释放原始图片占用的内存，防止out of memory异常发生
                            photo.recycle();

                            iv_image.setImageBitmap(smallBitmap);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    break;
            }
        }
    }

    public void showPicturePicker(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("图片来源");
        builder.setNegativeButton("取消", null);
        builder.setItems(new String[]{"拍照","相册","nicai"}, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case TAKE_PICTURE:
                        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        File outPutImage = new File(getExternalCacheDir(),"image.jpg");//创建File对象,用于存储拍照后的照片
                        try{
                            if(outPutImage.exists()){
                                outPutImage.delete();
                            }
                            outPutImage.createNewFile();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //从Android7.0开始,直接使用本地真实路径的URI被认为是不安全的,会抛出FileURIExposedException异常。
                        //FileProvider是一种特殊的内容提供器,他使用了和内容提供器类似的机制来对数据进行保护。
                        if(Build.VERSION.SDK_INT >= 24){
                            imageUri = FileProvider.getUriForFile(GetPicture.this,"com.example.dugaolong.wiewone.fileprovider",outPutImage);
                        }else{
                            imageUri = Uri.fromFile(outPutImage);
                        }
                        //指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                    case CHOOSE_PICTURE:
                        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case 2:
                        Toast.makeText(GetPicture.this,"you click 2",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
            }
        });
        builder.create().show();
    }
}
