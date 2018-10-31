package com.camera.sample.main;

public class MainViewState {

    private boolean isLoading;

    /* default */ MainViewState(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public boolean isLoading() {
        return isLoading;
    }
}
