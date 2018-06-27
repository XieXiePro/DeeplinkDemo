package com.xp.pro.deeplinkdemo;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class JsManager {
    @JavascriptInterface
    public void openNative() {
        String url = "xp://detail";
        Log.d("openNative: ",url);
    }
}
