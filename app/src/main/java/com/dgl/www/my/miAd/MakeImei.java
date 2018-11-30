package com.dgl.www.my.miAd;

import android.util.Log;

import java.security.MessageDigest;
import java.util.Random;

/**
 * Created by dugaolong on 17/5/10.
 */

public class MakeImei {

    public static final String TAG = "MakeImei";

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD532(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }


    /**
     * IMEI 校验码
     *
     * @param code
     * @return
     */
    public static String genCode(String code) {
        int total = 0, sum1 = 0, sum2 = 0;
        int temp = 0;
        char[] chs = code.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int num = chs[i] - '0';    // ascii to num
            //System.out.println(num);
            /*(1)将奇数位数字相加(从1开始计数)*/
            if (i % 2 == 0) {
                sum1 = sum1 + num;
            } else {
				/*(2)将偶数位数字分别乘以2,分别计算个位数和十位数之和(从1开始计数)*/
                temp = num * 2;
                if (temp < 10) {
                    sum2 = sum2 + temp;
                } else {
                    sum2 = sum2 + temp + 1 - 10;
                }
            }
        }
        total = sum1 + sum2;
		/*如果得出的数个位是0则校验位为0,否则为10减去个位数 */
        if (total % 10 == 0) {
            return "0";
        } else {
            return (10 - (total % 10)) + "";
        }

    }

    //在code之上,生成任意imei
    static String getIMEI(String begin) {
        String code = "";
        int  nextInt = new Random().nextInt();
//        System.out.println("nextInt=====" + nextInt);
//        Log.i(TAG,"nextInt=====" + nextInt);
        try {
            Long currentCode = Long.parseLong(begin)+nextInt;
            code = currentCode.toString();
            code = code + genCode(code);
            Log.i(TAG,"生成任意imei=====" + code);
//            System.out.println("生成任意imei=====" + code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }
}
