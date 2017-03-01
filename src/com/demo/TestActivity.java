package com.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaInterface;

public class TestActivity extends CordovaActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("https://www.baidu.com");

//        super.loadUrl("http://192.168.230.2:8080/work/index.html");
//        super.loadUrl("file:///android_asset/www/index.html");
    }
}
