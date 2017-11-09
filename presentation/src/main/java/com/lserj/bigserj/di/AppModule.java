package com.lserj.bigserj.di;


import com.lserj.bigserj.domain.interaction.GetSearchUseCase;
import com.lserj.bigserj.domain.interaction.GetTrendUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    @Provides
    @Singleton
    GetSearchUseCase getSearchUseCase(){
        return new GetSearchUseCase();
    }

    @Provides
    @Singleton
    GetTrendUseCase getTrendUseCase(){
        return new GetTrendUseCase();
    }

}
