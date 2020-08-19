package com.example.valepei.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.valepei.Model.POJO.News;
import com.example.valepei.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {

    Context context;

    List<News> listaNews;

    public NewsAdapter(Context context, List<News> listaNews) {
        this.context = context;
        this.listaNews = listaNews;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View cell = inflater.inflate(R.layout.cell_news_layout,parent,false);

        ViewHolderItems viewHolderItems = new ViewHolderItems(cell);

        return viewHolderItems;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        News news = listaNews.get(position);
        NewsAdapter.ViewHolderItems viewholderItems = (NewsAdapter.ViewHolderItems) holder;
        viewholderItems.setDataProducts(news);

    }

    @Override
    public int getItemCount() {
        return listaNews.size();
    }

    private class ViewHolderItems extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView newsImageView;


        public ViewHolderItems(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.titleText);
            newsImageView = itemView.findViewById(R.id.newsImageView);
        }

        public void setDataProducts(News news) {

            textViewTitle.setText(news.getTitle().toString());


            String urlImage = news.getUrlToImage();

            Glide.with(context).load(urlImage).into(newsImageView);
//            Picasso.get().load(urlImage).into(newsImageView);
        }
    }


}
