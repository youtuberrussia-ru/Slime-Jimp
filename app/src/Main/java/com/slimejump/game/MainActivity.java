
package com.slimejump.game;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.view.View;
import android.graphics.Color;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(16, 27, 25));
        getWindow().setNavigationBarColor(Color.rgb(16, 27, 25));

        webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(16, 27, 25));

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        webView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        setContentView(webView);

        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (webView != null) {
            webView.evaluateJavascript(
                "if(typeof state !== 'undefined') state='menu';",
                null
            );
        }
        super.onBackPressed();
    }
}
