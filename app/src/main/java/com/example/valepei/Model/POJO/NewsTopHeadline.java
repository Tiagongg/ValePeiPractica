package com.example.valepei.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsTopHeadline {

    @SerializedName("articles")
    List<News> listaNews;

    public List<News> getListaHeadline() {
        return listaNews;
    }

}
