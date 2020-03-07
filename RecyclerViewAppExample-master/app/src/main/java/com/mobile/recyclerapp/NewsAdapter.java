package com.mobile.recyclerapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> newsList;

    @Nullable
    private ItemClickListener listener;

    public NewsAdapter(List<News> newsList){
        this.newsList=newsList;
    }
    public NewsAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        int layoutIdForNewsItem = R.layout.item_news;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(layoutIdForNewsItem,null, false);


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);

        return  new NewsViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        final News news = newsList.get(position);
        holder.date.setText(news.getDate());
        holder.author.setText(news.getAuthor());
        holder.title.setText(news.getTitle());
        holder.mainText.setText(news.getMainText());
        holder.likesCount.setText(String.valueOf(news.getLikesCount()));
        holder.commentsCount.setText(String.valueOf(news.getCommentsCount()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.itemClick(position,news);
                }
            }
        });
        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.likeClick(position,news);
                }
            }
        });

        if (news.Liked()==true){
            holder.likeBtn.setImageResource(R.drawable.ic_liked);
        }else
            holder.likeBtn.setImageResource(R.drawable.ic_favorite_border_black_24dp);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView author, date, title, mainText, likesCount, commentsCount;
        ImageButton likeBtn, commentBtn;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            author= itemView.findViewById(R.id.tvAuthor);
            date = itemView.findViewById(R.id.tvDate);
            title = itemView.findViewById(R.id.tvTitle);
            mainText = itemView.findViewById(R.id.tvMain);
            likesCount= itemView.findViewById(R.id.tvLike);
            commentsCount= itemView.findViewById(R.id.tvCom);
            likeBtn= itemView.findViewById(R.id.ibLike);

        }
    }
    interface ItemClickListener {
        void itemClick(int position, News item);
        void likeClick(int position, News item);
    }
}
