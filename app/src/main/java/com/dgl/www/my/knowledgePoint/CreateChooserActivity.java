package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by dugaolong on 17/8/28.
 */

public class CreateChooserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shareQuestion(this,"这是新闻的title","http://www.baidu.com");

    }

    private void shareQuestion(Context context, String questionTitle, String questionUrl) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        //noinspection deprecation
//        share.setAction()
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_TEXT,
                questionTitle + " " + questionUrl + " 分享自知乎日报");
        context.startActivity(Intent.createChooser(share, "分享至…"));
    }
}
