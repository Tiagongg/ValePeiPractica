package com.example.valepei.Controller;

import com.example.valepei.Model.DAO.DAONewsRetrofit;
import com.example.valepei.Model.POJO.NewsEverythingSpanish;
import com.example.valepei.Model.POJO.NewsTopHeadline;
import com.example.valepei.Util.ResultListener;

public class NewsController {

    DAONewsRetrofit daoNewsRetrofit;

    public NewsController(){

    }

    public void getnews(final ResultListener<NewsTopHeadline> EscuchadorActivityNews) {

        daoNewsRetrofit = new DAONewsRetrofit();


        ResultListener<NewsTopHeadline> escuchadorDelNewsController = new ResultListener<NewsTopHeadline>() {
            @Override
            public void finish(NewsTopHeadline resultado) {
                EscuchadorActivityNews.finish(resultado);
            }
        };

        daoNewsRetrofit.getTopNews(escuchadorDelNewsController);
    }

    public void getEverythingNews(final ResultListener<NewsEverythingSpanish> EscuchadorActivityNews) {

        daoNewsRetrofit = new DAONewsRetrofit();


        ResultListener<NewsEverythingSpanish> escuchadorDelNewsController = new ResultListener<NewsEverythingSpanish>() {
            @Override
            public void finish(NewsEverythingSpanish resultado) {
                EscuchadorActivityNews.finish(resultado);
            }
        };

        daoNewsRetrofit.getEverythingNews(escuchadorDelNewsController);
    }

}
