package com.groovenexus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class Artist {
    int pic;
    String text;

    public Artist(int pic, String name) {
        this.pic = pic;
        this.text = name;
    }
}

public class ArtistsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArtistAdapter adapter;
    ArrayList<Artist> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        buildRecyclerView();
        createList();

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void buildRecyclerView(){

        recyclerView = findViewById(R.id.recyclerViewArtist);
        recyclerView.setHasFixedSize(true);

        adapter = new ArtistAdapter(list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }
    public void createList() {
        for(int i=0;i<20;i++)
            list.add(new Artist(R.drawable.artistsample2,"Qwerty"));
    }
}
class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> {

    public ArrayList<Artist> exampleList;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ArtistCardImg);
            textView = itemView.findViewById(R.id.ArtistCardText);
        }
    }

    public ArtistAdapter(ArrayList<Artist> list) {
        exampleList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artist_card, viewGroup, false);
        return new ArtistAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Artist currentArtist = exampleList.get(position);

        Picasso.with(context).load(currentArtist.pic).resize(340,340).into(myViewHolder.imageView);
        myViewHolder.textView.setText(currentArtist.text);
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }
}



