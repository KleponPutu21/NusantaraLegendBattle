package com.battleground;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BattleSystem extends JPanel implements KeyListener{

	private static final int PLAYER1_TURN = 1;
	private static final int PLAYER2_TURN = 2;
	
	private Player p1, p2;
	private List<AttackingKey> attKeys;
	private int turnState;
	
	public BattleSystem(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.turnState = PLAYER1_TURN;
		
		this.attKeys = new ArrayList<>();
		this.attKeys.add(new AttackingKey('a'));
		this.attKeys.add(new AttackingKey('s'));
		this.attKeys.add(new AttackingKey('d'));
		
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	public void setTurnState(int state) {
		this.turnState = state;
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
