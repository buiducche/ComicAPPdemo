package com.example.comicappdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicappdemo.ChapterActivity;
import com.example.comicappdemo.Handler.handler;
import com.example.comicappdemo.Model.Comic;
import com.example.comicappdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.logging.Handler;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder>  {
    Context context;
    List<Comic> comicList;
    int type;

    public ComicAdapter(Context context, List<Comic> comicList,int type) {
        this.context = context;
        this.comicList = comicList;
        this.type=type;
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView ;
          if(type==1) itemView=LayoutInflater.from(context).inflate(R.layout.item_comic,parent,false);
          else itemView=LayoutInflater.from(context).inflate(R.layout.item_comic_larger,parent,false);
        return new ComicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        Picasso.get().load(comicList.get(position).getImage()).into(holder.imageView);
        holder.textView.setText(comicList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_view);
            textView = (TextView)itemView.findViewById(R.id.text_comic);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            handler.Comicselected=comicList.get(mPosition);
            Log.i("select",handler.Comicselected.getName());
            context.startActivity(new Intent(context, ChapterActivity.class));
        }
    }
}
