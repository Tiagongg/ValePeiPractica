package com.example.valepei.Services;

import com.example.valepei.Model.POJO.NewsEverythingSpanish;
import com.example.valepei.Model.POJO.NewsTopHeadline;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServicePost {

    @GET("top-headlines")
    Call<NewsTopHeadline> getNews(@Query("apiKey") String apiKey,
                                  @Query("country")String country);


    @GET("everything")
    Call<NewsEverythingSpanish> getEverythingNews(@Query("apiKey") String apiKey,
                                                  @Query("language") String language,
                                                  @Query("q")String word);
}
