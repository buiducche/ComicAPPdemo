package com.example.comicappdemo.Retrofit;

import com.example.comicappdemo.Model.Banner;
import com.example.comicappdemo.Model.Comic;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface IComicAPI {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    IComicAPI apiService = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IComicAPI.class);
    @GET("banner")
    Call<List<Banner>> getBannerList();

    @GET("comic")
    Call<List<Comic>> getComicList();
}
