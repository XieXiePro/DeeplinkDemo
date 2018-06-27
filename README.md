##使用DeepLink技术唤醒 App

&emsp;&emsp;移动互联时代，手机作为我们日常交流的主要媒介，搭载了许许多多的移动应用程序，这些五花八门的应用程序极大的丰富了我们的生活。目前主流移动应用程序主要有Native App和Web App两种实现形式，其中Native App具有良好的用户黏性和操作体验。本篇针对从浏览器、短信、甚至是在其他APP中唤醒Native APP的需求，帮助Native App开发者为用户提供更好的交互体验，从而建立更稳固的用户关系。

### 一、Native APP唤醒场景
###### 1、浏览器 -> 唤醒APP
&emsp;&emsp;用户A在手机上通过浏览器打开了某APP的M站或者官网，则引导用户打开该APP或者下载该APP。
###### 2、微信、QQ等 -> 唤醒APP
&emsp;&emsp;用户通过某APP分享了一条链接至微信或QQ，用户B点开该链接后，引导用户B打开该APP或者下载该APP。
###### 3、短信、邮件、二维码等-> 唤醒APP
&emsp;&emsp;用户A打开了某APP的推广短信，邮件或者扫描二维码等，引导用户打开该APP或者下载该APP。
###### 4、其他APP -> 唤醒APP
&emsp;&emsp;用户A通过第三方APP分享了一条链接至用户B，用户B点开该链接后，引导用户B打开指定APP或者下载指定APP。

### 二、那么移动平台提供了哪些唤醒APP的方法呢？

目前常见的唤醒APP方式有几种：

###### 1、URL Scheme
&emsp;&emsp;URL Scheme是iOS，Android平台都支持，只需要原生APP开发时注册scheme， 那么用户点击到此类链接时，会自动唤醒APP，借助于URL Router机制，则还可以跳转至指定页面。
&emsp;&emsp;这种方式是当前使用最广泛，也是最简单的，但是需要手机，APP支持URL Scheme。
&emsp;&emsp;优点： 开发成本低，绝大多数都支持，web-native协议制定也简单。
&emsp;&emsp;缺点： 错误处理情况因平台不同，难以统一处理，部分APP会直接跳错误页（比如Android Chrome/41，iOS中老版的Lofter）；也有的停留在原页面，但弹出提示“无法打开网页”（比如iOS7）；iOS8以及最新的Android Chrome/43 目前都是直接停留在当前页，不会跳出错误提示。
支持情况： iOS在实际使用中，腾讯系的微信，QQ明确禁止使用，iOS9以后Safari不再支持通过js，iframe等来触发scheme跳转，并且还加入了确认机制，使得通过js超时机制来自动唤醒APP的方式基本不可用；Android平台则各个app厂商差异很大，比如Chrome从25及以后就同Safari情况一样。
###### 2、Universal Links
&emsp;&emsp;在2015年的WWDC大会上，Apple推出了iOS 9的一个功能：Universal Links[通用链接](https://link.jianshu.com?t=https://developer.apple.com/library/ios/documentation/General/Conceptual/AppSearch/UniversalLinks.html#//apple_ref/doc/uid/TP40016308-CH12-SW2)。如果你的App支持Universal Links，那就可以访问HTTP/HTTPS链接直接唤起APP进入具体页面，不需要其他额外判断；如果未安装App，访问此通用链接时，可以一个自定义网页。

###### 3、Android App Links
&emsp;&emsp;在2015年的Google I/O大会上，Android M宣布了一个新特性：[App Links](https://link.jianshu.com?t=https://developer.android.com/training/app-links/index.html)让用户在点击一个普通web链接的时候可以打开指定APP的指定页面，前提是这个APP已经安装并且经过了验证，否则会显示一个打开确认选项的弹出框。在推动deep linking上Google和Apple可谓英雄所见略同，优缺点也大致相同，只支持Android M以上系统。

&emsp;&emsp;总结以上各种方案从长远趋势来看都是Deep Links技术，都需要

*   **一个支持HTTPS的Web站**

### 三、DeepLink相关技术和产品
&emsp;&emsp;目前市面移动DeepLink相关技术和产品，包括系统基础技术，巨头产品，创新产品，图示如下。

![Deep Link技术产品栈](https://upload-images.jianshu.io/upload_images/2783386-92fe1a991309d25c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 四、DeepLink全方位解析
&emsp;&emsp;所谓DeepLink（深度链接）就是支持在移动App自由跳转的技术，在PC的Web时代，这个问题简化一个HTTP地址。到了移动时代，这个问题变得复杂起来，移动操作系统有多家，各家处理应用间跳转的底层技术都不一样，调用方式、代码都不同，支持的力度也不同。目前也没有任何行业协会致力于解决这个问题，没有像W3C组织解决Web的规范化。

1，什么是deeplink?什么是applink?两者的关系和区别是什么？
&emsp;&emsp;deeplink是从拦截外部请求到app内并定位到具体页面的技术.
&emsp;&emsp;简单讲，就是你在手机上点击一个链接之后，可以直接链接到app内部的某个页面，而不是app正常打开时显示的首页。不似web，一个链接就可以直接打开web的内页，app的内页打开，必须用到deeplink技术。

2，deeplink的作用是什么？
&emsp;&emsp;deeplink能够将外部流量引导到app内, 并提供连贯的浏览体验, 实在是引流的大杀器.
&emsp;&emsp;deeplink还做高效的流量分发. 通过外部url的投放和内部拦截, 可以针对不同场景直接分发流量到具体页面, 将用户直接引导到各个垂直频道.

3，有哪些比较成熟的解决方案？
&emsp;&emsp;魔窗等

4，安全性如何？
[Android Intent Scheme URLs攻击](http://blog.csdn.net/l173864930/article/details/36951805)
### 五、技术实现
下面以Android为例实现浏览器唤醒APP。

一）浏览器唤醒APP
1，首先创建Android工程。
![deeplink demo](https://upload-images.jianshu.io/upload_images/2783386-3c3e419d8b4c5a1d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2，新建DeepLinkActivity，并在清单文件中配置如下：
```
 <!--&lt;!&ndash; Accepts URIs that begin with "example://gizmos” &ndash;&gt;-->
        <!--<data android:scheme="example"-->
        <!--android:host="gizmos" />-->
        <!--&lt;!&ndash; Accepts URIs that begin with "http://www.example.com/gizmos” &ndash;&gt;-->
        <!--<data-->
        <!--android:host="www.xp.pro.deeplinkdemo"-->
        <!--android:pathPrefix="/gizmos"-->
        <!--android:scheme="http" />-->
        <activity android:name=".DeepLinkActivity">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <!-- Accepts URIs that begin with "example://gizmos” -->
                <data
                    android:host="detail"
                    android:scheme="xp" />
            </intent-filter>
        </activity>
```
3，网页中使用如下代码，打开app指定页面：
```
<a href="xp://detail">打开详情</a>
```
4，在app中接收html打开原生页面请求：
```
 activityDataWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                Uri uri = Uri.parse(url);
                if (uri.getScheme().equals("xp") && uri.getHost().equals("detail")) {
                    Toast.makeText(MainActivity.this, "HTML open Android native App success!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setData(uri);
                    startActivity(intent);
                } else {
                    view.loadUrl(url);
                }
                return true;
            }
        });
```
