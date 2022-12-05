package com.battleground;

import javax.swing.JButton;

public class AttackButton {

	private String buttonType;
	private JButton button;
	
	public AttackButton(String type) {
		this.buttonType = type;
		this.button = new JButton(buttonType);
	}
	
}
