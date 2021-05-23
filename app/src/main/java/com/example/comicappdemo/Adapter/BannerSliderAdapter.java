package com.example.comicappdemo.Adapter;

import android.util.Log;
import android.widget.Toast;

import com.example.comicappdemo.Model.Banner;

import java.util.List;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class BannerSliderAdapter extends SliderAdapter {
    private List<Banner> bannerList;


    public BannerSliderAdapter(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
            imageSlideViewHolder.bindImageSlide(bannerList.get(position).getLink());
        Log.i("BindImage"," :OK");
    }

    @Override
    public String toString() {
        return "BannerSliderAdapter{" +
                "bannerList=" + bannerList +
                '}';
    }
}
