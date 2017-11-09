package com.lserj.bigserj.mainActivity;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lserj.bigserj.base.BaseItemViewHolder;
import com.lserj.bigserj.databinding.ItemRecycleViewBinding;
import com.lserj.bigserj.domain.entity.Data;

public class GifViewItemViewHolder extends BaseItemViewHolder<Data,
        GifViewItemViewModel, ItemRecycleViewBinding> {


    public GifViewItemViewHolder(ItemRecycleViewBinding binding, GifViewItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setItemViewModel(viewModel);
    }

    public static GifViewItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               GifViewItemViewModel viewModel) {
        ItemRecycleViewBinding binding = ItemRecycleViewBinding.inflate(inflater, parent, false);
        return new GifViewItemViewHolder(binding, viewModel);
    }
}
