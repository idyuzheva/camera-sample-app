package com.camera.sample.main;

public class MainPresenter {

    private MainView view;

    /* default */ MainPresenter() {
    }

    public void startPresenting(MainView view) {
        this.view = view;
    }

    public void stopPresenting() {

    }
}
