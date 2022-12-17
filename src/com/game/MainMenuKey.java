package com.game;

public class MainMenuKey {
    private int code;

    public MainMenuKey(int code){
        this.code = code;
    }

    public boolean isCodeMatch(int code){
        if(this.code == code){
            return true;
        }
        return false;
    }

    public int getCode() {
        return this.code;
    }
}
