package com.lserj.bigserj.data.net;


import com.lserj.bigserj.data.entity.GifList;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lserj.bigserj.data.Constants.MYPASS;


public class RestService {

    private static final RestService instance = new RestService();

    private RestApi restApi;

    public static RestService getInstance() {
        return instance;
    }

    private RestService() {
        init();
    }


    private void init() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.giphy.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        restApi = retrofit.create(RestApi.class);
    }




    public Observable<GifList> getTrend(){
        return restApi.getTrend(MYPASS);
    }

    public Observable<GifList> getSearch(String search){
        return restApi.getSearch(search, MYPASS);
    }


}