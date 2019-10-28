package com.dgl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 我们java library 的额第一个类
 */
public class MyMain {

    String IMEI = "";
    /**
     * 将返回的毫秒值转换为yyyy-MM-dd HH:mm:ss 时间格式
     *
     * @param datetiem
     * @return
     */
    public final static void getMillisecondFormatDateTo24(long datetiem) {

        Date date = new Date(datetiem);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println( sdf.format(date));

    }

    public static final String format = "yyyy-MM-dd";

    /**
     * @param args
     */
    public static void main(String[] args) {

//        MyMain r = new MyMain();
//        DecimalFormat df   = new DecimalFormat("######0.00");
//        System.out.println(df.format(Math.sin(r.toRadians(0))));
//        System.out.println(df.format(Math.sin(r.toRadians(30))));
//        System.out.println(df.format(Math.sin(r.toRadians(90))));
        try {

//            Polygon p = new Polygon(new int[]{1,1,3,3},new int[]{0,1,1,0},4);
//            Polygon p1 = new Polygon(new int[]{0,0,2,2},new int[]{0,1,1,0},4);
//            Area area = new Area(p);
//            area.intersect(new Area(p1));
//            System.out.println(area.isEmpty());



            System.out.println(CustomDES3Util.decode("9tVODBrg4sfHUO/37++RKpFggm0ymau0JwKpuOuJweOJfOlHdTUdoCr8owxU E4sFhAV3IPIdz1Uelodnbt14Rl1qbUZTJW/5GxtL83UfVzz/2ld6jNaFD3Ro oQ/nZkg+rFSc2Uo63dBVXGxqRmAIh63Ksni4n/bvOeWo72ySQ0/tBJlsm619 OKBYWYxF9qr5sqL1Wr3skVkQFHFSwzRGaWhQYqZc0/NQ2kZfq95jZkoimBk8 NI2JAUoOvt9k8+hlSHL5FYFWUKplLQWG4aitOh+8gKYIoiBW4aAJpmk3b/rK oq8lBoVSMf9YcRvU0AXzeiDrus0T/wxGMADV5p5hAzgMFChi58H5o/seJsN/ nuwCnD1gLhQkh0Y/u5VK3fn48O0nd2amuDi/qebXQDTXqfm6JprMeV1C"));
////            String locationNowString = "等你放假贷款纠纷的113";
//            String locationNowString = "上海市杨浦区包头路1135弄4号308室放入肉";
////            String locationNowString = "陕西省西安市航天基地北长安街229号吉源美郡1c栋2单元21301室";
//            System.out.println(locationNowString.length());
//            if(locationNowString.length()>24){
//                locationNowString = locationNowString.substring(0, 24) + "\n" + locationNowString.substring(24, locationNowString.length());
//                locationNowString = locationNowString.substring(0, 12) + "\n" + locationNowString.substring(12, locationNowString.length());
//            }else if(locationNowString.length()>12){
//                locationNowString = locationNowString.substring(0, 12) + "\n" + locationNowString.substring(12, locationNowString.length());
//            }
//            System.out.println(locationNowString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }


//        String str = "http://mf.atm.youku.com/mf*";
//        String pattern = str;
//        boolean isMatch = Pattern.matches(pattern, "http://mf.atm.youku.com/mf?aw=w&vs=1.0&pver=1&tict=0&vr=0&wintype=xplayer_m3u8&site=1&fu=0&rst=mp4&dq=mp4&os=android&bt=phone&bd=undefined&d=0&partnerid=0edbfd2e4fc91b72&atm=&isvert=0&vl=227&ct=e&sid=88e6f6589654250a823e0ac072156b88&ccode=0590&cs=2359&paid=0&s=0&v=778398177&vip=0&k=iku&u=645693753&td=0&ti=陈正雷陈式太极拳老架一路基本功教学");
//        System.out.println(isMatch);
//        sendGet();
//        List<String> list = new ArrayList<String>();
//        list.add("a1");
//        list.add("a2");
//        String[] toBeStored = list.toArray(new String[list.size()]);
//        for(String s : toBeStored) {
//            System.out.println(s);
//        }
//        Calendar c = Calendar.getInstance();
//        c.setFirstDayOfWeek(Calendar.MONDAY);
////        c.setMinimalDaysInFirstWeek(4);
//        SimpleDateFormat formater = new SimpleDateFormat(format);
//        try {
//            c.setTime(formater.parse("2016-12-31"));
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        int i = c.get(Calendar.WEEK_OF_YEAR);
//
//        System.out.println("当前时间是第" + i + "周");
//        getMillisecondFormatDateTo24(1499356800000l);
//        String code = "352541125214004";
//        System.out.println("======"+digest(code));
//        System.out.println();
//        String code = "35254112521400";
//        String newCode = digest(code);
//        System.out.println("======"+aaa());
//        testUrl();
//        generate();
//        generateTime();
//        System.out.print(new Random().nextInt());
//        StringBuffer str = new StringBuffer("Hello ");
//        test(str);
//        System.out.print(str);
    }

    private static void test(StringBuffer strBuf) {
        strBuf.append("World!");
    }

    private static void generateTime() {
        System.out.print(System.currentTimeMillis());
    }


    //将imei转为32的md5密码
    public static String digest(String imeiString) {
        String str = "";
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(imeiString.getBytes());
            BigInteger localBigInteger = new BigInteger(1, localMessageDigest.digest());
            str = String.format("%1$032X", new Object[] { localBigInteger });
        } catch (Exception localException) {
        }
        return str.toLowerCase();
    }

