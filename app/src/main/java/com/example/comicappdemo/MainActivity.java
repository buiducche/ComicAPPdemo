package com.example.comicappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.comicappdemo.Adapter.BannerSliderAdapter;
import com.example.comicappdemo.Adapter.ComicAdapter;
import com.example.comicappdemo.Model.Banner;
import com.example.comicappdemo.Model.Comic;
import com.example.comicappdemo.Retrofit.IComicAPI;
import com.example.comicappdemo.Service.PicassoImageLoadingService;

import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.Slider;



public class MainActivity extends AppCompatActivity {
    Slider slider;
    RecyclerView recyclerView,recyclerViewLarger;
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Slider
        slider=(Slider)findViewById(R.id.banner_slider);
        Slider.init(new PicassoImageLoadingService());
        fetchBanner();
        //RecycleView
        recyclerView=(RecyclerView)findViewById(R.id.recycle_comic);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //RecycleViewlarger
        recyclerViewLarger=(RecyclerView)findViewById(R.id.recycle_comic_larger);
        recyclerViewLarger.setHasFixedSize(true);
        recyclerViewLarger.setNestedScrollingEnabled(true);
        recyclerViewLarger.setLayoutManager(new GridLayoutManager(this,2));
        fetchComic();
    }

    private void fetchComic() {
        IComicAPI.apiService.getComicList().enqueue(new Callback<List<Comic>>() {
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {
                recyclerView.setAdapter(new ComicAdapter(getBaseContext(),response.body(),1));
                recyclerViewLarger.setAdapter(new ComicAdapter(getBaseContext(),response.body(),2));
            }

            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"No internet",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void fetchBanner() {
        IComicAPI.apiService.getBannerList().enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                    slider.setAdapter(new BannerSliderAdapter(response.body()));
                    Toast.makeText(MainActivity.this,"API OK",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"No internet",Toast.LENGTH_SHORT).show();

            }
        });


    }
}