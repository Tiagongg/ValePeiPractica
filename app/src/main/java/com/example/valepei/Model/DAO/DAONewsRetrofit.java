package com.example.valepei.Model.DAO;

import com.example.valepei.Model.POJO.NewsEverythingSpanish;
import com.example.valepei.Model.POJO.NewsTopHeadline;
import com.example.valepei.Services.ServicePost;
import com.example.valepei.Util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class DAONewsRetrofit {
        private Retrofit retrofit;
        private ServicePost servicePost;
        private String baseURL;

        String apiKey = "614e1adf9c1a4939a8b31b02876a2851";


        public DAONewsRetrofit() {

            baseURL = "https://newsapi.org/v2/";


            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            servicePost = retrofit.create(ServicePost.class);
        }

        public void getTopNews(final ResultListener<NewsTopHeadline> escuchadorDelNewsController) {
            Call<NewsTopHeadline> newsCallback = servicePost.getNews(apiKey, "us");
            newsCallback.enqueue(new Callback<NewsTopHeadline>() {
                @Override
                public void onResponse(Call<NewsTopHeadline> call, Response<NewsTopHeadline> response) {
                    escuchadorDelNewsController.finish(response.body());
                }

                @Override
                public void onFailure(Call<NewsTopHeadline> call, Throwable t) {
                    System.out.println("fallo");

                }
            });
        }

        public void getEverythingNews(final ResultListener<NewsEverythingSpanish> escuchadorDelNewsController) {
            Call<NewsEverythingSpanish> newsCallback = servicePost.getEverythingNews(apiKey, "es","gaming");
            newsCallback.enqueue(new Callback<NewsEverythingSpanish>() {
                @Override
                public void onResponse(Call<NewsEverythingSpanish> call, Response<NewsEverythingSpanish> response) {
                    escuchadorDelNewsController.finish(response.body());
                }

                @Override
                public void onFailure(Call<NewsEverythingSpanish> call, Throwable t) {
                    System.out.println("fallo");

                }
            });


        }
    }
