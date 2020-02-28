package com.mobile.recyclerapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class News implements Parcelable {
    private String date;
    private String author;
    private String title;
    private String main;
    private boolean isLiked=false;
    private int likesCount;
    private  int images;
    private int commentsCount;

    public News(
            String date,
            String author,
            String title,
            String main,
            int likesCount,

            int commentsCount

    ) {
        this.date = date;
        this.author = author;
        this.title = title;
        this.main = main;
        this.likesCount = likesCount;

        this.commentsCount = commentsCount;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainText() {
        return main;
    }

    public void setMainText(String main) {
        this.main = main;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }



    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }
    public boolean Liked(){
        return isLiked;
    }
    public void setLike(boolean like){
        isLiked=like;
    }
    public void like(){
        likesCount=likesCount+1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("News{");
        sb.append("date='").append(date).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", main='").append(main).append('\'');
        sb.append(", likesCount=").append(likesCount);

        sb.append(", commentsCount=").append(commentsCount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.author);
        dest.writeString(this.title);
        dest.writeString(this.main);
        dest.writeInt(this.likesCount);
        dest.writeInt(this.images);
        dest.writeInt(this.commentsCount);
    }

    protected News(Parcel in) {
        this.date = in.readString();
        this.author = in.readString();
        this.title = in.readString();
        this.main = in.readString();
        this.likesCount = in.readInt();
        this.images=in.readInt();
        this.commentsCount = in.readInt();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
