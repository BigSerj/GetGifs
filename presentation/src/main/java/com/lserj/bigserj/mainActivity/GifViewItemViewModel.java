package com.lserj.bigserj.mainActivity;


import android.databinding.ObservableField;
import com.lserj.bigserj.base.BaseItemViewModel;
import com.lserj.bigserj.domain.entity.Data;

public class GifViewItemViewModel extends BaseItemViewModel<Data> {

    public ObservableField<Boolean> backgroundColor = new ObservableField<>();

    public ObservableField<Data> data = new ObservableField<>();

    @Override
    public void setItem(Data item, int position) {
        data.set(item);
        if (position % 2 == 0)
            backgroundColor.set(false);
        else
            backgroundColor.set(true);
    }
}