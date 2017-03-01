package com.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterfaceImpl;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.LOG;
import org.apache.cordova.engine.SystemWebChromeClient;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewClient;
import org.apache.cordova.engine.SystemWebViewEngine;

public class NetActivity extends AppCompatActivity {

    private SystemWebView systemWebView;
    private SystemWebViewEngine systemWebViewEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        initWebView();
    }


    /*
   * 无需继承CordovaActivity
   */
    private void initWebView() {
        LOG.setLogLevel(LOG.DEBUG);//设置日志级别
        systemWebView = (SystemWebView) findViewById(R.id.systemWebView);
        systemWebView.getSettings().setJavaScriptEnabled(true);

        ConfigXmlParser parser = new ConfigXmlParser();
//        new WhitelistPlugin();
        parser.parse(this);//这里会解析res/xml/config.xml配置文件
        systemWebViewEngine = new SystemWebViewEngine(systemWebView);
        //创建一个cordovawebview
        CordovaWebView cordovaWebView = new CordovaWebViewImpl(systemWebViewEngine);
        cordovaWebView.init(new CordovaInterfaceImpl(this), parser.getPluginEntries(), parser.getPreferences());//初始化
//        systemWebView.loadUrl("file:///android_asset/www/index.html");
        systemWebView.loadUrl("http://192.168.230.2:8080/work/index.html");

        systemWebView.setWebViewClient(new SystemWebViewClient(systemWebViewEngine){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.e("XLog","=====================");
                return true;
            }
        });

        systemWebView.setWebChromeClient(new SystemWebChromeClient(systemWebViewEngine){
            public void onProgressChanged(WebView view, int newProgress) {
                Log.e("XLog","=====================" + newProgress);

                Log.e("XLog","=====================" + view.getUrl());

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        systemWebViewEngine.destroy();
    }
}
