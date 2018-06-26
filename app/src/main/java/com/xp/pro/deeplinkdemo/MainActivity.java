package com.xp.pro.deeplinkdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openNative=(Button) findViewById(R.id.activity_main_open_native);
        Button openHtml=(Button) findViewById(R.id.activity_main_open_html);
        openNative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNativeFormNative();
            }
        });
        openHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNativeFormHtml();
            }
        });
    }

    /**
     * deeplink 原生启动原生页面，可支持跨应用启动。
     */
    private void openNativeFormNative() {
        String url = "xp://detail";
        Uri uri = Uri.parse(url);
        Toast.makeText(MainActivity.this, "Native open Android Native App success!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.setData(uri);
        startActivity(intent);
    }

    /**
     * deeplink Html启动原生页面，可支持服务器访问Html启动原生页面。
     */
    private void openNativeFormHtml() {
        WebView activityDataWebview = (WebView) findViewById(R.id.activity_main_webview);
        // 设置setWebChromeClient对象
        activityDataWebview.setWebChromeClient(new WebChromeClient());
        activityDataWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //通过外部浏览器启动可不写此部分
                String url = request.getUrl().toString();
                Uri uri = Uri.parse(url);
                if (uri.getScheme().equals("xp") && uri.getHost().equals("detail")) {
                    Toast.makeText(MainActivity.this, "HTML open Android native App success!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setData(uri);
                    startActivity(intent);
                } else
                    {
                    view.loadUrl(url);
                }
                return true;
            }
        });
        activityDataWebview.loadUrl("file:///android_asset/detail.html");
    }
}
