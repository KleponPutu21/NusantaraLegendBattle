package com.game;

import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private BattleSystem bs;
	
	public GamePanel(Player p1, Player p2, int width, int height) {
		
		this.setPreferredSize(new Dimension(width, height));
		this.bs = new BattleSystem(p1, p2);
		
		this.addKeyListener(bs);
		this.setFocusable(true);
	}
	

	
}
