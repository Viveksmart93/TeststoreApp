package com.teststoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);

        final String[] names = new String[] { "Android", "Windows7", "Symbian", "iPhone",
                "Android", "Windows7", "Symbian", "iPhone",
                "Android", "Windows7", "Symbian", "iPhone" };

        final ListView listView = findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice,
                android.R.id.text1, names));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);



    }
}
