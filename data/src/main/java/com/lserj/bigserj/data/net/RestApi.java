package com.lserj.bigserj.data.net;


import com.lserj.bigserj.data.entity.GifList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RestApi {

    @GET("v1/gifs/trending")
    Observable<GifList> getTrend(@Query("api_key") String pass);

    @GET("v1/gifs/search")
    Observable<GifList> getSearch(@Query("q") String search, @Query("api_key") String pass);

}