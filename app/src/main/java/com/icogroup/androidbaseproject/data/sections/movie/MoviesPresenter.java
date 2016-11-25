package com.icogroup.androidbaseproject.data.sections.movie;

import android.app.Activity;

import com.icogroup.androidbaseproject.data.entity.Movie;
import com.icogroup.androidbaseproject.data.entity.Search;
import com.icogroup.androidbaseproject.data.interactors.movie.MoviesInteractor;
import com.icogroup.androidbaseproject.data.routing.IRouting;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class MoviesPresenter implements MoviesContract.MovieActionListener {

    private MoviesInteractor interactor;
    private MoviesContract.View mView;
    private IRouting router;
    private Subscription moviesSubscription;

    public MoviesPresenter(MoviesContract.View view, IRouting router) {
        mView = view;
        this.router = router;

        interactor = new MoviesInteractor();
    }

    @Override
    public void getMovies(String text) {
       moviesSubscription = interactor.getMovies(text)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Subscriber<Search>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {
                        mView.showErrors(e.getLocalizedMessage());
                   }

                   @Override
                   public void onNext(Search search) {
                       if(search != null)
                           mView.showMovies(search.getSearch());
                   }
               });
    }

    @Override
    public void onStop() {
        if(moviesSubscription != null && !moviesSubscription.isUnsubscribed()){
            moviesSubscription.unsubscribe();
        }
    }

    @Override
    public void openMovieDetail(Activity activity, Movie movie) {
        router.movieDetail(activity, movie);
    }


}
