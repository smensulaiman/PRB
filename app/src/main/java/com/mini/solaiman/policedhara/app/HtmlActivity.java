package com.mini.solaiman.policedhara.app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.mini.solaiman.policedhara.DBHelper.MyDatabase;
import com.mini.solaiman.policedhara.R;

public class HtmlActivity extends AppCompatActivity {
    TextView myTextView;
    private MyDatabase db;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        Intent intent = getIntent();
        String id = intent.getStringExtra("query");

           // Toast.makeText(HtmlActivity.this,id,Toast.LENGTH_SHORT).show();

            WebView mWebView = (WebView) findViewById(R.id.webView);
            mWebView.setBackgroundColor(Color.TRANSPARENT);
            mWebView.setBackgroundResource(R.drawable.html);
            if(id.contains("প্রবিধান ১০৩৯")){
            mWebView.loadUrl("file:///android_asset/one.html");
            }else if(id.contains("প্রবিধান ৮৮২")){
            mWebView.loadUrl("file:///android_asset/882.html");
            }else if(id.contains("প্রবিধান ১১০১")){
                mWebView.loadUrl("file:///android_asset/1101.html");
            }else if(id.contains("প্রবিধান ১০১৭")){
                mWebView.loadUrl("file:///android_asset/1017.html");
            }else if(id.contains("প্রবিধান ৯২৭")){
                mWebView.loadUrl("file:///android_asset/927.html");
            }else if(id.contains("প্রবিধান ৬০৬")){
                mWebView.loadUrl("file:///android_asset/606.html");
            }else if(id.contains("প্রবিধান ১১৪৭")){
                mWebView.loadUrl("file:///android_asset/1147.html");
            }else{
               // mWebView.loadUrl("file:///android_asset/"+id+".html");
                String text = HtmlText.data();
                mWebView.loadUrl("file:///android_asset/new.html");
                //mWebView.loadData(text, "text/html; charset=utf-8","UTF-8");
            }
        }
    }
