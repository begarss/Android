package com.mobile.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailActivity extends AppCompatActivity {

    private TextView tvTitle, tvMain,tvLikes,tvAuthor,tvDate;
    private ImageView img;
    private ImageButton likeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        setContentView(R.layout.activity_news_detail);
        img = findViewById(R.id.ivAva);
        tvTitle = findViewById(R.id.tvTitle2);
        tvMain=findViewById(R.id.tvMain2);
        tvLikes=findViewById(R.id.tvLikes2);
        tvAuthor=findViewById(R.id.tvAuthor2);
        tvDate=findViewById(R.id.tvDate2);
        likeBtn= findViewById(R.id.ibLike);
        boolean like;
        News news = (News) getIntent().getParcelableExtra("news");
        like=getIntent().getExtras().getBoolean("like");
        tvTitle.setText(news.getTitle());
        tvMain.setText((news.getMainText()));
        tvLikes.setText(String.valueOf(news.getLikesCount()));
        tvAuthor.setText("by "+news.getAuthor());
        tvDate.setText(news.getDate());
        img.setImageResource(news.getImages());
        news.setLike(like);
        if (like==false)
            tvAuthor.setText("false");
        else tvAuthor.setText("tr");
        if (news.Liked()==true){
            //holder.likeBtn.setBackgroundColor(Color.parseColor("#FF0000"));
            likeBtn.setImageResource(R.drawable.ic_liked);
        }else
            likeBtn.setImageResource(R.drawable.ic_favorite_border_black_24dp);
    }
}
