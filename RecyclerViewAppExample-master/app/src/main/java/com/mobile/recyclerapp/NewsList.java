package com.mobile.recyclerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsList extends Fragment {
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    ArrayList<StoriesModel> storiesModelArrayList=new ArrayList<>();
    RecyclerViewAdapterStories adapterStories;

    private NewsAdapter adapter;
    boolean isLiked;
    private NewsAdapter newsAdapter;
    private ImageButton like;

    private NewsAdapter.ItemClickListener listener=null;
    private NewsAdapter.FragmentButtonListener fragmentButtonListener = null;
    private NewsAdapter.FragmentLikeListener fragmentLikeListener = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.page, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2=(RecyclerView) rootView.findViewById(R.id.recy_stories);
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) layoutManager1).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager1);
        adapterStories=new RecyclerViewAdapterStories(getActivity(),storiesModelArrayList);
        recyclerView2.setAdapter(adapterStories);
        populaterecyclerviewstories();

        listener = new NewsAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
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
                    fragmentButtonListener.myClick(item, 1);


                    isLiked=true;
                }else {
                    item.setLike(false);
                    fragmentLikeListener.removeItemLike(item);
                    //item.setLikesCount(item.getLikesCount()-1);

                    isLiked=false;
                }
                newsAdapter.notifyItemChanged(position);
            }


        };
        fragmentButtonListener = new NewsAdapter.FragmentButtonListener() {
            @Override
            public void myClick(News news, int option) {
                ((MainActivity) getActivity()).myClick(news, option);

            }
        };
        fragmentLikeListener = new NewsAdapter.FragmentLikeListener() {
            @Override
            public void removeItemLike(News news) {
                ((MainActivity)getActivity()).removeItemLike(news);
            }
        };




        newsAdapter = new NewsAdapter(newsGenerator(), listener, fragmentButtonListener, fragmentLikeListener);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        like = rootView.findViewById(R.id.ibLike);


        return rootView;
    }

    private void populaterecyclerviewstories() {
        StoriesModel

                storiesModel=new StoriesModel("mumbiker.nikkhil",R.drawable.a1);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("carryminati",R.drawable.a2);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("bhuvan.bam",R.drawable.a3);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("easportsfifa",R.drawable.propic4);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("championsleague",R.drawable.av5);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("leomessi",R.drawable.av8);
        storiesModelArrayList.add(storiesModel);
    }

    private List<News> newsGenerator() {
        String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        List<News> items = new ArrayList<>();

        News n1 = new News("02/21/2020 11:45","Asma Moyeed","Loved ones", getString(R.string.first),1,5);
        n1.setImages(R.drawable.a1);
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
    public void removeLike(News news){
        newsAdapter.removeLike(news);


    }

}