    private static String aaa(){
        String imeiString="35566778898256";//前14位
        char[] imeiChar=imeiString.toCharArray();
        int resultInt=0;
        for (int i = 0; i < imeiChar.length; i++) {
            int a=Integer.parseInt(String.valueOf(imeiChar[i]));
            i++;
            final int temp=Integer.parseInt(String.valueOf(imeiChar[i]))*2;
            final int b=temp<10?temp:temp-9;
            resultInt+=a+b;
        }
        resultInt%=10;
        resultInt=resultInt==0?0:10-resultInt;
//        System.out.println("imei:"+imeiString+resultInt);
        return imeiString+resultInt;
    }

    // 请求广告
    public static String fetchAds() {

        return "";
    }

    //将url转为json

    /***
     * http://api.ad.xiaomi.com/union/fetchAds
     */
    public static void testUrl(){
        String url = "http://api.ad.xiaomi.com/union/fetchAds?" +
                "clientInfo=%7B%22deviceInfo%22%3A%7B%22screenWidth%22%3A1080%2C%22screenHeight%22%3A1920%2C%22" +
                "screenDensity%22%3A%223.0%22%2C%22model%22%3A%22Redmi+Note+3%22%2C%22device%22%3A%22kenzo%22%2C%22" +
                "androidVersion%22%3A%226.0.1%22%2C%22miuiVersion%22%3A%22V8.2.1.0.MHOCNDL%22%2C%22bc%22%3A%22S%22%2C%22" +
                "make%22%3A%22xiaomi%22%2C%22isInter%22%3Afalse%7D%2C%22userInfo%22%3A%7B%22" +
                "imei%22%3A%22da6fc986c0ecbb4530f746c5c6d22d36%22%2C%22mac%22%3A%2202%3A00%3A00%3A00%3A00%3A00%22%2C%22" +
//              "imei%22%3A%22da6fc986c0ecbb4531f746c5c6d22d36%22%2C%22mac%22%3A%2202%3A00%3A00%3A00%3A00%3A00%22%2C%22" +
                "language%22%3A%22%22%2C%22country%22%3A%22CN%22%2C%22customization%22%3A%22%22%2C%22connectionType%22%3A%22" +
                "wifi%22%2C%22idfa%22%3A%22d1b32108050901eb%22%7D%2C%22applicationInfo%22%3A%7B%22packageName%22%3A%22" +
                "www.dugaolong.com.xianshishigongjiao%22%2C%22version%22%3A%224%22%2C%22platform%22%3A%22android%22%7D%2C%22" +
                "impRequests%22%3A%5B%7B%22adsCount%22%3A1%2C%22context%22%3A%7B%22upId%22%3A%22bcaa805adf045251f7bc7f815d0874b5%22%2C%22" +
                "orientation%22%3A0%7D%7D%5D%2C%22adSdkInfo%22%3A%7B%22version%22%3A20024%7D%2C%22" +
                "context%22%3A%7B%22did%22%3A%22DuTZgYZ%5C%2FGBQkncyTiYkSrS1eyOEtQyABZTDDyUyV%2B1PRM5hmnIQpt9bUzve1syF4LqF6v3FL25oBnLvDADU%5C%2F0WSg%22%2C%22ds%22%3A%7B%22ov%22%3A23%2C%22" +
                "abis%22%3A%22arm64-v8a%2Carmeabi-v7a%2Carmeabi%22%2C%22advc%22%3A20024%2C%22advn%22%3A%222.2.4%22%2C%22ass%22%3A%7B%22cv%22%3A1%2C%22ck%22%3A%228ec4508b4cfe32c117baf0cdf257d5d72532bebc4555ad7480c74ddb5d6722c5538562ec042a328f88045c61cdcc69f69ea2db121d01c90468112d31d30fd760e249170d18d1a0ca4bb56410243e4a853c055c275d43943316d3991d70dfe511fb3dd4957cb8f2036de642d45ce851ed55c63522880cfc2ac8eac75b204e5296e2ef6bfe719c9f15fc80b40a31915e2b9d8463027bd9a0055d33df928cac213c044339ff0b9c08d8ee3f7ec331bee773b0dcb47c782c54692ea1ef85be1f8ebed65572f97c2747a3d3ff26e982537e29663229cd2c19799f9a37fb25efb833b3ca3dfce8be8cc7cd19a6d1bf70bac84233c5812b83b2170259fc2d4e0f084b25%22%2C%22tv%22%3A1%2C%22ct%22%3A%2200c1143275e2758f37365be039dfd5977774c578e0a3a47bf15c91ac014bf3372dcad2941559f41e1669caf609af7b2ed0f905e5fb23f5faf43419ac9db456546a929be5ff2d3ee7d9dc8b1eaf59b41f61bcf3a536d04116294e796f7c588b38128bb622b3330aacbf8db0c30c5968156ea45b113b62d89f1af35c324de9b51701216f4d8c98704cbf1b3f81f2abf26abbc41952ed43864b95a7907a164318e2%22%7D%7D%2C%22" +
                "token%22%3A%22%22%7D%7D" +
                "&upId=bcaa805adf045251f7bc7f815d0874b5&v=1&nonce=16FC607FB507766AED592F0388D7CE27&isTest=true";
        String json = url.replace("%3A",":");
        json = json.replace("%7B","{");
        json = json.replace("%5B","[");
        json = json.replace("%22","\"");
        json = json.replace("%2C",",");
        json = json.replace("%5D","]");
        json = json.replace("%7D","}");
        System.out.print(json);
    }

