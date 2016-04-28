package com.icogroup.androidbaseproject.ui.viewHolders;

import android.content.Context;
import android.view.View;

import com.icogroup.androidbaseproject.data.entity.Movie;

import io.github.prashantsolanki3.snaplibrary.snap.SnapViewHolder;

/**
 * Created by Ulises.harris on 4/27/16.
 */
public class MovieViewHolder extends SnapViewHolder<Movie> {

    public MovieViewHolder(View itemView, Context context) {
        super(itemView, context);

        init(itemView);
    }

    private void init(View itemView) {

    }

    @Override
    public void populateViewHolder(Movie movie, int i) {

    }

    @Override
    public void animateViewHolder(SnapViewHolder snapViewHolder, int i) {

    }

    @Override
    public void attachOnClickListeners(SnapViewHolder snapViewHolder, Movie movie, int i) {

    }
}
