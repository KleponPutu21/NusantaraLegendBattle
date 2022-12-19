package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BattleSystem implements KeyListener{

	private static final int PLAYER1_TURN = 1;
	private static final int PLAYER2_TURN = 2;
	
	private Player p1, p2;
	private List<AttackingKey> attKeys;
	private int turnState;
	private GamePanel gp;

	public BufferedImage bg_battle;
	
	public BattleSystem(Player p1, Player p2, GamePanel gp) {
		this.p1 = p1;
		this.p2 = p2;
		this.gp = gp;
		this.turnState = PLAYER1_TURN;
		
		this.attKeys = new ArrayList<>();
		this.attKeys.add(new AttackingKey('a'));
		this.attKeys.add(new AttackingKey('s'));
		this.attKeys.add(new AttackingKey('d'));
		
	}
	
	public void setTurnState(int state) {
		this.turnState = state;
	}

	public void getImageBattle(){
        try {
            bg_battle = ImageIO.read(getClass().getResourceAsStream("/battle-panel/battle_background.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
	
	public void draw(Graphics2D g2) {
		g2.drawImage(bg_battle, 0, 0, 640, 480, null);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(gp.gameState == gp.battleState) {
			for(AttackingKey ak :this.attKeys) {
				if(ak.isSymbolMatch(key) && key == 'a') {
					if(turnState == PLAYER1_TURN) {
						p1.playerAttack(p2);
					}else if(turnState == PLAYER2_TURN) { 
						p2.playerAttack(p1);
					}
				}else if(ak.isSymbolMatch(key) && key == 's') {
					if(turnState == PLAYER1_TURN) {
						p1.playerSkill(p2);
					}else if(turnState == PLAYER2_TURN) {
						p2.playerSkill(p1);
					}
				}else if(ak.isSymbolMatch(key) && key == 'd') {
					if(turnState == PLAYER1_TURN) {
						p1.playerUltimateSkill(p2);
					}else if(turnState == PLAYER2_TURN) {
						p2.playerUltimateSkill(p1);
					}
				}
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(gp.gameState == gp.battleState) {
			for(AttackingKey ak : this.attKeys) {
				if(ak.isSymbolMatch(key)) {
					if(turnState == PLAYER1_TURN) {
						if(p2.isPlayerDead()) {		//p2 kalah
							p2.playerDead();
							// state berubah game selesai
						}
						this.setTurnState(PLAYER2_TURN);
						
					}else if(turnState == PLAYER2_TURN) {
						if(p1.isPlayerDead()) {		//p1 kalah
							p1.playerDead();
							// state berubah game selesai
						}
						this.setTurnState(PLAYER1_TURN);
					}
					
				}
			}
		}
		
	}
	
	
	
}
