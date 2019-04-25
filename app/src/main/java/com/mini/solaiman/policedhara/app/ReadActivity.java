package com.mini.solaiman.policedhara.app;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;
import com.mini.solaiman.policedhara.DBHelper.MyDatabase;
import com.mini.solaiman.policedhara.R;
import dmax.dialog.SpotsDialog;

public class ReadActivity extends AppCompatActivity {
    private static int timer = 2000;
    private MyDatabase db;
    private String title;
    private String titleE;
    String textB, textE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        final SpotsDialog waitingDialog = new SpotsDialog(ReadActivity.this, R.style.Custom);
        waitingDialog.show();
        //Toast.makeText(ReadActivity.this,"Title Loadesd",Toast.LENGTH_LONG).show();
        Intent intent = getIntent();

        String id = intent.getStringExtra("query");
        String name = intent.getStringExtra("name");
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/SolaimanLipi.ttf");
        Typeface typeHB = Typeface.createFromAsset(getAssets(), "fonts/BenSenHandwriting.ttf");
        Typeface typeHE = Typeface.createFromAsset(getAssets(), "fonts/englishHand.otf");
        Typeface typeE = Typeface.createFromAsset(getAssets(), "fonts/SolaimanLipi.ttf");
        if ("x".equals(name)) {

            try {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        waitingDialog.dismiss();
                    }
                }, timer);
                db = new MyDatabase(this);
                //db.forceDatabaseReload(this);
                textB = db.getDescb(id, "DESCB");
                TextView tlb = (TextView) findViewById(R.id.textViewHead);
                tlb.setText(id);
                TextView tv = (TextView) findViewById(R.id.textView);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    tv.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
                }
                tv.setText(textB);
                tv.setTypeface(type);
            } catch (Exception e) {

            }
        } else {

            //Toast.makeText(ReadActivity.this,id,Toast.LENGTH_LONG).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    waitingDialog.dismiss();
                }
            }, timer);
            db = new MyDatabase(this);
            db.forceDatabaseReload(this);
            title = db.getDescb(id, "HEADB");
            if (title.contains("select * from")) {

                // Toast.makeText(ReadActivity.this, "error found with pattern", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < id.length(); i++) {
                    if (id.contains("।")) {
                        int a = id.indexOf('।');
                        if (a > 0) {
                            Toast.makeText(ReadActivity.this, String.valueOf(id.charAt(a)), Toast.LENGTH_SHORT).show();
                            StringBuilder myString = new StringBuilder(id);
                            myString.setCharAt(a, '৷');
                            id = String.valueOf(myString);
                            title = db.getDescb(id, "HEADB");
                            //Toast.makeText(ReadActivity.this,id,Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
            }
            titleE = db.getDescb(id, "HEADE");
            textB = db.getDescb(id, "DESCB");
            textE = db.getDescb(id, "DESCE");
        }

        TextView tlb = (TextView) findViewById(R.id.textViewHead);
        TextView tle = (TextView) findViewById(R.id.textViewHeadE);
        TextView tv = (TextView) findViewById(R.id.textView);
        TextView tvE = (TextView) findViewById(R.id.textViewEng);
        tv.setMovementMethod(new ScrollingMovementMethod());
        tvE.setMovementMethod(new ScrollingMovementMethod());
        tlb.setText(title);
        tlb.setTypeface(typeHB);
        tv.setText(textB);
        tv.setTypeface(type);
        //textview.setText(html.fromHtml("<html><body><p align=justify>your text</p></body></html>"));
        tle.setText(titleE);
        tle.setTypeface(typeHE);
        tvE.setText(textE);
        tvE.setTypeface(type);
    }
}
