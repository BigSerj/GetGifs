package com.lserj.bigserj.base;


public abstract class BaseItemViewModel<Model> implements BaseViewModel {

    protected abstract void setItem(Model item, int position);

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
