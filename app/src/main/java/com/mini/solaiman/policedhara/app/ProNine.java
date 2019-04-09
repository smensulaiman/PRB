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

public class ProNine extends AppCompatActivity {

    private MyDatabase db;
    private List<String> Books;
    ArrayList<Item> list1 = new ArrayList<>();
    ArrayList<Item> list2 = new ArrayList<>();
    ArrayList<Item> list3 = new ArrayList<>();
    ArrayList<Item> list4 = new ArrayList<>();
    ArrayList<Item> list5 = new ArrayList<>();
    ArrayList<Item> list6 = new ArrayList<>();
    ArrayList<Item> list7 = new ArrayList<>();
    ArrayList<Item> list8 = new ArrayList<>();
    ArrayList<Item> list9 = new ArrayList<>();
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9;
    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_nine);

        Intent intent = getIntent();
        String id = intent.getStringExtra("chapter");
        final String posk = intent.getStringExtra("posk");
        final String poso = intent.getStringExtra("poso");
        String nposo = poso;
        final String check = intent.getStringExtra("check");
        //Toast.makeText(ProTen.this,"increment "+posk,Toast.LENGTH_SHORT).show();
        c = Integer.parseInt(poso);
        if("2".equals(posk)){
            c+=7;
            //Toast.makeText(ProTen.this,"oddhay "+c,Toast.LENGTH_SHORT).show();
        }

        db = new MyDatabase(this);
        //db.forceDatabaseReload(this);
        Books = db.getPro(posk,String.valueOf(c),"CHAPTERS");

        text1 =  (TextView)findViewById(R.id.text1);
        text2 =  (TextView)findViewById(R.id.text2);
        text3 =  (TextView)findViewById(R.id.text3);
        text4 =  (TextView)findViewById(R.id.text4);
        text5 =  (TextView)findViewById(R.id.text5);
        text6 =  (TextView)findViewById(R.id.text6);
        text7 =  (TextView)findViewById(R.id.text7);
        text8 =  (TextView)findViewById(R.id.text8);
        text9 =  (TextView)findViewById(R.id.text9);
        //text10 =  (TextView)findViewById(R.id.text10);

        if(c==4){
            setName("১ সুযোগ-সুবিধা,প্রভৃতি","২ ফৌজদারি ও দেওয়ানি মামলায় পুলিশ অফিসারগণের পক্ষ সমর্থন","৩ সরকারী কর্মচারীদের আচরণবিধি ও অন্যান্য সাধারণ কার্যবিধি","৪ সহযোগিতা, সম্মেলন ও সভা","৫ সমাবেশ ও শোভাযাত্রা\n(১) ক্ষমতা","(২) সমাবেশ বা শোভাযাত্রা আরম্ভের পূর্বে করণীয় ব্যবস্থা।","(৩)সমাবেশ ও শোভাযাত্রা অনুষ্ঠিত হইবার সময় বা পরে ব্যবস্থা গ্রহণ করিতে হইবে","৬ সশস্ত্র পুলিশ দল নিয়োগ এবং দাঙ্গা ও গোলযোগের সময় পুলিশ কর্তৃক আগ্নেয়াস্ত্র ব্যবহার","৭ অফিসে হাজিরা এবং রেকর্ড ও চিঠিপত্র আদান প্রদান ও সংরক্ষণ বিষয়ে সাধারণ নির্দেশাবলী");
            setHead(82,99,100,105,106,122,123,133,134,135,136,143,144,147,148,172,173,192);
        }

        //generateItemsList();

        final ListView itemsListView1  = (ListView)findViewById(R.id.partView1);

        CustomListAdapter adapter1 = new CustomListAdapter(this, list1);
        CustomListAdapter adapter2= new CustomListAdapter(this, list2);
        CustomListAdapter adapter3 = new CustomListAdapter(this, list3);
        CustomListAdapter adapter4= new CustomListAdapter(this, list4);
        CustomListAdapter adapter5 = new CustomListAdapter(this, list5);
        CustomListAdapter adapter6 = new CustomListAdapter(this, list6);
        CustomListAdapter adapter7 = new CustomListAdapter(this, list7);
        CustomListAdapter adapter8 = new CustomListAdapter(this, list8);
        CustomListAdapter adapter9 = new CustomListAdapter(this, list9);
       // CustomListAdapter adapter10 = new CustomListAdapter(this, list10);


        itemsListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView1.setAdapter(adapter1);


        final ListView itemsListView2  = (ListView)findViewById(R.id.partView2);
        itemsListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView2.setAdapter(adapter2);

        final ListView itemsListView3  = (ListView)findViewById(R.id.partView3);
        itemsListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView3.setAdapter(adapter3);

        final ListView itemsListView4  = (ListView)findViewById(R.id.partView4);
        itemsListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView4.setAdapter(adapter4);

        final ListView itemsListView5  = (ListView)findViewById(R.id.partView5);
        itemsListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView5.setAdapter(adapter5);

        final ListView itemsListView6  = (ListView)findViewById(R.id.partView6);
        itemsListView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                //intent.putExtra("query1",text+"৷"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView6.setAdapter(adapter6);

        final ListView itemsListView7  = (ListView)findViewById(R.id.partView7);
        itemsListView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView7.setAdapter(adapter7);

        final ListView itemsListView8  = (ListView)findViewById(R.id.partView8);
        itemsListView8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView8.setAdapter(adapter8);

        final ListView itemsListView9  = (ListView)findViewById(R.id.partView9);
        itemsListView9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                Intent intent = new Intent(ProNine.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView9.setAdapter(adapter9);



        ListUtils.setDynamicHeight(itemsListView1);
        ListUtils.setDynamicHeight(itemsListView2);
        ListUtils.setDynamicHeight(itemsListView3);
        ListUtils.setDynamicHeight(itemsListView4);
        ListUtils.setDynamicHeight(itemsListView5);
        ListUtils.setDynamicHeight(itemsListView6);
        ListUtils.setDynamicHeight(itemsListView7);
        ListUtils.setDynamicHeight(itemsListView8);
        ListUtils.setDynamicHeight(itemsListView9);
        //ListUtils.setDynamicHeight(itemsListView10);
    }

    private void setName(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        text1.setText(s);
        text2.setText(s1);
        text3.setText(s2);
        text4.setText(s3);
        text5.setText(s4);
        text6.setText(s5);
        text7.setText(s6);
        text8.setText(s7);
        text9.setText(s8);
        //text10.setText(s9);

    }

    /*private ArrayList<Item> generateItemsList() {
        int i = 0;
        String seperate[];
        for (String book : Books) {
            try {
                seperate = book.split("।|৷");

                // Toast.makeText(this,seperate[1],Toast.LENGTH_SHORT).show();

                if(c==3) {
                    //setHead(35,46,47,52,53,56,57,67,68,68,69,74,75,81);
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
    private void setHead(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        String seperate[];
        int j = 0;
        for (String book : Books) {
            try{
                seperate = book.split("।|৷");

                if (j <= (i1-i)) {
                    list1.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > (i1-i) && j <= ((i3-i2)+1+(i1-i))) {
                    list2.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i3-i2)+1+(i1-i)) && j <= ((i5-i4)+1+((i3-i2)+1+(i1-i)))) {
                    list3.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i5-i4)+1+((i3-i2)+1+(i1-i))) && j <= ((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i))))) {
                    list4.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i)))) && j <= ((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i)))))) {
                    list5.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i))))) && j <= ((i11-i10)+1+((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i))))))) {
                    list6.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i11-i10)+1+((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i)))))) && j <= ((i13-i12)+1+((i11-i10)+1+((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i)))))))) {
                    list7.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i13-i12)+1+((i11-i10)+1+((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i))))))) && j <= ((i15-i14)+1+((i13-i12)+1+((i11-i10)+1+((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i))))))))) {
                    list8.add(new Item(seperate[0], seperate[1]));
                    j++;
                } else if (j > ((i15-i14)+1+((i13-i12)+1+((i11-i10)+1+((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i)))))))) && j <= ((i17-i16)+1+((i15-i14)+1+((i13-i12)+1+((i11-i10)+1+((i9-i8)+1+((i7-i6)+1+((i5-i4)+1+((i3-i2)+1+(i1-i)))))))))) {
                    list9.add(new Item(seperate[0], seperate[1]));
                    j++;
                }
            }catch (Exception e ){

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

