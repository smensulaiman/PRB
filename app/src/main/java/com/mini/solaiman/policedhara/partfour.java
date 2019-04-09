package com.mini.solaiman.policedhara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.mini.solaiman.policedhara.adapter.CustomIndexAdapter;
import com.mini.solaiman.policedhara.app.BackCon;
import com.mini.solaiman.policedhara.model.PdfName;

public class partfour extends AppCompatActivity {
    ListView lv;
    String names[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partfour);

        CustomIndexAdapter adapter = new CustomIndexAdapter(this,names);

        lv = (ListView)findViewById(R.id.list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PdfName.name = names[i];
                BackCon.background = 0;
                startActivity(new Intent(partfour.this,PdfActivity.class));
            }
        });
        lv.setAdapter(adapter);

    }
}
