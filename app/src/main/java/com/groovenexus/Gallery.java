package com.groovenexus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewGallery);
        recyclerView.setHasFixedSize(true);

//        MyAdapterScreen1 adapter = new MyAdapterScreen1(list);
//        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        for(int i=0;i<25;i++)
        {
            ImageView v = new ImageView(this);
            v.setBackgroundResource(R.drawable.artistsample);
            recyclerView.addView(v);
        }


    }
}
