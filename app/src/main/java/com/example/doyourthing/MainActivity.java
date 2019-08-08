package com.example.doyourthing;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Buildcard(Step 4/4)</font>"));
        String title = actionBar.getTitle().toString();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_bluetooth_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView textView = (TextView) findViewById(R.id.text);

        ImageSpan imageSpan = new ImageSpan(this, R.drawable.ic_card_giftcard_black_24dp);
        SpannableString spannableString = new SpannableString(textView.getText());

        int start = 13;
        int end = 14;
        int flag = 0;
        spannableString.setSpan(imageSpan, start, end, flag);

        textView.setText(spannableString);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> mData  = new ArrayList<>();
        mData.add("Project Info");
        mData.add("Similar Apps(3)");
        mData.add("Featured(18)");
        mData.add("New Features");
        mAdapter = new MyAdapter(this,mData);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
