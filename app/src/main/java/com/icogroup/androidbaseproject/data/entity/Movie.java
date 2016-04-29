package com.icogroup.androidbaseproject.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ulises.harris on 4/27/16.
 */
public class Movie implements Parcelable {

    @SerializedName("Title")
    String title;
    @SerializedName("Year")
    String year;
    @SerializedName("imdbID")
    String id;
    @SerializedName("Type")
    String type;
    @SerializedName("Poster")
    String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(type);
        dest.writeString(poster);
    }

    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    // "De-parcel object
    public Movie(Parcel in) {
        id = in.readString();
        title = in.readString();
        year = in.readString();
        type = in.readString();
        poster = in.readString();
    }
}
