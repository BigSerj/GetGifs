package com.lserj.bigserj.mainActivity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.lserj.bigserj.R;
import com.lserj.bigserj.base.BaseActivity;
import com.lserj.bigserj.databinding.ActivityMainBinding;

public class FirstPageActivity extends BaseActivity{

    ActivityMainBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        FirstPageViewModel viewModel = new FirstPageViewModel(this);
        this.viewModel = viewModel;

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.gifViewAdapter);

        super.onCreate(savedInstanceState);
    }

}
