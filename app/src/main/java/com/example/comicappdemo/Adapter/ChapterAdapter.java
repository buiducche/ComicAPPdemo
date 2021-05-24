package com.example.comicappdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicappdemo.Model.Chapter;
import com.example.comicappdemo.R;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> {
    List<Chapter> chapterList;
    Context context;

    public ChapterAdapter(List<Chapter> chapterList, Context context) {
        this.chapterList = chapterList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.item_chapter,parent,false);
        return new ChapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
            holder.chapterName.setText(chapterList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public class ChapterViewHolder extends RecyclerView.ViewHolder {
        TextView chapterName;
        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            chapterName = (TextView)itemView.findViewById(R.id.chapter_name);
        }
    }
}
