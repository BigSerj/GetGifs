package com.lserj.bigserj.domain.interaction;


import com.lserj.bigserj.data.net.RestService;
import com.lserj.bigserj.domain.entity.Data;
import com.lserj.bigserj.domain.entity.GifList;
import com.lserj.bigserj.domain.entity.Images;
import com.lserj.bigserj.domain.entity.Original;
import com.lserj.bigserj.domain.interaction.base.UseCase;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetSearchUseCase extends UseCase<String, GifList> {


    @Override
    protected Observable<GifList> buildUseCase(String search) {

        return RestService
                .getInstance()
                .getSearch(search)
                .map(new Function<com.lserj.bigserj.data.entity.GifList, GifList>() {
                    @Override
                    public GifList apply(@NonNull com.lserj.bigserj.data.entity.GifList gifListData) throws Exception {

                        GifList gifListModel = new GifList();
                        ArrayList<Data> gifArrayList = new ArrayList<>();

                        for (int i = 0; i < gifListData.getDataList().size(); i++) {
                            Data data = new Data();
                            Images image = new Images();
                            Original original = new Original();
                            original.setUrl(gifListData.getDataList().get(i).getImages().getOriginal().getUrl());
                            image.setOriginal(original);
                            data.setImages(image);
                            data.setId(gifListData.getDataList().get(i).getId());

                            gifArrayList.add(data);
                        }
                        gifListModel.setDataList(gifArrayList);
                        return gifListModel;
                    }
                });
    }
}