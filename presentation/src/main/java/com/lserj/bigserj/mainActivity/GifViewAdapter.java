package com.lserj.bigserj.mainActivity;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lserj.bigserj.base.BaseAdapter;
import com.lserj.bigserj.domain.entity.Data;


public class GifViewAdapter extends BaseAdapter<Data, GifViewItemViewModel> {

    @Override
    public GifViewItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GifViewItemViewModel itemViewModel = new GifViewItemViewModel();
        return GifViewItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
