package com.mini.solaiman.policedhara.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mini.solaiman.policedhara.DBHelper.MyDatabase;
import com.mini.solaiman.policedhara.PdfActivity;
import com.mini.solaiman.policedhara.R;
import com.mini.solaiman.policedhara.adapter.CustomListAdapterNew;
import com.mini.solaiman.policedhara.adapter.CustomListAdapterSingle;
import com.mini.solaiman.policedhara.model.Item;
import com.mini.solaiman.policedhara.model.PdfName;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ThirdActivity extends AppCompatActivity {

    private MyDatabase db;
    private List<String> Books, thirdList;
    CustomListAdapterNew adapter;
    CustomListAdapterSingle adapterSingle;
    String position, part;
    String con = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/PROTHOMA.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_third);
        BackCon.background = 0;// 3 number oddhayer background shada

        Intent intent = getIntent();
        part = intent.getStringExtra("part");
        position = intent.getStringExtra("position");

        db = new MyDatabase(this);
        //db.forceDatabaseReload(this);

        if (!"x".equals(part)) {
            try {
                Books = db.getPart(part);

            } catch (Exception e) {

            }
        } else {
            //thirdList = db.getThird("1307-1384");
            con = part;
        }
        final ListView itemsListView = (ListView) findViewById(R.id.partView);

        //create adapter object
        if ("x".equals(part) || "n".equals(part)) {
            adapterSingle = new CustomListAdapterSingle(this, generateItemsList());
        } else {
            adapter = new CustomListAdapterNew(this, generateItemsList());
        }
        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.partBtn);
                String text = textView.getText().toString();
                int j = 0;
                if ((!"x".equals(con)) && (!"n".equals(part))) {
                    if (i > 6) {
                        position = "2";
                        int temp = i;
                        i = i - 7;
                        j = temp;
                    } else {
                        position = "1";
                        j = i;
                    }
                }
                if ((!"3".equals(position)) && (!"4".equals(position))) {

                    //1 beshi hobe

                    if (j == 24) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProSeven.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 5) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProTen.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 2 || j == 6 || j == 12) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProEight.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 3) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProNine.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 7 || j == 19) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProSix.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 1 || j == 8 || j == 4 || j == 16) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProOne.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 13 || j == 14 || j == 15 || j == 22) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProTwo.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 23 || j == 9) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProThree.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                        //1 beshi hobe
                    } else if (j == 25) { //complete

                        Intent intent = new Intent(ThirdActivity.this, ProFour.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(ThirdActivity.this, NewActivity.class);
                        intent.putExtra("chapter", text);
                        intent.putExtra("posk", position);
                        intent.putExtra("check", j);
                        intent.putExtra("poso", String.valueOf(i + 1));
                        startActivity(intent);
                    }


                } else if ("n".equals(part)) {
                    textView = (TextView) view.findViewById(R.id.partBtn);
                    text = textView.getText().toString();
                    Intent intent = new Intent(ThirdActivity.this, HtmlActivity.class);
                    //intent.putExtra("chapter",text);
                    intent.putExtra("posk", position);
                    intent.putExtra("poso", String.valueOf(i + 1));
                    intent.putExtra("query", text);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ThirdActivity.this, PdfActivity.class);
                    PdfName pdf = new PdfName(text);
                    PdfZoomControlar.zoom = false;//3rd oddhaye zoom hobe na
                    startActivity(intent);
                }

            }
        });

        if ("x".equals(part) || "n".equals(part)) {
            itemsListView.setAdapter(adapterSingle);
        } else {
            itemsListView.setAdapter(adapter);
        }

    }

    private ArrayList<Item> generateItemsList() {
        ArrayList<Item> list = new ArrayList<>();
        if ((!"x".equals(con)) && (!"n".equals(part))) {
            for (String book : Books) {
                //book = "অধ্যায় ১ - সংগঠন";
                String seperate[] = book.split("-");
                list.add(new Item(seperate[0], seperate[1]));
            }
        } else if ("n".equals(part)) {

        } else {
            list.add(new Item("B. P. Form Index", ""));
            list.add(new Item("B. P. Form No. 1", ""));
            list.add(new Item("B. P. Form No. 2", ""));
            list.add(new Item("B. P. Form No. 3", ""));
            list.add(new Item("B. P. Form No. 4", ""));
            list.add(new Item("B. P. Form No. 5", ""));
            list.add(new Item("B. P. Form No. 6", ""));
            list.add(new Item("B. P. Form No. 7", ""));
            list.add(new Item("B. P. Form No. 8", ""));
            list.add(new Item("B. P. Form No. 9", ""));
            list.add(new Item("B. P. Form No. 10", ""));
            list.add(new Item("B. P. Form No. 11", ""));
            list.add(new Item("B. P. Form No. 12", ""));
            list.add(new Item("B. P. Form No. 13", ""));
            list.add(new Item("B. P. Form No. 14", ""));
            list.add(new Item("B. P. Form No. 15", ""));
            list.add(new Item("B. P. Form No. 16", ""));
            list.add(new Item("B. P. Form No. 17", ""));
            list.add(new Item("B. P. Form No. 18", ""));
            list.add(new Item("B. P. Form No. 19", ""));
            list.add(new Item("B. P. Form No. 20", ""));
            list.add(new Item("B. P. Form No. 21", ""));
            list.add(new Item("B. P. Form No. 22", ""));
            list.add(new Item("B. P. Form No. 23", ""));
            list.add(new Item("B. P. Form No. 24", ""));
            list.add(new Item("B. P. Form No. 25", ""));
            list.add(new Item("B. P. Form No. 26", ""));
            list.add(new Item("B. P. Form No. 27", ""));
            list.add(new Item("B. P. Form No. 27-A", ""));
            list.add(new Item("B. P. Form No. 28", ""));
            list.add(new Item("B. P. Form No. 29", ""));
            list.add(new Item("B. P. Form No. 30", ""));
            list.add(new Item("B. P. Form No. 31", ""));
            list.add(new Item("B. P. Form No. 32", ""));
            list.add(new Item("B. P. Form No. 33", ""));
            list.add(new Item("B. P. Form No. 34", ""));
            list.add(new Item("B. P. Form No. 35", ""));
            list.add(new Item("B. P. Form No. 36", ""));
            list.add(new Item("B. P. Form No. 37", ""));
            list.add(new Item("B. P. Form No. 37-A", ""));
            list.add(new Item("B. P. Form No. 38", ""));
            list.add(new Item("B. P. Form No. 39", ""));
            list.add(new Item("B. P. Form No. 40", ""));
            list.add(new Item("B. P. Form No. 40-A", ""));
            list.add(new Item("B. P. Form No. 41", ""));
            list.add(new Item("B. P. Form No. 41-A", ""));
            list.add(new Item("B. P. Form No. 42", ""));
            list.add(new Item("B. P. Form No. 43", ""));
            list.add(new Item("B. P. Form No. 43-A", ""));
            list.add(new Item("B. P. Form No. 44", ""));
            list.add(new Item("B. P. Form No. 45", ""));
            list.add(new Item("B. P. Form No. 46", ""));
            list.add(new Item("B. P. Form No. 47", ""));
            list.add(new Item("B. P. Form No. 48", ""));
            list.add(new Item("B. P. Form No. 49", ""));
            list.add(new Item("B. P. Form No. 50", ""));
            list.add(new Item("B. P. Form No. 51", ""));
            list.add(new Item("B. P. Form No. 52", ""));
            list.add(new Item("B. P. Form No. 53", ""));
            list.add(new Item("B. P. Form No. 54", ""));
            list.add(new Item("B. P. Form No. 55", ""));
            list.add(new Item("B. P. Form No. 56", ""));
            list.add(new Item("B. P. Form No. 57", ""));
            list.add(new Item("B. P. Form No. 58", ""));
            list.add(new Item("B. P. Form No. 59", ""));
            list.add(new Item("B. P. Form No. 60", ""));
            list.add(new Item("B. P. Form No. 61", ""));
            list.add(new Item("B. P. Form No. 62", ""));
            list.add(new Item("B. P. Form No. 63", ""));
            list.add(new Item("B. P. Form No. 64", ""));
            list.add(new Item("B. P. Form No. 65", ""));
            list.add(new Item("B. P. Form No. 66", ""));
            list.add(new Item("B. P. Form No. 67", ""));
            list.add(new Item("B. P. Form No. 68", ""));
            list.add(new Item("B. P. Form No. 69", ""));
            list.add(new Item("B. P. Form No. 70", ""));
            list.add(new Item("B. P. Form No. 71", ""));
            list.add(new Item("B. P. Form No. 72", ""));
            list.add(new Item("B. P. Form No. 73", ""));
            list.add(new Item("B. P. Form No. 74", ""));
            list.add(new Item("B. P. Form No. 75", ""));
            list.add(new Item("B. P. Form No. 76", ""));
            list.add(new Item("B. P. Form No. 77", ""));
            list.add(new Item("B. P. Form No. 78", ""));
            list.add(new Item("B. P. Form No. 79", ""));
            list.add(new Item("B. P. Form No. 80", ""));
            list.add(new Item("B. P. Form No. 81", ""));
            list.add(new Item("B. P. Form No. 82", ""));
            //list.add(new Item("B. P. Form No. 82-A", ""));
            list.add(new Item("B. P. Form No. 83", ""));
            list.add(new Item("B. P. Form No. 84", ""));
            list.add(new Item("B. P. Form No. 85", ""));
            list.add(new Item("B. P. Form No. 86", ""));
            list.add(new Item("B. P. Form No. 87", ""));
            list.add(new Item("B. P. Form No. 88", ""));
            list.add(new Item("B. P. Form No. 89", ""));
            list.add(new Item("B. P. Form No. 90", ""));
            list.add(new Item("B. P. Form No. 91", ""));
            list.add(new Item("B. P. Form No. 92", ""));
            list.add(new Item("B. P. Form No. 93", ""));
            list.add(new Item("B. P. Form No. 94", ""));
            list.add(new Item("B. P. Form No. 94-A", ""));
            list.add(new Item("B. P. Form No. 95", ""));
            list.add(new Item("B. P. Form No. 96", ""));
            list.add(new Item("B. P. Form No. 97", ""));
            list.add(new Item("B. P. Form No. 98", ""));
            list.add(new Item("B. P. Form No. 99", ""));
            list.add(new Item("B. P. Form No. 100", ""));
            list.add(new Item("B. P. Form No. 101", ""));
            list.add(new Item("B. P. Form No. 102", ""));
            list.add(new Item("B. P. Form No. 103", ""));
            list.add(new Item("B. P. Form No. 104", ""));
            list.add(new Item("B. P. Form No. 105", ""));
            list.add(new Item("B. P. Form No. 106", ""));
            list.add(new Item("B. P. Form No. 107", ""));
            list.add(new Item("B. P. Form No. 108", ""));
            list.add(new Item("B. P. Form No. 109", ""));
            list.add(new Item("B. P. Form No. 110", ""));
            //list.add(new Item("B. P. Form No. 110-2", ""));
            //list.add(new Item("B. P. Form No. 110-A", ""));
            list.add(new Item("B. P. Form No. 111", ""));
            list.add(new Item("B. P. Form No. 112", ""));
            list.add(new Item("B. P. Form No. 113", ""));
            list.add(new Item("B. P. Form No. 114", ""));
            list.add(new Item("B. P. Form No. 115", ""));
            list.add(new Item("B. P. Form No. 116", ""));
            list.add(new Item("B. P. Form No. 117", ""));
            list.add(new Item("B. P. Form No. 118", ""));
            list.add(new Item("B. P. Form No. 119", ""));
            list.add(new Item("B. P. Form No. 120", ""));
            list.add(new Item("B. P. Form No. 121", ""));
            list.add(new Item("B. P. Form No. 122", ""));
            list.add(new Item("B. P. Form No. 123", ""));
            list.add(new Item("B. P. Form No. 124", ""));
            //list.add(new Item("B. P. Form No. 124-A", ""));
            list.add(new Item("B. P. Form No. 125", ""));
            list.add(new Item("B. P. Form No. 126", ""));
            list.add(new Item("B. P. Form No. 127", ""));
            list.add(new Item("B. P. Form No. 128", ""));
            //list.add(new Item("B. P. Form No. 128-A", ""));
            list.add(new Item("B. P. Form No. 129", ""));
            list.add(new Item("B. P. Form No. 130", ""));
            list.add(new Item("B. P. Form No. 131", ""));
            list.add(new Item("B. P. Form No. 132", ""));
            list.add(new Item("B. P. Form No. 133", ""));
            list.add(new Item("B. P. Form No. 134", ""));
            list.add(new Item("B. P. Form No. 135", ""));
            list.add(new Item("B. P. Form No. 136", ""));
            list.add(new Item("B. P. Form No. 137", ""));
            list.add(new Item("B. P. Form No. 138", ""));
            list.add(new Item("B. P. Form No. 139", ""));
            list.add(new Item("B. P. Form No. 140", ""));
            list.add(new Item("B. P. Form No. 141", ""));
            list.add(new Item("B. P. Form No. 142", ""));
            list.add(new Item("B. P. Form No. 143", ""));
            list.add(new Item("B. P. Form No. 144", ""));
            list.add(new Item("B. P. Form No. 145", ""));
            list.add(new Item("B. P. Form No. 146", ""));
            list.add(new Item("B. P. Form No. 147", ""));
            list.add(new Item("B. P. Form No. 148", ""));
            list.add(new Item("B. P. Form No. 149", ""));
            list.add(new Item("B. P. Form No. 150", ""));
            list.add(new Item("B. P. Form No. 151", ""));
            list.add(new Item("B. P. Form No. 152", ""));
            list.add(new Item("B. P. Form No. 153", ""));
            list.add(new Item("B. P. Form No. 154", ""));
            list.add(new Item("B. P. Form No. 155", ""));
            list.add(new Item("B. P. Form No. 156", ""));
            list.add(new Item("B. P. Form No. 157", ""));
            list.add(new Item("B. P. Form No. 158", ""));
            list.add(new Item("B. P. Form No. 159", ""));
            list.add(new Item("B. P. Form No. 160", ""));
            list.add(new Item("B. P. Form No. 161", ""));
            list.add(new Item("B. P. Form No. 162", ""));
            list.add(new Item("B. P. Form No. 163", ""));
            list.add(new Item("B. P. Form No. 164", ""));
            list.add(new Item("B. P. Form No. 164-A", ""));
            list.add(new Item("B. P. Form No. 165", ""));
            list.add(new Item("B. P. Form No. 166", ""));
            list.add(new Item("B. P. Form No. 167", ""));
            list.add(new Item("B. P. Form No. 168", ""));
            list.add(new Item("B. P. Form No. 169", ""));
            list.add(new Item("B. P. Form No. 170", ""));
            list.add(new Item("B. P. Form No. 171", ""));
            list.add(new Item("B. P. Form No. 172", ""));
            list.add(new Item("B. P. Form No. 173", ""));
            list.add(new Item("B. P. Form No. 174", ""));
            list.add(new Item("B. P. Form No. 175", ""));
            list.add(new Item("B. P. Form No. 176", ""));
            list.add(new Item("B. P. Form No. 177", ""));
            list.add(new Item("B. P. Form No. 178", ""));
            list.add(new Item("B. P. Form No. 179", ""));
            list.add(new Item("B. P. Form No. 180", ""));
            list.add(new Item("B. P. Form No. 181", ""));
            list.add(new Item("B. P. Form No. 182", ""));
            list.add(new Item("B. P. Form No. 183", ""));
            list.add(new Item("B. P. Form No. 184", ""));
            list.add(new Item("B. P. Form No. 185", ""));
            list.add(new Item("B. P. Form No. 186", ""));
            list.add(new Item("B. P. Form No. 187", ""));
            list.add(new Item("B. P. Form No. 188", ""));
            list.add(new Item("B. P. Form No. 189", ""));
            list.add(new Item("B. P. Form No. 190", ""));
            list.add(new Item("B. P. Form No. 191", ""));
            list.add(new Item("B. P. Form No. 192", ""));
            list.add(new Item("B. P. Form No. 193", ""));
            list.add(new Item("B. P. Form No. 194", ""));
            list.add(new Item("B. P. Form No. 195", ""));
            list.add(new Item("B. P. Form No. 196", ""));
            list.add(new Item("B. P. Form No. 197", ""));
            list.add(new Item("B. P. Form No. 198", ""));
            list.add(new Item("B. P. Form No. 199", ""));
            list.add(new Item("B. P. Form No. 200", ""));
            list.add(new Item("B. P. Form No. 201", ""));
            list.add(new Item("B. P. Form No. 202", ""));
            list.add(new Item("B. P. Form No. 203", ""));
            list.add(new Item("B. P. Form No. 204", ""));
            list.add(new Item("B. P. Form No. 205", ""));
            list.add(new Item("B. P. Form No. 206", ""));
            list.add(new Item("B. P. Form No. 207", ""));
            list.add(new Item("B. P. Form No. 208", ""));
            list.add(new Item("B. P. Form No. 209", ""));
            list.add(new Item("B. P. Form No. 210", ""));
            list.add(new Item("B. P. Form No. 211", ""));
            list.add(new Item("B. P. Form No. 212", ""));
            list.add(new Item("B. P. Form No. 213", ""));
            list.add(new Item("B. P. Form No. 214", ""));
            list.add(new Item("B. P. Form No. 215", ""));
            list.add(new Item("B. P. Form No. 216", ""));
            list.add(new Item("B. P. Form No. 217", ""));
            list.add(new Item("B. P. Form No. 218", ""));
            list.add(new Item("B. P. Form No. 219", ""));
            list.add(new Item("B. P. Form No. 220", ""));
            list.add(new Item("B. P. Form No. 221", ""));
            list.add(new Item("B. P. Form No. 222", ""));
            list.add(new Item("B. P. Form No. 223", ""));
            list.add(new Item("B. P. Form No. 224", ""));
            list.add(new Item("B. P. Form No. 225", ""));
            list.add(new Item("B. P. Form No. 226", ""));
            list.add(new Item("B. P. Form No. 227", ""));
            list.add(new Item("B. P. Form No. 228", ""));
            list.add(new Item("B. P. Form No. 229", ""));
            list.add(new Item("B. P. Form No. 230", ""));
            list.add(new Item("B. P. Form No. 231", ""));
            list.add(new Item("B. P. Form No. 232", ""));
            list.add(new Item("B. P. Form No. 233", ""));
            list.add(new Item("B. P. Form No. 234", ""));
            list.add(new Item("B. P. Form No. 235", ""));
            list.add(new Item("B. P. Form No. 236", ""));
            list.add(new Item("B. P. Form No. 237", ""));
            list.add(new Item("B. P. Form No. 238", ""));
            list.add(new Item("B. P. Form No. 239", ""));
            list.add(new Item("B. P. Form No. 240", ""));
            list.add(new Item("B. P. Form No. 241", ""));
            list.add(new Item("B. P. Form No. 242", ""));
            list.add(new Item("B. P. Form No. 243", ""));
            list.add(new Item("B. P. Form No. 244", ""));
            list.add(new Item("B. P. Form No. 245", ""));
            list.add(new Item("B. P. Form No. 246", ""));
            list.add(new Item("B. P. Form No. 247", ""));
            list.add(new Item("B. P. Form No. 248", ""));



            //list.add(new Item("Remands form", ""));
            list.add(new Item("Criminal Data Enrollment Form", ""));
            list.add(new Item("Information of mission officer", ""));
            list.add(new Item("Integrated CDMS User Identification Form", ""));
            list.add(new Item("NOC", ""));
            list.add(new Item("Online News Archive Management User Identification Form", ""));
            list.add(new Item("PIMS user login Form", ""));
            list.add(new Item("Police database id card", ""));
            list.add(new Item("Police Id no", ""));
            list.add(new Item("PVC ID CARD DIRECTION", ""));
            list.add(new Item("PVC ID Card", ""));
            list.add(new Item("Web based PIMS User Identification Form", ""));

            list.add(new Item("কি কি করা উচিত ও কি কি করা উচিত নয়", ""));
            list.add(new Item("ফৌজদারি কার্যবিধির ১৭২ ধারা অনুযায়ী কেস ডায়েরী", ""));

            //list.add(new Item("বিপি ফরম – ২০৯", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫৪০৩", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫৩৮১", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫৩৩৩", ""));
            list.add(new Item("বিপি ফরম –১৩৮", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫২১১", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫২৮৩", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫২৮৪", ""));
            list.add(new Item("বাংলাদেশ ফরম- ৫২২৮৫", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫২৮৮", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫৩৮৭", ""));
            list.add(new Item("বাংলাদেশ ফরম - ৫২০০", ""));
            list.add(new Item("পিআরবি ৩০০", ""));
            list.add(new Item("হাসপাতাল ছুটির হিসাব", ""));
            list.add(new Item("মঞ্জুরীকৃত ছুটি সংক্ষিপ্ত বিবরণ", ""));
            list.add(new Item("চাকুরীর প্রতিবেদন", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫০", ""));
            list.add(new Item("রেফারেন্স সহকারীর নথি নিবন্ধন বই", ""));
            list.add(new Item("বাংলাদেশ ফরম – ৫৪৪৯ এম (বড়)", ""));
            list.add(new Item("মনোগ্রাম ফরম", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৭৬", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৮৫", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৮৯", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯০", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯২", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯৩", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯৪", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯৫", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯৬", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯৭", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯৮", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ১৯৯৯", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০০০", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০০১", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০০২", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০০৩", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০০৪", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০০৫", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০০৬", ""));
            list.add(new Item("প্রজ্ঞাপনঃ ২০১২", ""));

        }
        return list;
    }
}
