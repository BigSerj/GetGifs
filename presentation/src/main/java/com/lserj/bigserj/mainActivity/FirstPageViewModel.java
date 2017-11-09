package com.lserj.bigserj.mainActivity;


import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.lserj.bigserj.TestApplication;
import com.lserj.bigserj.base.BaseViewModel;
import com.lserj.bigserj.domain.entity.GifList;
import com.lserj.bigserj.domain.interaction.GetSearchUseCase;
import com.lserj.bigserj.domain.interaction.GetTrendUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class FirstPageViewModel implements BaseViewModel {


    private FirstPageActivity firstPageActivity;

    FirstPageViewModel(FirstPageActivity firstPageActivity) {
        this.firstPageActivity = firstPageActivity;
        TestApplication.appComponent.inject(this);
    }

    @Inject
    GetTrendUseCase getTrendUseCase;
    @Inject
    GetSearchUseCase getSearchUseCase;


    GifViewAdapter gifViewAdapter = new GifViewAdapter();




    @Override
    public void init() {
        executeTrend();
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
        getTrendUseCase.dispose();
        getSearchUseCase.dispose();
    }




    private void executeTrend() {
        getTrendUseCase.execute(null, new DisposableObserver<GifList>() {
            @Override
            public void onNext(@NonNull GifList gifList) {
                gifViewAdapter.setItems(gifList.getDataList());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAAA items = ", e.toString());
            }

            @Override
            public void onComplete() {
                Log.e("AAAA item", "onComplete");
            }
        });
    }

    public void executeSearch() {

        getTrendUseCase.dispose();
        getSearchUseCase.dispose();

        firstPageActivity.binding.recyclerView.scrollToPosition(0);

        InputMethodManager imm = (InputMethodManager) firstPageActivity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(firstPageActivity.binding.search.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        String search = firstPageActivity.binding.searchText.getText().toString();

        if (search.isEmpty())
            executeTrend();
        else {

            getSearchUseCase.execute(search, new DisposableObserver<GifList>() {
                @Override
                public void onNext(@NonNull GifList gifList) {
                    gifViewAdapter.setItems(gifList.getDataList());
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.e("AAAA items = ", e.toString());
                }

                @Override
                public void onComplete() {
                    Log.e("AAAA item", "onComplete");
                }
            });
        }
    }


}
