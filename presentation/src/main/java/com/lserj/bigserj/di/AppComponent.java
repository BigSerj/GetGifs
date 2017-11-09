package com.lserj.bigserj.di;


import com.lserj.bigserj.mainActivity.FirstPageViewModel;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

     void inject(FirstPageViewModel formPageViewModel);

}