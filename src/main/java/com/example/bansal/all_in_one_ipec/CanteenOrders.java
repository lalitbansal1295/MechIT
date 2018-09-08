package com.example.bansal.all_in_one_ipec;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CanteenOrders extends AppCompatActivity {
    WebView webView2;
    SwipeRefreshLayout swipe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_notification);
        swipe2 = (SwipeRefreshLayout)findViewById(R.id.swipe);
        swipe2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        });

        WebAction();
    }
    public void WebAction() {
        webView2 = (WebView) findViewById(R.id.webView);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setAppCacheEnabled(true);
        webView2.loadUrl("https://www.zomato.com.");
        swipe2.setRefreshing(true);
        webView2.setWebViewClient(new WebViewClient(){

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                webView2.loadUrl("https://www.zomato.com.");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe2.setRefreshing(false);
            }

        });
    }
    @Override
    public void onBackPressed(){

        if (webView2.canGoBack()){
            webView2.goBack();
        }else {
            finish();
        }
    }
}

