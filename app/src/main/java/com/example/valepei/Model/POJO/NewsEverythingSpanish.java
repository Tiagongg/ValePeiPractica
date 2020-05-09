package com.example.valepei.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsEverythingSpanish {

    @SerializedName("articles")
    List<News> listaNews;

    public List<News> getListaNewsEverythingSpanish() {
        return listaNews;
    }

}
