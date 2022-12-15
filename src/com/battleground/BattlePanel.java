package com.battleground;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class BattlePanel extends JPanel{

	Player player1, player2;
	public BattlePanel(Player P1, Player P2, int width, int height) {
		this.player1 = P1;
		this.player2 = P2;
		
		this.setPreferredSize(new Dimension(width, height));
		
		this.setFocusable(true);
	}

	

	
}
