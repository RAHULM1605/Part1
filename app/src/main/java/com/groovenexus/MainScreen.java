package com.groovenexus;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    ArrayList<NewsBox> list = new ArrayList<>();
    RequestQueue requestQueue ;
    private long counter = 1;

    public class NewsBox
    {
        public String pic;
        public String text1;//,text2;
//        public boolean imgRight;

        public NewsBox(String pic, String text1) {
            this.pic = pic;
            this.text1 = text1;
            //this.text2 = text2;
//            this.imgRight = imgRight;
        }
    }


    LinearLayout horizontalLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String exampleText1 = "Hello world", exampleText2 = "If you smell what the Rock is Cooking!!! And that's the bottomline, coz Stone Cold said so!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

//        Toolbar myToolbar = findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);

        ImageView j = findViewById(R.id.imageView);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this,PlaylistActivity.class));
            }
        });

        j.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(MainScreen.this,ArtistsActivity.class));
                return true;
            }
        });
//        setupBottomNavBar();

        horizontalLayout = findViewById(R.id.linearlayout1);
        for(int i=0;i<10;i++)
        {
            ImageView v = new ImageView(this);
            v.setBackgroundResource(R.drawable.artistsample);
            horizontalLayout.addView(v);
        }
//        for(ImageView view : artistPics)
//            layout.addView(view);

//        createList();
        buildRecyclerView();
        list = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        parseJSON();

//        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                Intent i;
//                switch(menuItem.getItemId())
//                {
//                    case R.id.nav_item1 : break;
//                    case R.id.nav_item2 : startActivity(new Intent(MainScreen.this,Playlist.class)); break;
//                    case R.id.nav_item3 : break;
//                    case R.id.nav_item4 : break;
//                }
//                return true;
//            }
//        });

    }
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter = new MainScreenAdapter(MainScreen.this,list);
        recyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

//    private void createList()
//    {
//        for(int i=0;i<20;i++) {
//            if(i%2==0) {
//                list.add(new NewsBox(R.drawable.artistsample2, exampleText1 + " " + i, exampleText2,false));
//            }
//            else{
//                list.add(new NewsBox(R.drawable.artistsample2, exampleText1 + " " + i, exampleText2,true));
//            }
//
//        }
//    }

    private void parseJSON() {

        final String url = "https://www.demo.groovenexus.info/wp-json/mobileapp/v1/djmeta?artist_type=Disc_Jockey";
//        final String url = "https://www.demo.groovenexus.info/wp-json/mobileapp/v1/groovypost/";
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                            JSONArray jsonArray = response.getJSONArray("PostMeta");
//                            JSONArray jsonArray = response.getJSONArray("");
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i = 0; i<jsonArray.length(); i++)
                            {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String img = hit.getString("img_url");
                                String name = hit.getString("display_name");
//                                int likes = hit.getInt("likes");
//                                String img = hit.getString("");
//                                String name = hit.getString();
//                                int likes = hit.getInt("likes");

                                list.add(new NewsBox(img,name));

//                                String name = hit.getString("post_title");
//                                list.add(new Item(name));
                            }

                            adapter = new MainScreenAdapter(MainScreen.this,list);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        requestQueue.add(objectRequest);
    }
//    private void setupBottomNavBar()
//    {
//        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener
//                (new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        Fragment selectedFragment = null;
//                        switch (item.getItemId()) {
////                            case R.id.nav_item1:
////                                selectedFragment = .newInstance();
////                                break;
//                            case R.id.nav_item2:
//                                selectedFragment = Frag1.newScreen();
//                                break;
//                            case R.id.nav_item3:
////                                selectedFragment = ItemThreeFragment.newInstance();
//                                break;
//                        }
//                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
////                        transaction.replace(R.layout.activity_MainScreen, selectedFragment);
//                        transaction.commit();
//                        return true;
//                    }
//                });

        //Manually displaying the first fragment - one time only
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_layout, ItemOneFragment.newInstance());
//        transaction.commit();
//    }
}