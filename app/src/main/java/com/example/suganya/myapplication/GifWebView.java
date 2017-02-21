package com.example.suganya.myapplication;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by Prashant on 19-03-2016.
 */
public class GifWebView extends WebView{


        public GifWebView(Context context, String path) {
            super(context);

            loadUrl(path);
        }

}
