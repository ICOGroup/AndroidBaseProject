package com.icogroup.icoadapter;

import android.view.View;

/**
 * Created by Ulises.harris on 8/9/16.
 */
public abstract class IcoBaseHolder<T> {

    View convertView;

    protected abstract void configureItem(T item);


    public IcoBaseHolder(View convertView) {
        this.convertView = convertView;

    }
}
