# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/dugaolong/Documents/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#=============公共 配置 开始=================
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses

-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#-dontpreverify
-dontshrink
-dontoptimize


-keepattributes *Annotation*
-keepattributes Signature
-keepattributes *JavascriptInterface*
-keepattributes Exceptions,InnerClasses
-keepattributes SourceFile,LineNumberTable
-keepattributes EnclosingMethod

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keepclasseswithmembers class * {
    native <methods>;
}
-keepclasseswithmembernames class * {
    native <methods>;
}


-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}
# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepnames class *$* {
    public <fields>;
    public <methods>;
}
-keep class **.R
-keep class **.R$* {
    <fields>;
}
#-keep public class [your_pkg].R$*{
#    public static final int *;
#}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}


-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class javax.**

-keep public class * extends android.support.v4.**
-keep class android.support.v4.** { *; }


-keep public class com.android.vending.licensing.ILicensingService
-keep public class com.google.vending.licensing.ILicensingService
-keep class com.android.vending.licensing.ILicensingService

# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep public class * implements java.io.Serializable {*;}



-dontwarn android.support.**

#=============公共 配置 结束=================

#=============第三方库的配置 开始 =================

-keepclassmembers class android.support.design.widget.AppBarLayout.** {*;}
-keep class android.support.design.widget.** { *;}
-keep class android.support.design.widget.AppBarLayout$ScrollingViewBehavior { *;}

-keep class com.android.volley.** { *;}
-keep class com.loopj.android.http.** { *;}
-keep class com.nineoldandroids.** { *;}


-keep class org.apache.** { *;}
-keep class org.apache.http.entity.mime.** {*;}
-keep class org.apache.commons.net.** { *; }
-keep class org.apache.commons.codec.** {*; }


-keep public class com.google.gson.Gson
-keep class com.google.gson.** { *;}
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

-keep class com.google.android.gms.** { *; }

-keep class com.alibaba.fastjson.** { *;}
-keep class com.alimama.** { *;}
-keep class com.alimama.mobile.** { *;}
-keep class cn.thinkjoy.im.** { *;}

-keep class com.tencent.mm.sdk.openapi.WXMediaMessage { *;}
-keep class com.tencent.mm.sdk.openapi.** implements com.tencent.mm.sdk.openapi.WXMediaMessage$IMediaObject {*;}
-keep class com.tencent.** { *;}
-keep class com.qq.** { *;}

-keep class com.polites.android.** { *;}

#-keep class com.uuhelper.Application.** { *; }
-keep class net.sourceforge.zbar.** { *; }
-keep class org.eclipse.paho.client.mqttv3.** { *;}
-keep class com.lidroid.xutils.** { *;}
-keep class de.greenrobot.event.** { *;}


#lib中的jar
-keep class com.jeremyfeinstein.slidingmenu.lib.** { *;}
-keep class org.achartengine.** { *;}
-keep class com.iflytek.** { *;}
-keep class com.a.** { *;}
-keep class com.b.** { *;}

-keep class net.sourceforge.pinyin4j.** { *;}
-keep class com.hp.hpl.sparta.** { *;}
-keep class com.chinaMobile.** { *;}
-keep class com.sun.crypto.provider.** { *;}

-keep class com.ryg.** { *;}
-keep class com.amap.api.** { *;}
-keep class com.aps.** { *;}
-keep class com.a.a.a.** { *;}
-keep class com.itsrts.pptviewer.** { *;}
-keep class com.olivephone.** { *;}

-keep class com.google.zxing.** { *;}
#tianyinSdk
-keep class io.vov.** {*; }
-keep class io.vov.utils.** { *; }
-keep class io.vov.vitamio.** { *; }

-keep class com.gc.flashview.** { *;}


#-keep class com.olivephone.a.a.** { *;}
#-keep class com.olivephone.b.** { *;}
#-keep class com.olivephone.office.** { *;}
#-keep class com.olivephone.office.a.b.e.** { *;}
-keep public class com.olivephone.office.a.b.e.p
-keep class com.olivephone.office.a.b.e.p { *;}
-keepclassmembers class com.olivephone.office.a.b.e.p {*;}


#数据库混淆
-keep class org.apache.commons.codec.** {*;}
-keep class com.google.common.** {*;}
-keep class example.** {*;}
-keep class net.sqlcipher.** {*;}
-keep public class * extends com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
-keep public class * extends com.j256.ormlite.android.apptools.OpenHelperManager
-keep class com.j256.ormlite.** { *; }
-keep class com.j256.ormlite.android.** { *; }
-keep class com.j256.ormlite.field.** { *; }
-keep class com.j256.ormlite.stmt.** { *; }


#EventBus事件总线相关回调函数都不能被混淆
-keepclassmembers class ** {
    public void onEvent*(**);
    void onEvent*(**);
}

-keepclassmembers class * extends de.greenrobot.event.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

-dontwarn **CompatHoneycomb
-dontwarn **CompatHoneycombMR2
-dontwarn **CompatCreatorHoneycombMR2
-dontwarn com.nineoldandroids.**

-dontwarn com.alibaba.fastjson.**
-dontwarn cn.thinkjoy.im.**

-dontwarn com.polites.android.**
-dontwarn com.google.**
-dontwarn org.apache.http.entity.mime.**
-dontwarn org.apache.commons.net.**


-dontwarn com.squareup.**
-dontwarn com.squareup.okhttp.**
-dontwarn org.eclipse.paho.client.mqttv3.**
-dontwarn com.lidroid.xutils.**

-dontwarn com.jeremyfeinstein.slidingmenu.lib.**
-dontwarn com.tencent.**
-dontwarn org.achartengine.**
-dontwarn com.iflytek.**
-dontwarn com.a.**
-dontwarn com.b.**

-dontwarn net.sourceforge.pinyin4j.**
-dontwarn com.hp.hpl.sparta.**
-dontwarn com.sun.crypto.provider.**
-dontwarn com.google.zxing.**



#-dontwarn com.gc.flashview.**
#-dontwarn com.android.volley.**
#-dontwarn com.loopj.android.http.**


-dontwarn org.apache.commons.codec.**
-dontwarn com.google.common.**
-dontwarn example.**
-dontwarn net.sqlcipher.**


-dontwarn com.a.a.a.**
-dontwarn com.itsrts.pptviewer.**

-dontwarn com.chinaMobile.**
-dontwarn com.olivephone.**
-dontwarn com.olivephone.a.a.**
-dontwarn com.olivephone.b.**
-dontwarn com.olivephone.office.**
-dontwarn com.olivephone.b.**
-dontwarn com.olivephone.office.**
-dontwarn com.olivephone.office.a.b.e.**


-dontwarn okio.**
#高德地图
#3D 地图
-keep   class com.amap.api.mapcore.**{*;}
-keep   class com.amap.api.maps.**{*;}
-keep   class com.autonavi.amap.mapcore.*{*;}

#定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}

#搜索
-keep   class com.amap.api.services.**{*;}

#2D地图
-keep class com.amap.api.maps2d.**{*;}
-keep class com.amap.api.mapcore2d.**{*;}

#导航
-keep class com.amap.api.navi.**{*;}
-keep class com.autonavi.**{*;}

#分享
-keep class com.tencent.mm.sdk.** {
   *;
}
#=============第三方库的配置 结束 =================

#=============针对项目的配置 开始 =================




#=============针对项目的配置 结束=================
