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

public class BattleSystem implements KeyListener{

	private static int PLAYER1_TURN = 1;
	private static int PLAYER2_TURN = 2;
	
	public Player p1, p2;
	private List<AttackingKey> attKeys;
	private int turnState;
	private GamePanel gp;
	
	private int defaulthHPBar = 200;
	private int HPbarP1, HPBarP2;

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
		
		this.HPbarP1 = defaulthHPBar;
		this.HPBarP2 = defaulthHPBar;
		
		setImageBattle();
	}
	
	public void setTurnState() {
		if(this.turnState == PLAYER1_TURN) {
			this.turnState = PLAYER2_TURN;
		}else if(this.turnState == PLAYER2_TURN) {
			this.turnState = PLAYER1_TURN;
		}
	}
	
	public void setHPBarP1() {
		if(p1.getPlayerHealth() != 1000) {
			System.out.println(p1.getPlayerHealth());
			this.HPbarP1 = (p1.getPlayerHealth() / 1000) * defaulthHPBar;
			System.out.println("p1 health decrease" + this.HPbarP1);
		}
	}
	
	public void setHPBarP2() {
		if(p2.getPlayerHealth() != 1000) {
			System.out.println(p2.getPlayerHealth());
			this.HPBarP2 = (p2.getPlayerHealth() / 1000) * defaulthHPBar;
			System.out.println("p2 health decrease" + this.HPBarP2);
		}
	}
	
	
	public void setImageBattle() {
		if(gp.gameState == gp.battleState) {
			getImageBattle();
		}
	}

	public void getImageBattle(){
        try {
            bg_battle = ImageIO.read(getClass().getResourceAsStream("/battle-panel/battle_background.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

	public int setWinner(){
		if(p1.isPlayerDead()){
			return 2;
		}
		else if(p2.isPlayerDead()){
			return 1;
		}
		return 0;
	}
	
	public void update() {
		setImageBattle();
		//setHPBarP1();
		//setHPBarP2();
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(bg_battle, 0, 0, 640, 480, null);
		p1.avatarDraw(g2);
		p2.avatarDraw(g2);
		g2.setColor(Color.WHITE);
		g2.fillRect(60, 40, this.HPbarP1, 10);
		g2.fillRect(400, 40, this.HPBarP2, 10);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(gp.gameState == gp.battleState) {
			//for(AttackingKey ak :this.attKeys) {
		//		if(ak.isSymbolMatch(key) && key == 'a') {
					//if(turnState == PLAYER1_TURN) {
				//		p1.playerAttack(p2);
			//			System.out.println("p1 use attack to p2");
		//			}else if(turnState == PLAYER2_TURN) { 
						//p2.playerAttack(p1);
					//	System.out.println("p2 use attack to p1");
				//	}
			//	}else if(ak.isSymbolMatch(key) && key == 's') {
		//			if(turnState == PLAYER1_TURN) {
						//p1.playerSkill(p2);
					//	System.out.println("p1 use skill to p2");
				//	}else if(turnState == PLAYER2_TURN) {
			//			p2.playerSkill(p1);
						//System.out.println("p2 use skill to p1");
					//}
				//}else if(ak.isSymbolMatch(key) && key == 'd') {
			//		if(turnState == PLAYER1_TURN) {
		//				p1.playerUltimateSkill(p2);
						//System.out.println("p1 use ultimate to p2");
					//}else if(turnState == PLAYER2_TURN) {
				//		p2.playerUltimateSkill(p1);
						//System.out.println("p2 use ultimate to p1");
					//}
				//}
			//}
			if(key == e.VK_A) {
				if(this.turnState == PLAYER1_TURN) {
					p1.playerAttack(p2);
					System.out.println("p1 attack p2");
				}else if(this.turnState == PLAYER2_TURN) {
					p2.playerAttack(p1);
					System.out.println("p2 attack p1");
				}
			}else if(key == e.VK_S) {
				if(this.turnState == PLAYER1_TURN) {
					p1.playerSkill(p2);
					System.out.println("p1 skill p2");
				}else if(this.turnState == PLAYER2_TURN) {
					p2.playerSkill(p1);
					System.out.println("p2 skill p1");
				}
			}else if(key == e.VK_D) {
				if(this.turnState == PLAYER1_TURN) {
					p1.playerUltimateSkill(p2);
					System.out.println("p1 ultimate p2");
				}else if(this.turnState == PLAYER2_TURN) {
					p2.playerUltimateSkill(p1);
					System.out.println("p2 ultimate p1");
				}
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(gp.gameState == gp.battleState) {
			//for(AttackingKey ak : this.attKeys) {
				//if(ak.isSymbolMatch(key)) {
			//		if(turnState == PLAYER1_TURN) {
		//				if(p2.isPlayerDead()) {		//p2 kalah
	//						p2.playerDead();
							//gp.gameState = gp.endGameState;
							// state berubah game selesai
						//}
					//	this.setTurnState(PLAYER2_TURN);	
				//	}else if(turnState == PLAYER2_TURN) {
			//			if(p1.isPlayerDead()) {		//p1 kalah
		//					p1.playerDead();
							// state berubah game selesai
							//gp.gameState = gp.endGameState;
						//}
					//	this.setTurnState(PLAYER1_TURN);
				//	}	
			//	}
		//	}
			if(key == e.VK_A || key == e.VK_S || key == e.VK_D) {
				if(this.turnState == PLAYER1_TURN) {
					if(p2.isPlayerDead()) {
						p2.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p1 win");
					}
					setHPBarP2();
					setTurnState();
					System.out.println("switch turn");
				}else if(this.turnState == PLAYER2_TURN) {
					if(p1.isPlayerDead()) {
						p1.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p2 win");
					}
					setHPBarP1();
					setTurnState();
					System.out.println("switch turn");
				}
			}
		}
		
	}
	
	
	
}
