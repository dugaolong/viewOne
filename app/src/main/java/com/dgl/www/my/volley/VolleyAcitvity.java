package com.dgl.www.my.volley;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.dgl.www.my.R;
import com.dgl.www.my.base.MyApplication;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dugaolong on 16/11/18.
 */

public class VolleyAcitvity extends Activity {

    private Button bt_get;
    private Button bt_post;
    private Button bt_json_get;
    private Button bt_json_post;
    private Button bt_imageRequest;
    private Button bt_ImageLoader;
    private Button bt_networkImageview;
    private ImageView iv_result;
    private NetworkImageView iv_networkImageview;
    private TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley);
        findview();
        initListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //取消网络请求
        MyApplication.getQueue().cancelAll("json_get");
    }

    private void findview() {
        bt_get = (Button) findViewById(R.id.bt_get);
        bt_post = (Button) findViewById(R.id.bt_post);
        bt_json_get = (Button) findViewById(R.id.bt_json_get);
        bt_json_post = (Button) findViewById(R.id.bt_json_post);
        bt_imageRequest = (Button) findViewById(R.id.bt_imageRequest);
        bt_ImageLoader = (Button) findViewById(R.id.bt_ImageLoader);
        bt_networkImageview = (Button) findViewById(R.id.bt_networkImageview);
        iv_result = (ImageView) findViewById(R.id.iv_result);
        iv_networkImageview = (NetworkImageView) findViewById(R.id.iv_networkImageview);
        tv_result = (TextView) findViewById(R.id.tv_result);
    }
    private void initListener() {
        //StringRequest返回的是String类型
        bt_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 1、创建一个请求队列
                 * 2、创建一个请求
                 * 3、将创建的请求添加到请求队列
                 */
                RequestQueue requestQueue = MyApplication.getQueue();
                String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                StringRequest stringRequest =  new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        tv_result.setText(s);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(VolleyAcitvity.this,volleyError.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                //请求对象设置tag标签,通过tag标签,取消请求。
                stringRequest.setTag("get");
                requestQueue.add(stringRequest);
            }
        });

        bt_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 1、创建一个请求队列
                 * 2、创建一个请求
                 * 3、将创建的请求添加到请求队列
                 */
                RequestQueue requestQueue =  MyApplication.getQueue();

                String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                StringRequest stringRequest =  new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        tv_result.setText(s);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        tv_result.setText("请求失败"+volleyError);
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<String, String>();
//                        map.put("value1","param");
                        return map;
                    }
                };
                stringRequest.setTag("post");
                requestQueue.add(stringRequest);
            }
        });
        //JsonObjectRequest返回的是json类型
        bt_json_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1、创建一个请求队列
                RequestQueue requestQueue =  MyApplication.getQueue();
                //2、创建一个请求
                String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                //默认是get方式,请求参数是拼接在url后面的,所以第三个参数设为null,
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        tv_result.setText(jsonObject.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        tv_result.setText("请求失败"+volleyError);
                    }
                });

                jsonObjectRequest.setTag("json_get");
                //3、将请求添加到请求队列
                requestQueue.add(jsonObjectRequest);

            }
        });

        bt_json_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1、创建一个请求队列
                RequestQueue requestQueue =  MyApplication.getQueue();
                //2、创建一个请求
                String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                //post传递json参数
                Map<String,String> map = new HashMap<String,String>();
                map.put("sss","aaa");
                JSONObject jsonRequest = new JSONObject(map);
                //post
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url, jsonRequest, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        tv_result.setText(jsonObject.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        tv_result.setText("请求失败"+volleyError);
                    }
                });
                jsonObjectRequest.setTag("json_post");
                //3、将请求添加到请求队列
                requestQueue.add(jsonObjectRequest);

            }
        });

        bt_imageRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1、创建一个请求队列
                RequestQueue requestQueue =  MyApplication.getQueue();
                //2、创建一个请求
                String url = "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2143872350,568214890&fm=80&w=179&h=119&img.JPEG";
                ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        iv_result.setImageBitmap(bitmap);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(VolleyAcitvity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
                    }
                });
                imageRequest.setTag("image");
                //3、将请求添加到请求队列
                requestQueue.add(imageRequest);

            }
        });

        bt_ImageLoader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1、创建一个请求队列
                RequestQueue requestQueue =  MyApplication.getQueue();
                //2、创建一个请求
                String url = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white_fe6da1ec.png";
                //3、将请求添加到请求队列
                ImageLoader imageLoader = new ImageLoader(requestQueue,new BitmapCache());
                //监听image加载过程
                ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv_result,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
                imageLoader.get(url,listener);
            }
        });

        bt_networkImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1、创建一个请求队列
                RequestQueue requestQueue =  MyApplication.getQueue();
                //2、创建一个请求
                String url = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white_fe6da1ec.png";
                ImageLoader imageLoader = new ImageLoader(requestQueue,new BitmapCache());
                iv_networkImageview.setDefaultImageResId(R.mipmap.ic_launcher);//默认图片
                iv_networkImageview.setErrorImageResId(R.mipmap.ic_launcher);//加载失败图片
                //加载网络图片
                iv_networkImageview.setImageUrl(url,imageLoader);

            }
        });
    }

}
