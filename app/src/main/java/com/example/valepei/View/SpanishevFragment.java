package com.example.valepei.View;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.valepei.Adapter.NewsAdapter;
import com.example.valepei.Controller.NewsController;
import com.example.valepei.Model.POJO.News;
import com.example.valepei.Model.POJO.NewsEverythingSpanish;
import com.example.valepei.R;
import com.example.valepei.Util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpanishevFragment extends Fragment {


    NewsController newsController;

    RecyclerView recyclerViewNews;

    NewsAdapter newsAdapter;

    List<News> listadeNews = new ArrayList<>();



    Context context;


    public SpanishevFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spanishev, container, false);

        recyclerViewNews = view.findViewById(R.id.recyclerViewSpanishNews);
        newsController = new NewsController();

        ResultListener<NewsEverythingSpanish> EscuchadorActivityNews = new ResultListener<NewsEverythingSpanish>() {
            @Override
            public void finish(NewsEverythingSpanish resultado) {


                for (News news : resultado.getListaNewsEverythingSpanish()) {
                    listadeNews.add(news);
                }

                newsAdapter = new NewsAdapter(context,listadeNews);
                recyclerViewNews.setAdapter(newsAdapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                recyclerViewNews.setLayoutManager(layoutManager);
            }
        };
        newsController.getEverythingNews(EscuchadorActivityNews);

        return view;
    }
}
