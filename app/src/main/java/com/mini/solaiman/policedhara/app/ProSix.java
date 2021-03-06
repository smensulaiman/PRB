package com.mini.solaiman.policedhara.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mini.solaiman.policedhara.DBHelper.MyDatabase;
import com.mini.solaiman.policedhara.R;
import com.mini.solaiman.policedhara.adapter.CustomListAdapter;
import com.mini.solaiman.policedhara.model.Item;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;

public class ProSix extends AppCompatActivity {

    private MyDatabase db;
    private List<String> Books;
    ArrayList<Item> list1 = new ArrayList<>();
    ArrayList<Item> list2 = new ArrayList<>();
    ArrayList<Item> list3 = new ArrayList<>();
    ArrayList<Item> list4 = new ArrayList<>();
    ArrayList<Item> list5 = new ArrayList<>();
    ArrayList<Item> list6 = new ArrayList<>();
    TextView text1, text2, text3, text4, text5, text6;
    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_six);

        final SpotsDialog waitingDialog = new SpotsDialog(ProSix.this, R.style.Custom);
        waitingDialog.show();

        Intent intent = getIntent();
        String id = intent.getStringExtra("chapter");
        final String posk = intent.getStringExtra("posk");
        final String poso = intent.getStringExtra("poso");
        String nposo = poso;
        final String check = intent.getStringExtra("check");
        //Toast.makeText(ProSix.this,"increment "+posk,Toast.LENGTH_SHORT).show();
        c = Integer.parseInt(poso);
        if ("2".equals(posk)) {
            c += 7;
            // Toast.makeText(ProSix.this,"oddhay "+c,Toast.LENGTH_SHORT).show();
        }

        db = new MyDatabase(this);
        //db.forceDatabaseReload(this);
        Books = db.getPro(posk, String.valueOf(c), "CHAPTERS");

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);

        if (c == 8) {
            try {
                setName("১ কর্মচারীদের সাধারণ দায়িত্ব ও এখতিয়ার", "২ রেলওয়ে কর্মচারীগণের সহিত সম্পর্ক", "৩ জেলা পুলিশের সহিত সহযোগিতা", "৪ রেল-পুলিশের থানাসমূহ এবং তদন্ত ও মামলার অভিযোগ", "৫ দুর্ঘটনাসমূহ", "৬ রেজিস্টারসমূহ এবং নথিপত্র,প্রতিবেদনসমূহ এবং বিবরণীসমূহ");
                setHead(549, 564, 565, 567, 568, 585, 586, 601, 602, 603, 604, 610);
            } catch (Exception e) {

            }
        } else if (c == 20) {
            setName("১ পুলিশ অফিসারগণের উর্দি", "২ পুলিশ সার্ভিসের অফিসারগণের উর্দি", "৩ অবসরপ্রাপ্ত অফিসারগণের উর্দি পরিধান প্রসঙ্গে", "৪ অধঃস্তন পুলিশ অফিসার এবং অন্যান্যদের উর্দি", "৫ পোশাক সরবরাহ ও সংরক্ষণ", "৬ ঠিকাদার নিয়োগ, পোশাকের জন্য ইনডেন্ট,হিসাব ও কিট পরীক্ষা ইত্যাদি");
            setHead(927, 932, 933, 934, 935, 935, 936, 955, 956, 970, 971, 984);
        }
        //generateItemsList();

        final ListView itemsListView1 = (ListView) findViewById(R.id.partView1);

        CustomListAdapter adapter1 = new CustomListAdapter(this, list1);
        CustomListAdapter adapter2 = new CustomListAdapter(this, list2);
        CustomListAdapter adapter3 = new CustomListAdapter(this, list3);
        CustomListAdapter adapter4 = new CustomListAdapter(this, list4);
        CustomListAdapter adapter5 = new CustomListAdapter(this, list5);
        CustomListAdapter adapter6 = new CustomListAdapter(this, list6);

        waitingDialog.dismiss();

        itemsListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                if (i == 0 && c == 20) {
                    Intent intent = new Intent(ProSix.this, HtmlActivity.class);
                    //intent.putExtra("chapter",text);
                    intent.putExtra("posk", posk);
                    intent.putExtra("poso", poso);
                    intent.putExtra("query", text + "।" + textD);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ProSix.this, ReadActivity.class);
                    //intent.putExtra("chapter",text);
                    intent.putExtra("posk", posk);
                    intent.putExtra("poso", poso);
                    intent.putExtra("query", text + "।" + textD);
                    //intent.putExtra("query1",text+"৷"+textD);
                    startActivity(intent);
                }

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView1.setAdapter(adapter1);


        final ListView itemsListView2 = (ListView) findViewById(R.id.partView2);
        itemsListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProSix.this, ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk", posk);
                intent.putExtra("poso", poso);
                intent.putExtra("query", text + "।" + textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView2.setAdapter(adapter2);

        final ListView itemsListView3 = (ListView) findViewById(R.id.partView3);
        itemsListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProSix.this, ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk", posk);
                intent.putExtra("poso", poso);
                intent.putExtra("query", text + "।" + textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView3.setAdapter(adapter3);

        final ListView itemsListView4 = (ListView) findViewById(R.id.partView4);
        itemsListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProSix.this, ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk", posk);
                intent.putExtra("poso", poso);
                intent.putExtra("query", text + "।" + textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView4.setAdapter(adapter4);

        final ListView itemsListView5 = (ListView) findViewById(R.id.partView5);
        itemsListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProSix.this, ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk", posk);
                intent.putExtra("poso", poso);
                intent.putExtra("query", text + "।" + textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView5.setAdapter(adapter5);

        final ListView itemsListView6 = (ListView) findViewById(R.id.partView6);
        itemsListView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                if (i == 2 && c == 8) {
                    Intent intent = new Intent(ProSix.this, HtmlActivity.class);
                    //intent.putExtra("chapter",text);
                    intent.putExtra("posk", posk);
                    intent.putExtra("poso", poso);
                    intent.putExtra("query", text + "।" + textD);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ProSix.this, ReadActivity.class);
                    //intent.putExtra("chapter",text);
                    intent.putExtra("posk", posk);
                    intent.putExtra("poso", poso);
                    intent.putExtra("query", text + "।" + textD);
                    //intent.putExtra("query1",text+"৷"+textD);
                    startActivity(intent);
                }

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView6.setAdapter(adapter6);

        ListUtils.setDynamicHeight(itemsListView1);
        ListUtils.setDynamicHeight(itemsListView2);
        ListUtils.setDynamicHeight(itemsListView3);
        ListUtils.setDynamicHeight(itemsListView4);
        ListUtils.setDynamicHeight(itemsListView5);
        ListUtils.setDynamicHeight(itemsListView6);

    }

    private void setName(String s, String s1, String s2, String s3, String s4, String s5) {
        try {
            text1.setText(s);
            text2.setText(s1);
            text3.setText(s2);
            text4.setText(s3);
            text5.setText(s4);
            text6.setText(s5);
        } catch (Exception e) {

        }

    }

    /*private ArrayList<Item> generateItemsList() {
        int i = 0;
        String seperate[];
        for (String book : Books) {
            try {
                seperate = book.split("।|৷");

                // Toast.makeText(this,seperate[1],Toast.LENGTH_SHORT).show();

                if(c==3) {
                    setHead(35,46,47,52,53,56,57,67,68,68,69,74,75,81);
                    if (i <= 11) {
                        list1.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 11 && i <= 17) {
                        list2.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 17 && i <= 21) {
                        list3.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 21 && i <= 32) {
                        list4.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 32 && i <= 33) {
                        list5.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 33 && i <= 39) {
                        list6.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 39 && i <= 46) {
                        list7.add(new Item(seperate[0], seperate[1]));
                        i++;
                    }
                }else if(c==4){
                    if (i <= 22) {
                        list1.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 22 && i <= 39) {
                        list2.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 39 && i <= 50) {
                        list3.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 50 && i <= 52) {
                        list4.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 52 && i <= 60) {
                        list5.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 60 && i <= 64) {
                        list6.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 64 && i <= 108) {
                        list7.add(new Item(seperate[0], seperate[1]));
                        i++;
                    }
                }else if(c==13){
                    if (i > 46 && i <= 65) {
                        list1.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 65 && i <= 81) {
                        list2.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 81 && i <= 91) {
                        list3.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 91 && i <= 93) {
                        list4.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 93 && i <= 101) {
                        list5.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 101 && i <= 105) {
                        list6.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 105 && i <= 150) {
                        list7.add(new Item(seperate[0], seperate[1]));
                        i++;
                    }
                }else if(c==25){
                    if (i <= 11) {
                        list1.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 11 && i <= 17) {
                        list2.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 17 && i <= 21) {
                        list3.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 21 && i <= 32) {
                        list4.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 32 && i <= 33) {
                        list5.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 33 && i <= 39) {
                        list6.add(new Item(seperate[0], seperate[1]));
                        i++;
                    } else if (i > 39 && i <= 46) {
                        list7.add(new Item(seperate[0], seperate[1]));
                        i++;
                    }
                }
            }
            catch (Exception e){
                //  Toast.makeText(this,"pattern not matching",Toast.LENGTH_SHORT).show();
            }
        }

        return null;
    }*/
    // setHead(35,46,47,52,53,56,57,67,68,68,69,74,75,81);
    private void setHead(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        String seperate[];
        int j = 0;
        for (String book : Books) {
            try {
                seperate = book.split("।|৷");

                if (j <= (i1 - i)) {
                    list1.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > (i1 - i) && j <= ((i3 - i2) + 1 + (i1 - i))) {
                    list2.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i3 - i2) + 1 + (i1 - i)) && j <= ((i5 - i4) + 1 + ((i3 - i2) + 1 + (i1 - i)))) {
                    list3.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i5 - i4) + 1 + ((i3 - i2) + 1 + (i1 - i))) && j <= ((i7 - i6) + 1 + ((i5 - i4) + 1 + ((i3 - i2) + 1 + (i1 - i))))) {
                    list4.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i7 - i6) + 1 + ((i5 - i4) + 1 + ((i3 - i2) + 1 + (i1 - i)))) && j <= ((i9 - i8) + 1 + ((i7 - i6) + 1 + ((i5 - i4) + 1 + ((i3 - i2) + 1 + (i1 - i)))))) {
                    list5.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i9 - i8) + 1 + ((i7 - i6) + 1 + ((i5 - i4) + 1 + ((i3 - i2) + 1 + (i1 - i))))) && j <= ((i11 - i10) + 1 + ((i9 - i8) + 1 + ((i7 - i6) + 1 + ((i5 - i4) + 1 + ((i3 - i2) + 1 + (i1 - i))))))) {
                    list6.add(new Item(seperate[0], seperate[1]));
                    j++;
                }
            } catch (Exception e) {

            }
        }

    }

    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
}

