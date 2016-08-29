package com.icogroup.androidbaseproject.ui.viewHolders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.icogroup.androidbaseproject.R;
import com.icogroup.androidbaseproject.data.base.recyclerview.BaseRecyclerViewHolder;
import com.icogroup.androidbaseproject.data.entity.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Ulises.harris on 4/27/16.
 */
public class MovieViewHolder extends BaseRecyclerViewHolder<Movie>{

    @BindView(R.id.movie_image)
    ImageView mMovieImage;
    @BindView(R.id.movie_tile)
    TextView mMovieTitle;
    @BindView(R.id.movie_year)
    TextView mMovieYear;
    Context context;

    @Override
    protected void configureItem(Movie item) {
        Glide.with(context).load(item.getPoster()).into(mMovieImage);
        mMovieTitle.setText(item.getTitle());
        mMovieYear.setText(item.getYear());
    }

    public MovieViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
    }

}
