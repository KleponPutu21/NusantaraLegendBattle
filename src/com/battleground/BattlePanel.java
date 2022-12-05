package com.battleground;


import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import com.character.PitungStat;
import com.character.ArjunaStat;
import com.character.NyiRoroKidulStat;


public class BattlePanel extends JPanel implements KeyListener{

	private Character player1, player2;
	private List<AttackButton> attButtons;
	
	public BattlePanel(Character P1, Character P2, int width, int height) {
		this.player1 = P1;
		this.player2 = P2;
		
		this.setPreferredSize(new Dimension(width, height));
		
		this.attButtons = new ArrayList<AttackButton>();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
