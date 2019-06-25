package com.groovenexus;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ImageButton back;

    ArrayList<PlayItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        buildRecyclerView();
        createList();

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                Intent i;
//                switch(menuItem.getItemId())
//                {
//                    case R.id.nav_item1 : startActivity(new Intent(Playlist.this,Screen1.class)); break;
//                    case R.id.nav_item2 : break;
//                    case R.id.nav_item3 : break;
//                    case R.id.nav_item4 : break;
//                }
//                return true;
//            }
//        });
    }
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewPlaylist);
        recyclerView.setHasFixedSize(true);

        adapter = new PlaylistAdapter(list);
        recyclerView.setAdapter(adapter);

        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void createList()
    {
        String T1 = "Raw is Jericho";
        String T2 = "My watch doesn't speak Spanish";
        for(int i=0;i<25;i++)
            list.add(new PlayItem(R.drawable.artistsample2,T1,T2));
    }
}

