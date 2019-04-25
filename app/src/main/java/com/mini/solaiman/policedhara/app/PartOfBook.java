package com.mini.solaiman.policedhara.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
import com.mini.solaiman.policedhara.DBHelper.MyDatabase;
import com.mini.solaiman.policedhara.PdfActivity;
import com.mini.solaiman.policedhara.R;
import com.mini.solaiman.policedhara.model.SampleSearchModel;
import com.mini.solaiman.policedhara.partfour;

import java.util.ArrayList;
import java.util.List;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class PartOfBook extends AppCompatActivity {
    private Button btn_1;
    private Button btn_2;
    private Button btn_3, searchBtn;
    private MyDatabase db;
    private TextView menuText;
    private List<String> Books;
    CircleMenu circleMenu;
    ArrayList<String> items = new ArrayList<>();
    SpinnerDialog spinnerDialog;
    String text, pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_of_book);

        //Typeface headType = Typeface.createFromAsset(getAssets(),"fonts/SUTOM___.TTF");
        Typeface typeButton = Typeface.createFromAsset(getAssets(), "fonts/BenSenHandwriting.ttf");


        TextView head = (TextView) findViewById(R.id.headLine);
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        //menuText  =(TextView)findViewById(R.id.menuText);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.plus, R.drawable.cross)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.about)
                //.addSubMenu(Color.parseColor("#FF7F00"), R.drawable.office)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {
                        //Toast.makeText(PartOfBook.this,"selection "+index,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PartOfBook.this, AboutApp.class);
                        startActivity(intent);
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {
                Toast.makeText(PartOfBook.this, "About App", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onMenuClosed() {
            }

        });

        db = new MyDatabase(this);
        db.forceDatabaseReload(this);
        Books = db.getSearch();

        spinnerDialog = new SpinnerDialog(PartOfBook.this, createSampleData(), "আনুসন্ধান (প্রথম অধ্যায়)", R.style.DialogAnimations_SmileWindow, "Close");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                try {
                    if ((item.contains("প্রবিধান ১০৩৯")) || (item.contains("প্রবিধান ৮৮২"))
                            || (item.contains("প্রবিধান ৯২৭")) || (item.contains("প্রবিধান ৬০৬")) || (item.contains("প্রবিধান ১১০১")) || (item.contains("প্রবিধান ১১০৭"))
                            ) {
                        Intent intent = new Intent(PartOfBook.this, HtmlActivity.class);
                        intent.putExtra("query", item.toString());
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(PartOfBook.this, ReadActivity.class);
                        intent.putExtra("query", item.toString());
                        startActivity(intent);
                    }
                } catch (Exception e) {
                }
            }
        });
        searchBtn = (Button) findViewById(R.id.search);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerDialog.showSpinerDialog();
            }
        });

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setTypeface(typeButton);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackCon.selectedActivity = 1;
                Intent intent = new Intent(PartOfBook.this, ThirdActivity.class);
                text = "partone";
                pos = "1";
                intent.putExtra("part", text);
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        });
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setTypeface(typeButton);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartOfBook.this, VolumeTwo.class);
                text = "n";
                pos = "4";
                intent.putExtra("part", text);
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        });
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setTypeface(typeButton);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackCon.selectedActivity = 3;
                Intent intent = new Intent(PartOfBook.this, ThirdActivity.class);
                text = "x";
                pos = "3";
                intent.putExtra("part", text);
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        });
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setTypeface(typeButton);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartOfBook.this, partfour.class);
                startActivity(intent);
            }
        });

    }


    private ArrayList<String> createSampleData() {
        ArrayList<String> items = new ArrayList<>();

        for (String text : Books) {
            if (text != null) {
                items.add(text);
            }
        }
        return items;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
