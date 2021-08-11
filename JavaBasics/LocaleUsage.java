package JavaBasics;

public class LocaleUsage {
    //用于国际化的locale类
    //使用方法
    //获取默认的Locale
    //使用方法：
    //Locale locale = Locale.getDefault()
    //直接使用Locale的静态对象
    //使用方法：下面的Locale对象是对应 “中国(大陆)”的
    //Locale locale = Locale.SIMPLIFIED_CHINESE
    //（3）通过Locale的构造函数创建Locale对象
    //Locale的构造函数共有3个。如下：
    //Locale(String language)
    //Locale(String language, String country)
    //Locale(String language, String country, String variant)
    //使用方法：
    //Locale local = new Locale("zh", "CN");
    //要获得存储在手机SIM卡中的国家/地区代码,您可以尝试
    //TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    //telephonyManager.getSimCountryIso();
    //你也可以尝试：
    //Locale locale = Locale.getDefault();
    //locale.getCountry();
    //这将返回来自用户声明的语言/国家/地区的数据,而不是物理位置.
    //判断android设备当前设置的为什么语言使用Locale（java.util.Locale）类中getLanguage()方法；
    //一般获取到的比如中文为zh，英文为en，日文为ko；某些设备可能会返回更加具体的值，例如zh_hant。
    //要获得具体的类别使用toString()方法。
    //比如繁体为zh_TW，简体为zh_CN。英文中有en_GB；日文有ko_KR。
    //代码如下：
    //Locale.getDefault().getLanguage();
    //Locale.getDefault().toString()
    //Locale locale = context.getResources().getConfiguration().locale;
    //String language = locale.getLanguage();
    //if (language.contains("en")){
    //inputStream = context.getResources().openRawResource(R.raw.dlt645_97dataitem_en);
    //}else {
    //inputStream = context.getResources().openRawResource(R.raw.dlt645_97dataitem);
    //}

//    Java平台提供了许多执行对语言环境敏感的操作的类。例如，NumberFormat该类以对语言环境敏感的方式设置数字，货币和百分比的格式。诸如此类NumberFormat有几种方便的方法可以创建该类型的默认对象。例如， NumberFormat该类提供了以下三种方便的方法来创建默认NumberFormat对象：
//    NumberFormat.getInstance（）
//    NumberFormat.getCurrencyInstance（）
//    NumberFormat.getPercentInstance（）
//    这些方法中的每一个都有两个变体。一个带有明确的语言环境，另一个没有。后者使用默认 Locale.Category#FORMAT语言环境：
//    NumberFormat.getInstance（myLocale）
//    NumberFormat.getCurrencyInstance（myLocale）
//    NumberFormat.getPercentInstance（myLocale）
//    ALocale是用于识别NumberFormat您想要获取的对象（）类型的机制。语言环境 只是一种用于标识对象的机制， 而不是对象本身的容器。

}
