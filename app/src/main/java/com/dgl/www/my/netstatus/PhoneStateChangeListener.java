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

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;


/**
 *  A listener class for monitoring changes in phone connection states
 * TODO 电话状态改变监听器、来电、挂断、连接中、已链接、暂停
 * <p/>
 * 创建时间: 2016年05月16日14:59:14 <br/>
 *
 * @author xszhang
 * @since v0.0.1
 */
public class PhoneStateChangeListener extends PhoneStateListener {

	private static final String TAG = PhoneStateChangeListener.class.getSimpleName();


	public PhoneStateChangeListener(){
	}

	@Override
	public void onDataConnectionStateChanged(int state) {
		super.onDataConnectionStateChanged(state);
		Log.d(TAG, "onDataConnectionStateChanged()...");
		Log.d(TAG, "Data Connection State = " + getState(state));

		if (state == TelephonyManager.DATA_CONNECTED) {
//			notificationService.connect();
		}
	}

	private String getState(int state) {
		switch (state) {
		case 0: // '\0'
			return "DATA_DISCONNECTED";// 断开
		case 1: // '\001'
			return "DATA_CONNECTING";// 连接中
		case 2: // '\002'
			return "DATA_CONNECTED";// 已连接
		case 3: // '\003'
			return "DATA_SUSPENDED";// 暂停
		}
		return "DATA_<UNKNOWN>";
	}

}
