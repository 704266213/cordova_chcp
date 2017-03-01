package com.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaInterfaceImpl;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.LOG;
import org.apache.cordova.engine.SystemWebView;
import org.apache.cordova.engine.SystemWebViewEngine;

import java.util.concurrent.ExecutorService;

public class ToastActivity extends CordovaActivity implements CordovaInterface {

    private SystemWebView systemWebView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        // 方法一
//        initWebView();

        //方法二
        loadUrl("file:///android_asset/www/index.html");
    }


    protected CordovaWebView makeWebView() {
        systemWebView = (SystemWebView) findViewById(R.id.systemWebView);
        return new CordovaWebViewImpl(new SystemWebViewEngine(systemWebView));
    }

    /*
     * 禁止创建appView
     */
    protected void createViews() {

    }

    /*
    * 无需继承CordovaActivity
    */
    private void initWebView() {
        LOG.setLogLevel(LOG.DEBUG);//设置日志级别
        systemWebView = (SystemWebView) findViewById(R.id.systemWebView);
        ConfigXmlParser parser = new ConfigXmlParser();
        parser.parse(this);//这里会解析res/xml/config.xml配置文件
        CordovaWebView cordovaWebView = new CordovaWebViewImpl(new SystemWebViewEngine(systemWebView));//创建一个cordovawebview
        cordovaWebView.init(new CordovaInterfaceImpl(this), parser.getPluginEntries(), parser.getPreferences());//初始化
        systemWebView.loadUrl("file:///android_asset/www/index.html");
    }



    @Override
    public void startActivityForResult(CordovaPlugin command, Intent intent, int requestCode) {

    }

    @Override
    public void setActivityResultCallback(CordovaPlugin plugin) {

    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public ExecutorService getThreadPool() {
        return null;
    }

    @Override
    public void requestPermission(CordovaPlugin plugin, int requestCode, String permission) {

    }

    @Override
    public void requestPermissions(CordovaPlugin plugin, int requestCode, String[] permissions) {

    }

    @Override
    public boolean hasPermission(String permission) {
        return false;
    }
}
