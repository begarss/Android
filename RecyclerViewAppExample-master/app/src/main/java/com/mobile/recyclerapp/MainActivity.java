package com.mobile.recyclerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private NewsAdapter.ItemClickListener listener =null;
    private ImageButton like;
    boolean isLiked;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private static Bundle mBundleRecyclerViewState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listener = new NewsAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
                intent.putExtra("news",item);
                intent.putExtra("like",item.Liked());
                startActivity(intent);
            }

            @Override
            public void likeClick(int position, News item) {
//                Toast toast = Toast.makeText(getApplicationContext(),
//                        item.getAuthor(), Toast.LENGTH_SHORT);
//                toast.show();
                isLiked=item.Liked();
                if (isLiked==false){
                    item.setLike(true);
                    item.setLikesCount(item.getLikesCount()+1);
                    isLiked=true;
                }else {
                    item.setLike(false);
                    item.setLikesCount(item.getLikesCount()-1);
                    isLiked=false;
                }
                newsAdapter.notifyItemChanged(position);
            }


        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        newsAdapter = new NewsAdapter(newsGenerator(), listener);
        recyclerView.setAdapter(newsAdapter);
        like = findViewById(R.id.ibLike);



    }




    private List<News> newsGenerator() {
        String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        List<News> items = new ArrayList<>();

//        News n1 = new News("02/21/2020 11:45","Asma Moyeed","Loved ones", getString(R.string.first),1,5);
//        n1.setImages(R.drawable.a1);
        News n2 = new News("02/22/2020 01:21","Toni Plant","The Lamb and The Wild Beasts", getString(R.string.second),1,5);
        n2.setImages(R.drawable.a3);
        News n3 = new News("02/22/2020 01:20","S. F. Tilly","Angry world", getString(R.string.third),5,5);
        n3.setImages(R.drawable.a2);
        News n4 = new News("02/22/2020 01:29","Zaa_aaah","Me", getString(R.string.fo),0,5);
        n4.setImages(R.drawable.av4);
        News n5 = new News("02/22/2020 01:21","cmukti","Thrubbing silencees", getString(R.string.fiv),1,5);
        n5.setImages(R.drawable.av5);

        News n6 = new News("02/22/2020 01:22","Bsn","Celest", getString(R.string.six),15,5);
        n6.setImages(R.drawable.av6);
        News n7 = new News("01/27/2020 10:17","Ankita Chaturvedi","Being Strong Alone", getString(R.string.seven),195,5);
        n7.setImages(R.drawable.av7);
        News n8 = new News("01/24/2020 04:32","Lykeus_","_______Help me Stay_______", getString(R.string.ei),177,55);
        n8.setImages(R.drawable.av8);
        News n9 = new News("02/14/2020 06:34","♛_\uD835\uDC40\uD835\uDCBE\uD835\uDCCF\uD835\uDCB6\uD835\uDCC3_♛","A Glorious Mess She is", getString(R.string.ni),174,54);
        n9.setImages(R.drawable.av9);
        News n10 = new News("01/30/2020 03:45","Ankita Chaturvedi_","Struggle", getString(R.string.ten),172,55);
        items.add(n1);
        items.add(n2);
        items.add(n3);
        items.add(n4);
        items.add(n5);
        items.add(n6);
        items.add(n7);
        items.add(n8);
        items.add(n9);
        items.add(n10);
        return items;
    }


}

