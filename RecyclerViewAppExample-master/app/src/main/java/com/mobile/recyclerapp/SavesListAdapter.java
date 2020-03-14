package com.mobile.recyclerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SavesListAdapter extends RecyclerView.Adapter<SavesListAdapter.SavesListViewHolder> {
    private List<News> newsList;
    private Context context;
    @Nullable
    private ItemClickListener listener;
    private @Nullable FragmentLikeListener fragmentLikeListener;

    public SavesListAdapter(List<News> newsList){
        this.newsList=newsList;
    }
    public SavesListAdapter(List<News> newsList, @Nullable ItemClickListener listener,
                            @Nullable FragmentLikeListener fragmentLikeListener
    ) {
        this.newsList = newsList;
        this.listener = listener;
        this.fragmentLikeListener=fragmentLikeListener;
    }



    @NonNull
    @Override
    public SavesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

        return  new SavesListViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull final SavesListViewHolder holder, final int position) {
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

                if (fragmentLikeListener!=null)
                    fragmentLikeListener.removeItemLike(news);
            }
        });
//

        if (news.Liked()==true){
            holder.likeBtn.setImageResource(R.drawable.ic_liked);
        }else
            holder.likeBtn.setImageResource(R.drawable.ic_favorite);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class SavesListViewHolder extends RecyclerView.ViewHolder{
        TextView author, date, title, mainText, likesCount, commentsCount;
        ImageView likeBtn;
        public SavesListViewHolder(@NonNull View itemView) {
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
    public interface FragmentLikeListener{
        void removeItemLike(News news);
    }

}