    //正常的json转乱码
    public static String generate(){
        String jsonurl = "{\"deviceInfo\":{\"screenWidth\":1080,\"screenHeight\":1920,\"screenDensity\":\"3.0\",\"model\":\"Redmi Note 3\",\"device\":\"kenzo\",\"androidVersion\":\"6.0.1\",\"miuiVersion\":\"V8.2.1.0.MHOCNDL\",\"bc\":\"S\",\"make\":\"xiaomi\",\"isInter\":false},\"userInfo\":{\"imei\":\"da6fc986c0ecbb4530f746c5c6d22d36\",\"mac\":\"02:00:00:00:00:00\",\"language\":\"\",\"country\":\"CN\",\"customization\":\"\",\"connectionType\":\"wifi\",\"idfa\":\"d1b32108050901eb\"},\"applicationInfo\":{\"packageName\":\"www.dugaolong.com.xianshishigongjiao\",\"version\":\"4\",\"platform\":\"android\"},\"impRequests\":[{\"adsCount\":1,\"context\":{\"upId\":\"bcaa805adf045251f7bc7f815d0874b5\",\"orientation\":0}}],\"adSdkInfo\":{\"version\":20024},\"context\":{\"did\":\"DuTZgYZ\\/GBQkncyTiYkSrS1eyOEtQyABZTDDyUyV+1PRM5hmnIQpt9bUzve1syF4LqF6v3FL25oBnLvDADU\\/0WSg\",\"ds\":{\"ov\":23,\"abis\":\"arm64-v8a,armeabi-v7a,armeabi\",\"advc\":20024,\"advn\":\"2.2.4\",\"ass\":{\"cv\":1,\"ck\":\"8ec4508b4cfe32c117baf0cdf257d5d72532bebc4555ad7480c74ddb5d6722c5538562ec042a328f88045c61cdcc69f69ea2db121d01c90468112d31d30fd760e249170d18d1a0ca4bb56410243e4a853c055c275d43943316d3991d70dfe511fb3dd4957cb8f2036de642d45ce851ed55c63522880cfc2ac8eac75b204e5296e2ef6bfe719c9f15fc80b40a31915e2b9d8463027bd9a0055d33df928cac213c044339ff0b9c08d8ee3f7ec331bee773b0dcb47c782c54692ea1ef85be1f8ebed65572f97c2747a3d3ff26e982537e29663229cd2c19799f9a37fb25efb833b3ca3dfce8be8cc7cd19a6d1bf70bac84233c5812b83b2170259fc2d4e0f084b25\",\"tv\":1,\"ct\":\"00c1143275e2758f37365be039dfd5977774c578e0a3a47bf15c91ac014bf3372dcad2941559f41e1669caf609af7b2ed0f905e5fb23f5faf43419ac9db456546a929be5ff2d3ee7d9dc8b1eaf59b41f61bcf3a536d04116294e796f7c588b38128bb622b3330aacbf8db0c30c5968156ea45b113b62d89f1af35c324de9b51701216f4d8c98704cbf1b3f81f2abf26abbc41952ed43864b95a7907a164318e2\"}},\"token\":\"\"}}";
        String url = jsonurl.replace(":","%3A");
        url = url.replace("{","%7B");
        url = url.replace("[","%5B");
        url = url.replace("\"","%22");
        url = url.replace(",","%2C");
        url = url.replace("]","%5D");
        url = url.replace("}","%7D");
        url = url.replace(" ","+");
        url = url.replace("\\","%5C");
        url = url.replace("/","%2F");
        url = url.replace("+","%2B");
        System.out.print(url);
        return url;
    }

    public static float toRadians(int angel)
    {
        return (float) (Math.PI * angel / 180.0);
    }

    public static void sendGet() {
        String result = "";
        BufferedReader in = null;
        try {
            String appid = "wxa9139d5f63af3e49";
            String secret = "f0bc6f08a1cbe8d3d68cb1113db1b8ec";
            String code = "071kwNu72v6ryL0Levy725ZOu72kwNun";
            String grant_type = "authorization_code";
            String urlNameString = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=" + grant_type;

            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println("weixin:"+result);

        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}