package com.dgl.sendMail;

import java.util.ArrayList;

/**
 * JavaMail 版本: 1.6.0
 * JDK 版本: JDK 1.7 以上（必须）
 */
public class SendMail {

    public static void main(String[] args) {

        ArrayList<String> mails = new ArrayList<>();// 收件人
//        mails.add("1690998929@qq.com");
//        mails.add("1004500323@qq.com");
//        mails.add("1845317879@qq.com");
//        mails.add("1204854876@qq.com");
//        mails.add("486166697@qq.com");
//        mails.add("3667216@qq.com");
//        mails.add("1079900848@qq.com");
//        mails.add("2117665595@qq.com");
//        mails.add("486618033@qq.com");
//        mails.add("1936157805@qq.com");
//        mails.add("415664223@qq.com");
//        mails.add("1101998198@qq.com");
//        mails.add("1830366511@qq.com");
//        mails.add("1441592846@qq.com");
//        mails.add("138850632@qq.com");
//        mails.add("807246651@qq.com");
//        mails.add("814958226@qq.com");
//        mails.add("2117665595@qq.com");
//        mails.add("138850632@qq.com");
//        mails.add("583850124@qq.com");
//        mails.add("499673803@qq.com");
//        mails.add("1079900848@qq.com");
//        mails.add("1270630081@qq.com");
//        mails.add("609012815@qq.com");
//        mails.add("215156872@qq.com");
//        mails.add("2997673172@qq.com");
//        mails.add("137267808@qq.com");
//        mails.add("2312066807@qq.com");
//        mails.add("ydl924634325@qq.com");
//        mails.add("784324372@qq.com");
//        mails.add("sxl0719@foxmail.com");
//        mails.add("3354870735@qq.com");
//        mails.add("307205763@qq.com");
//        mails.add("2579027698@qq.com");
//        mails.add("1021846874@qq.com");
//        mails.add("780918942@qq.com");
//        mails.add("283570729@qq.com");
//        mails.add("523924497@qq.com");
//        mails.add("1565970006@qq.com");
//        mails.add("137346494@qq.com");
//        mails.add("584943223@qq.com");
//        mails.add("2792325658@qq.com");
//        mails.add("1476659451@qq.com");
//        mails.add("657967803@qq.com");
//        mails.add("631042300@qq.com");
//        mails.add("wangaki@qq.com");
//        mails.add("390338276@qq.com");
//        mails.add("2107769355@qq.com");
//        mails.add("334868602@qq.com");
//        mails.add("736894760@qq.com");
//        mails.add("1209300102@qq.com");
//        mails.add("1429566529@qq.com");
//        mails.add("16216565162@qq.com");
//        mails.add("278837049@qq.com");
//        mails.add("297475662@qq.com");
//        mails.add("3269524664@qq.com");
//        mails.add("81708033@qq.com");
//        mails.add("2050765412@qq.com");
//        mails.add("2780663830@qq.com");
//        mails.add("3463256205@qq.com");
//        mails.add("1814586469@qq.com");
//        mails.add("1357318266@qq.com");
//        mails.add("1205167982@qq.com");
//        mails.add("2033593419@qq.com");
//        mails.add("1808855896@qq.com");
//        mails.add("290027153@qq.com");
//        mails.add("659720201@qq.com");
//        mails.add("429517519@qq.com");
//        mails.add("3463256205@qq.com");
//        mails.add("61940466@qq.com");
//        mails.add("510299928@qq.com");
//        mails.add("1808855896@qq.com");
//        mails.add("334868602@qq.com");
//        mails.add("1162076674@qq.com");
//        mails.add("523924497@qq.com");
//        mails.add("823919216@qq.com");
//        mails.add("804732400@qq.com");
//        mails.add("985769869@qq.com");
//        mails.add("2780663830@qq.com");
//        mails.add("3502413369@qq.com");
//        mails.add("1030498105@qq.com");
//        mails.add("3463256205@qq.com");
//        mails.add("1814586469@qq.com");
//        mails.add("510299928@qq.com");
//        mails.add("35079780@qq.com");
//        mails.add("962178496@qq.com");
//        mails.add("1341949980@qq.com");
//        mails.add("1984960245@qq.com");
//        mails.add("305674319@qq.com");
//        mails.add("450911135@qq.com");
//        mails.add("805205317@qq.com");
//        mails.add("2336986607@qq.com");
//        mails.add("1741988540@qq.com");
//        mails.add("1255853393@qq.com");
//        mails.add("2309906769@qq.com");
//        mails.add("1051292228@qq.com");
//        mails.add("2971795546@qq.com");
//        mails.add("290953233@qq.com");
//        mails.add("1624491193@qq.com");
//        mails.add("2335652167@qq.com");
//        mails.add("773136631@qq.com");
//        mails.add("977026676@qq.com");
//        mails.add("872585236@qq.com");
//        mails.add("761317618@qq.com");
//        mails.add("858845038@qq.com");
//        mails.add("452942706@qq.com");
//        mails.add("83079953@qq.com");
//        mails.add("1248064015@qq.com");
//        mails.add("510056241@qq.com");
//        mails.add("1272831610@qq.com");
//        mails.add("1136780942@qq.com");
//        mails.add("1490100868@qq.com");
//        mails.add("2457520@qq.com");
//        mails.add("12915662@qq.com");
//        mails.add("2072396553@qq.com");
//        mails.add("68058764@qq.com");
//        mails.add("80560726@qq.com");
//        mails.add("40384353@qq.com");
//        mails.add("1523565647@qq.com");
//        mails.add("1928566943@qq.com");
//        mails.add("1923517557@qq.com");
//        mails.add("1311245774@qq.com");
//        mails.add("506251930@qq.com");
//        mails.add("1627748516@qq.com");
//        mails.add("491231583@qq.com");
//        mails.add("ydl924634325@qq.com");
//        mails.add("465626107@qq.com");
//        mails.add("735425151@qq.com");
//        mails.add("2783773865@qq.com");
//        mails.add("631042300@qq.com");
//        mails.add("464693076@qq.com");
//        mails.add("834136091@qq.com");
//        mails.add("3373066@qq.com");
//        mails.add("3463256205@qq.com");
//        mails.add("1814586469@qq.com");
//        mails.add("510299928@qq.com");
//        mails.add("35079780@qq.com");
//        mails.add("403672673@qq.com");
//        mails.add("2160029117@qq.com");
//        mails.add("1075616533@qq.com");
//        mails.add("1424849133@qq.com");
//        mails.add("1528740774@qq.com");
//        mails.add("791146974@qq.com");
//        mails.add("1033182301@qq.com");
//        mails.add("469093791@qq.com");
//        mails.add("1443082258@qq.com");
//        mails.add("344893327@qq.com");
//        mails.add("3484513826@qq.com");
//        mails.add("40306221@qq.com");
//        mails.add("398215559@qq.com");
//        mails.add("2412327271@qq.com");
//        mails.add("1054971273@qq.com");
//        mails.add("3320859372@qq.com");
//        mails.add("2121533254@qq.com");
//        mails.add("3124365920@qq.com");
//        mails.add("170877098@qq.com");
//        mails.add("10994969@qq.com");
//        mails.add("1248064015@qq.com");
//        mails.add("1048207991@qq.com");
//        mails.add("120271650@qq.com");
//        mails.add("15978906686@qq.com");
//        mails.add("122755688@qq.com");
//        mails.add("838455702@qq.com");
//        mails.add("61888958@qq.com");
//        mails.add("584943223@qq.com");
//        mails.add("1733690555@qq.com");
//        mails.add("807246651@qq.com");
//        mails.add("1446263999@qq.com");
        mails.add("1830366511@qq.com");
        mails.add("3118925237@qq.com");
        mails.add("869889310@qq.com");
        mails.add("1804859420@qq.com");
        mails.add("545023466@qq.com");
        mails.add("1375331233@qq.com");
        mails.add("513875504@qq.com");
        mails.add("1733690555@qq.com");
        mails.add("472020404@qq.com");
        mails.add("835007374@qq.com");
        mails.add("838455702@qq.com");
        mails.add("1838495968@qq.com");
        mails.add("1741945268@qq.com");
        mails.add("109531396@qq.com");
        mails.add("317959865@qq.com");
        mails.add("411450036@qq.com");
        mails.add("1789244880@qq.com");
        mails.add("1733690555@qq.com");
        mails.add("118037573@qq.com");
        mails.add("839517043@qq.com");
        mails.add("807246651@qq.com");
        mails.add("472210617@qq.com");
        mails.add("1551135289@qq.com");
        mails.add("984004471@qq.com");
        mails.add("3506887609@qq.com");
        mails.add("574651408@qq.com");
        mails.add("604575583@qq.com");
        mails.add("3116337144@qq.com");
        mails.add("464693076@qq.com");
        mails.add("939497999@qq.com");
        mails.add("2217557923@qq.com");
        mails.add("1136780942@qq.com");
        mails.add("739495131@qq.com");
        mails.add("14685437158@qq.com");
        mails.add("2387207264@qq.com");
        mails.add("1379714187@qq.com");
        mails.add("568573993@qq.com");
        mails.add("125986430@qq.com");
        mails.add("2542261450@qq.com");
        mails.add("1627748516@qq.com");
        mails.add("1729965093@qq.com");
        mails.add("328407737@qq.com");
        mails.add("2312066807@qq.com");
        mails.add("1715012213@qq.com");
        mails.add("1429278387@qq.com");
        mails.add("1733690555@qq.com");
        mails.add("1172526751@qq.com");
        mails.add("138850632@qq.com");

        MailOperation operation = new MailOperation();
        String user = "3394376465@qq.com";
        String password = "plvcrrjhvcstdaea";
        String host = "smtp.qq.com";
        String from = "3394376465@qq.com";
        String subject = "免费软件";
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        sb.append("<br/>免费的全自动挂机赚钱软件，正规官方挂机网站，每天不用手动操作就能赚50-80元不等：http://www.212cc.com/tuiqi/h_goto.php?u=aliyunyong  （有详细的视频教程）<br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>");
        try {
            for(int i = 0;i<mails.size();i++){
                String res = operation.sendMail(user, password, host, from, mails.get(i),
                        subject, sb.toString());
                System.out.println(res);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}