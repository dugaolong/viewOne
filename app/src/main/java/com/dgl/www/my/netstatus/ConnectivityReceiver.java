/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dgl.www.my.netstatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * 
 * TODO A broadcast receiver to handle the changes in network connectiion states
 * 网络变化广播接收器
 * <p/>
 * 创建时间: 2016年05月16日15:04:04 <br/>
 * 
 * @author xszhang
 * @version
 * @since v0.0.1
 */
public class ConnectivityReceiver extends BroadcastReceiver {

	private static final String TAG = "XMPP";


	public ConnectivityReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "ConnectivityReceiver.onReceive()...");
		String action = intent.getAction();
		Log.d(TAG, "action=" + action);

		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo != null) {
			Log.d(TAG, "Network Type  = " + networkInfo.getTypeName());
			Log.d(TAG, "Network State = " + networkInfo.getState());
			if (networkInfo.isConnected()) {
				Log.i(TAG, "Network connected");
			}
		} else {
			Log.e(TAG, "Network unavailable");
		}
	}

}
