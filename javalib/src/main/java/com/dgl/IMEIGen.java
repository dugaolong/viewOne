package com.dgl;

public class IMEIGen {

    /**
     * @param args
     */
    public static void main(String[] args) {
//		String code = "35254112521400";
//		String newCode = genCode(code);
//		System.out.println("======"+newCode);
//		System.out.println(code+newCode);
//		String endCode = "35254112521500";
//		beachIMEI(code,endCode);
//        System.out.println(getIMEI());
        //863271890915765
        //863182759282876
        //865695037162204

    }

    /**
     *


     <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
     <html xmlns="http://www.w3.org/1999/xhtml">
     <head>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
     <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
     <title>西安交通发布</title>
     <link href="/www/WeChatlib/css/style.css" rel="stylesheet" type="text/css" />
     <script src="/www/WeChatlib/js/jquery-1.11.2.min.js"></script>
     <script src="/www/map/slectItem/jquery.autoSearchText.js"></script>
     <script src="/www/map/general.js"></script>
     <link href="/www/map/slectItem/autoSearchText.css" rel="stylesheet" />

     <script src="/www/WeChatlib/js/jquery.cookie.js"></script>
     <script src="/www/WeChatlib/js/Zuobiao.js"></script>
     <script src="/www/WeChatlib/js/json2.min.js"></script>

     <script src="/www/Map/basejs.js"></script>
     <script src="/www/Map/coordinate.main.js"></script>

     <script>
     var _hmt = _hmt || [];
     (function () {
     var hm = document.createElement("script");
     hm.src = "https://hm.baidu.com/hm.js?363d1436b31d5d81219f7aa50e8f9168";
     var s = document.getElementsByTagName("script")[0];
     s.parentNode.insertBefore(hm, s);
     })();
     </script>

     <script type="text/javascript">

     //接收参数
     var typed = '';
     var segmentid = '';
     var stationid = '';

     //cookie记录数组
     var StoredValue = new Array();
     var resultnum = 9   //保留num+1个值


     var my_cookie = "myRealBusLine";  //保存cookie的名称


     $(document).ready(function () {

     //添加实时公交线路选项
     $('#realtimebusid').autoSearchText({
     autoSearchItemId: "realbusdd",
     minChar: 1,
     datafn: getBusLinrDataStable,
     fn: setrealBusLineId
     });
     function setrealBusLineId(value) {

     $("#reltimebusLineId").val(value.split(',')[0]);
     $("#reltimebusLinename").val(value.split(',')[1]);
     $("#IsLiveTemp").val(value.split(',')[2]);
     //if (value.indexOf(",") > 0) {
     //} else {
     //    $("#reltimebusLinename").val("无");
     //}
     $("#tbrealtimebus").click();
     }

     //点击查询进行跳转并写入cookie中
     $("#tbrealtimebus").click(function () {
     var routeid = $("#reltimebusLineId").val();
     var routename = $("#realtimebusid").val();
     var droutename = $("#reltimebusLinename").val();
     var isLive = $("#IsLiveTemp").val();

     //需要进行处理去掉没有实时的车辆
     if (routeid == "") {
     alert("请选取线路！");
     return null;
     } else {
     if (isLive == "T") {
     //有实时数据
     var timestamp = new Date().getTime();
     var obj = { tim: timestamp, routeid: routeid, routename: routename, droutename: droutename, isLive: isLive };
     //必须处理(删除重复)
     var tims = IsExist(routename);
     if (tims) { DelDataTim(tims); }
     StoredValue.unshift(obj);
     var strng = JSON.stringify(StoredValue);
     $.cookie(my_cookie, strng, { path: '/', expires: 365 }); // 存储 cookie
     //转入其它页面
     OpenRealBus(droutename);
     } else {
     //没有实时数据[只做跳转不做记录]
     TraceBusLineSerch(routeid, routename);
     }
     }
     });

     LoadCookie();
     DelOpen();
     })


     //执行从线路传过来的跳转
     function DelOpen() {
     if (typed == "realtime") {
     var stInfo = segmentid.split(':');
     $("#realtimebusid").val(stInfo[2]);
     $("#reltimebusLinename").val(stInfo[0]);
     $("#reltimebusLineId").val(stInfo[1]);
     $("#IsLiveTemp").val(stInfo[3]);

     //从cookie中取gps数据
     //$("#loglatvalue").val(LoadCookiegps());
     $("#tbrealtimebus").click();
     }
     }

     //读取cookie中数据
     function LoadCookie() {
     var value = $.cookie(my_cookie); // 读取 cookie
     $("#cookieresult").html("");
     if (value != null && value != "") {
     //反序列化方法
     StoredValue = JSON.parse(value);
     var obj = StoredValue;
     var text = "<div class='zdcxCenTop' style='border-bottom:none'>最近使用</div>";
     text += "<ul>";
     $.each(StoredValue, function (key, value) {
     if (key > resultnum) {
     $.cookie(my_cookie, '', { expires: -1 }); // 删除 cookie
     //只存num+1个数据
     var StoredNValue = obj.slice(0, resultnum + 2);
     var strng = JSON.stringify(StoredNValue);
     $.cookie(my_cookie, strng, { path: '/', expires: 365 }); // 存储 cookie
     } else {
     //组织数据
     // value.routename + ":" + value.droutename +value.routeid
     text += "<li><span><img src='/www/WeChatlib/images/gjxlIco.png' /></span><a href='javascript:DelOpenRealBus(\"" + value.routeid + "\",\"" + value.routename + "\",\"" + value.droutename + "\",\"" + value.isLive + "\")'>" + value.routename + "</a><button onclick='javascript:DelAndLoad(" + value.tim + ")'>X</button><div class='clear'></div></li>";
     }
     })
     text += "</ul>";
     if (StoredValue.length > 0) {
     text += "<div class='clear'></div>";
     text += "<div class='xllsQc'><button onclick='javascript:DelCookie()'>清除记录</button></div>";
     $("#cookieresult").html(text);
     }
     } else {
     StoredValue.length = 0;
     }
     }

     //删除操作
     function DelAndLoad(tim) {
     DelDataTim(tim)
     LoadCookie();
     }

     //对数组的删除并写入
     function DelDataTim(tim) {

     var persons = StoredValue;
     //alert(name);
     for (var i = 0; i < persons.length; i++) {
     var cur_person = persons[i];
     if (cur_person.tim == tim) {
     StoredValue.splice(i, 1);
     }
     }
     var strng = JSON.stringify(StoredValue);
     $.cookie(my_cookie, strng, { path: '/', expires: 365 }); // 存储 cookie
     }

     //数组中是否存在
     function IsExist(routename) {
     var persons = StoredValue;
     for (var i = 0; i < persons.length; i++) {
     var cur_person = persons[i];
     if (cur_person.routename == routename) {
     return cur_person.tim
     }
     }
     return null;
     }

     //清除全部cookie
     function DelCookie() {
     $.cookie(my_cookie, '', { path: '/', expires: -1 }); // 删除 cookie
     LoadCookie();
     }

     //进行排序处理
     function DelOpenRealBus(routeid, routename, droutename, isLive) {
     // var obj = { tim: timestamp, routeid: routeid, routename: routename, droutename: droutename };
     $("#reltimebusLineId").val(routeid);
     $("#realtimebusid").val(routename);
     $("#reltimebusLinename").val(droutename);
     $("#IsLiveTemp").val(isLive);
     $("#tbrealtimebus").click();
     }


     //转入线路查询
     function TraceBusLineSerch(routeid, routename) {

     window.location.href = "/BusPage/bus_line?segmentid=" + routename + ":" + routeid + "&stationid=&typed=realtime";
     }


     //页面路转
     function OpenRealBus(droutename) {
     var longlat = $("#loglatvalue").val();
     var urstr = "&lat=&lng=";
     if (longlat.split(",").length > 0) {
     urstr = "&lat=" + longlat.split(",")[1] + "&lng=" + longlat.split(",")[0];
     }

     window.location.href = chelailiaourl + "?type=1&key=" + droutename + urstr + "&showName=" + $("#realtimebusid").val();
     }


     //坐标处理
     var localfalg = false;                              //定位标志
     //取当前地理位置
     function getLocation() {
     var coortype = "wgs84";
     LoadCoordinate(url, coortype, showPosition, getCoordinateError);                            //微信定位
     //getLocationByCurrent(succbackBrowser, function (s) { });     　                             //浏览器定位[失败无提示]
     }

     //浏览器定位
     function succbackBrowser(res) {
     var longitude = res.coords.longitude;
     var latitude = res.coords.latitude;
     //不需要转坐标
     //var wgs84togcj = coordtransform.wgs84togcj02(longitude, latitude);
     //longitude = parseFloat(wgs84togcj[0]);
     //latitude = parseFloat(wgs84togcj[1]);

     var res = { "longitude": longitude, "latitude": latitude }
     localfalg = true;
     if (!localfalg) {
     showConvergencePosition(res);
     }
     }

     //微信定位
     function showPosition(res) {
     localfalg = true;
     if (!localfalg) {
     showConvergencePosition(res);
     }
     }

     //统一处理
     function showConvergencePosition(res) {
     //写入hidden中
     $("#loglatvalue").val(res.longitude + "," + res.latitude);
     }

     getLocation();

     </script>



     </head>

     <body>
     <!-- 20161122 -->
     <div id="realtimediv" class="djsDiv djsDivHov" style="display:none">
     <span id="spannum">15</span>
     <img src="/www/WeChatlib/images/sx.png" class="ssgjSxImg" />
     </div>
     <!-- 20161122 -->
     <div class="busSel">
     <ul>
     <li><a href="/BusPage/bus_realtime"><img src="/www/WeChatlib/images/ssgjIco.png" /><span style="display:block;">实时公交</span></a><div class="tri" style="display:block;"></div></li>
     <li><a href="/BusPage/bus_line"><img src="/www/WeChatlib/images/gjxlIco.png" /><span style="display:block;">线路查询</span></a><div class="tri"></div></li>
     <li><a href="/BusPage/bus_transfer"><img src="/www/WeChatlib/images/gjhcIco.png" /><span style="display:block;">换乘查询</span></a><div class="tri"></div></li>
     <li><a href="/BusPage"><img src="/www/WeChatlib/images/gjzdIco.png" /><span style="display:block;">附近站点</span></a><div class="tri"></div></li>
     </ul>
     <div class="clear"></div>
     </div>
     <div class="busSea cen">
     <form method="post">
     <input type="text" placeholder="请输入公交线路名称" value="" class="bussTet" id="realtimebusid" />
     <input type="hidden" id="reltimebusLineId" value="" />
     <input type="hidden" id="reltimebusLinename" value="" />
     <input type="hidden" id="IsLiveTemp" value="" />
     <input type="hidden" id="loglatvalue" value="" />
     <input type="button" value="搜索" class="bussSub" id="tbrealtimebus" />
     </form>
     </div>
     <div class="clear"></div>
     <div id="cookieresult" class="xllsDiv">

     <div class="clear"></div>
     <div class="xllsQc"><button id="clearcookie">清除记录</button></div>
     </div>

     <div class="xlcxCen" style="overflow:auto;">
     <ul>
     <li>
     <!--20161230添加-->
     <div class="wjgCen" id="resultdiv" style="display:none">暂未查询到实时公交数据</div>
     <!--20161230添加-->
     <div id="upstop">

     </div>
     </li>
     <li>
     <div id="downstop">

     </div>
     </li>
     </ul>
     </div>
     </body>
     </html>


     */
}
