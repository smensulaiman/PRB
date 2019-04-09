package com.mini.solaiman.policedhara.app;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mini.solaiman.policedhara.DBHelper.MyDatabase;
import com.mini.solaiman.policedhara.R;
import com.mini.solaiman.policedhara.adapter.CustomListAdapter;
import com.mini.solaiman.policedhara.model.Item;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class NewActivity extends AppCompatActivity {

    private MyDatabase db;
    private List<String> Books;
    String posk,poso;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/PROTHOMA.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_new);
        db = new MyDatabase(this);
        db.forceDatabaseReload(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("chapter");
        posk = intent.getStringExtra("posk");
        poso = intent.getStringExtra("poso");
        int a = Integer.parseInt(posk);
        b = Integer.parseInt(poso);
        if(a==2){
            b+=7;
        }
        poso = String.valueOf(b);

      //  Books = db.getPro(posk,poso,"CHAPTERS");
        Books = db.getPro(posk,poso,"CHAPTERS");


        final ListView itemsListView  = (ListView)findViewById(R.id.list_view_items);

        //create adapter object
        CustomListAdapter adapter = new CustomListAdapter(this, generateItemsList());
        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.text_view_item_name);
                TextView textViewD = (TextView) view.findViewById(R.id.text_view_item_description);
                String text = textView.getText().toString();
                String textD = textViewD.getText().toString();
                //Toast.makeText(NewActivity.this,"position "+i,Toast.LENGTH_SHORT).show();

                if((i==28 && b==18)||(i==34 && b==21)){
                    Intent intent = new Intent(NewActivity.this,HtmlActivity.class);
                    //intent.putExtra("chapter",text);
                    intent.putExtra("posk",posk);
                    intent.putExtra("poso",poso);
                    intent.putExtra("query",text+"।"+textD);
                    startActivity(intent);
                }else{
                Intent intent = new Intent(NewActivity.this,ReadActivity.class);
                //intent.putExtra("chapter",text);
                intent.putExtra("posk",posk);
                intent.putExtra("poso",poso);
                intent.putExtra("query",text+"।"+textD);
                startActivity(intent);}

            }
        });

        //set custom adapter as adapter to our list view
        itemsListView.setAdapter(adapter);

    }


    private ArrayList<Item> generateItemsList() {
        ArrayList<Item> list = new ArrayList<>();

        for (String book : Books) {
            try{
            String seperate [] = book.split("।");
           // Toast.makeText(this,seperate[1],Toast.LENGTH_SHORT).show();
            list.add(new Item(seperate[0], seperate[1]));}
            catch (Exception e){
              //  Toast.makeText(this,"pattern not matching",Toast.LENGTH_SHORT).show();
            }
        }

        return list;
    }

}
