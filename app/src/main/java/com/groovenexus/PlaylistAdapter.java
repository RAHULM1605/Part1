package com.groovenexus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class PlayItem
{
    public int pic;
    public String text1,text2;

    public PlayItem(int pic, String text1, String text2) {
        this.pic = pic;
        this.text1 = text1;
        this.text2 = text2;
    }
    
    public int getPic() {
        return pic;
    }
    public String getText1() {
        return text1;
    }
    public String getText2() {
        return text2;
    }
}

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.MyViewHolder> {

    public ArrayList<PlayItem> exampleList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1, textView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.playlistCardImg);
            textView1 = itemView.findViewById(R.id.playlistCardText1);
            textView2 = itemView.findViewById(R.id.playlistCardText2);
        }
    }

    public PlaylistAdapter(ArrayList<PlayItem> list) {
        exampleList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.playlist_card,viewGroup,false);
        return new PlaylistAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        PlayItem currentItem = exampleList.get(position);

        myViewHolder.imageView.setImageResource(currentItem.pic);
        myViewHolder.textView1.setText(currentItem.text1);
        myViewHolder.textView2.setText(currentItem.text2);
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }
}
