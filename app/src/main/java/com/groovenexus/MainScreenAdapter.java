package com.groovenexus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainScreenAdapter extends RecyclerView.Adapter<MainScreenAdapter.MyViewHolder> {

    public ArrayList<MainScreenFragment.NewsBox> exampleList;
//    ArtistItem[] items;
    private Context context;

    private boolean leftImg = true;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1, textView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.boximage);
            textView1 = itemView.findViewById(R.id.boxtext1);
            textView2 = itemView.findViewById(R.id.boxtext2);
        }
    }

    public MainScreenAdapter(Context context, ArrayList<MainScreenFragment.NewsBox> list) {
        this.context = context;
        exampleList = list;
    }
    public MainScreenAdapter(Context context, ArtistItem[] items)
    {
        this.context = context;
//        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if(leftImg)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_box,viewGroup,false);
        }
        else
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_box2,viewGroup,false);
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
//        MainScreenFragment.NewsBox currentBox = exampleList.get(position);
//
//        myViewHolder.imageView.setImageResource(currentBox.pic);
//        myViewHolder.textView1.setText(currentBox.text1);
//        myViewHolder.textView2.setText(currentBox.text2);

        MainScreenFragment.NewsBox box = exampleList.get(position);

        String image = box.pic;
        String name = box.text1;

//        ArtistItem item = items[position];
//        String image = item.getImgUrl();
//        String name = item.getDisplayName();

        myViewHolder.textView1.setText(name);
        Picasso.with(context).load(image).fit().centerInside().into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }
}