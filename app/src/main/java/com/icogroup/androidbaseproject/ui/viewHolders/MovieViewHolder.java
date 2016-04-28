package com.icogroup.androidbaseproject.ui.viewHolders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.icogroup.androidbaseproject.R;
import com.icogroup.androidbaseproject.data.entity.Movie;

import org.w3c.dom.Text;

import io.github.prashantsolanki3.snaplibrary.snap.SnapViewHolder;

/**
 * Created by Ulises.harris on 4/27/16.
 */
public class MovieViewHolder extends SnapViewHolder<Movie> {

    ImageView mMovieImage;
    TextView mMovieTitle;
    TextView mMovieYear;
    Context context;

    public MovieViewHolder(View itemView, Context context) {
        super(itemView, context);
        this.context = context;
        init(itemView);
    }

    private void init(View itemView) {
        mMovieImage = (ImageView) itemView.findViewById(R.id.movie_image);
        mMovieTitle = (TextView) itemView.findViewById(R.id.movie_tile);
        mMovieYear = (TextView) itemView.findViewById(R.id.movie_year);
    }

    @Override
    public void populateViewHolder(Movie movie, int i) {
        Glide.with(context).load(movie.getPoster()).into(mMovieImage);
        mMovieTitle.setText(movie.getTitle());
        mMovieYear.setText(movie.getYear());
    }

    @Override
    public void animateViewHolder(SnapViewHolder snapViewHolder, int i) {

    }

    @Override
    public void attachOnClickListeners(SnapViewHolder snapViewHolder, Movie movie, int i) {

    }
}
