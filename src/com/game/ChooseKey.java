package com.game;

public class ChooseKey {

    private int code;

    public ChooseKey(int code){
        this.code = code;
    }

    public boolean isCodeMatch(int code) {
		if(this.code == code) {
			return true;
		}
		return false;
	}
	
	public int getCode() {
		return this.code;
	}
}
