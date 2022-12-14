package com.battleground;

import javax.swing.JButton;

public class AttackButton {

	private String buttonType;
	private char symbol;
	
	public AttackButton(String type, char symbol) {
		this.buttonType = type;
		this.symbol = symbol;
	}
	
	public boolean isSymbolMatch(char symbol) {
		if(this.symbol == symbol) {
			return true;
		}
		
		return false;
	}
	
}
