package com.game;

public class AttackingKey {

	private static final int PRESSED = 1;
	private static final int RELEASED = 2;
	
	private char symbol;
	private int state;
	
	public AttackingKey(char symbol) {
		this.symbol = symbol;
		this.state = RELEASED;
	}
	
	public boolean isSymbolMatch(char s) {
		if(this.symbol == s) {
			return true;
		}
		return false;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public void setPressed() {
		this.state = PRESSED;
	}
	
	public void setReleased() {
		this.state = RELEASED;
	}
}
