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
	
	private double defaulthHPBar = 200;
	private double HPbarP1, HPBarP2;

	private double defaultManaBar = 100;
	private double manaBarP1, manaBarP2;
	
	private double currP2_Hp_Xpos = 400, currP2_Mp_Xpos = 500;
	
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
		
		this.manaBarP1 = defaultManaBar;
		this.manaBarP2 = defaultManaBar;
		
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
			System.out.println("P1 hp : " + p1.getPlayerHealth());
			this.HPbarP1 = 0.2 * p1.getPlayerHealth();
			System.out.println("p1 health decrease" + this.HPbarP1);
		}
	}
	
	public void setHPBarP2() {
		if(p2.getPlayerHealth() != 1000) {
			System.out.println("P2 hp : " + p2.getPlayerHealth());
			double temp = 0.2 * p2.getPlayerHealth();
			double temp2 = HPBarP2 - temp;
			this.HPBarP2 = temp;
			this.currP2_Hp_Xpos += temp2;
			System.out.println("p2 health decrease" + this.HPBarP2);
		}
	}
	
	public void setManaBarP1() {
		if(p1.getPlayerMana() != 500) {
			System.out.println("P1 mp : " + p1.getPlayerMana());
			this.manaBarP1 = 0.2 * p1.getPlayerMana();
			System.out.println("p1 mp bar : " + this.manaBarP1);
		}
	}
	
	public void setManaBarP2() {
		if(p2.getPlayerMana() != 500) {
			System.out.println("P2 mp : " + p2.getPlayerMana());
			double temp = 0.2 * p2.getPlayerMana();
			double temp2 = manaBarP2 - temp;
			this.manaBarP2 = temp;
			this.currP2_Mp_Xpos += temp2;
			System.out.println("p2 mp bar : " + this.manaBarP2);
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
		g2.setColor(Color.GREEN);
		g2.fillRect(60, 40,(int)this.HPbarP1, 10);
		g2.fillRect((int)this.currP2_Hp_Xpos, 40, (int)this.HPBarP2, 10);
		g2.setColor(Color.BLUE);
		g2.fillRect(60, 55, (int)this.manaBarP1, 10);
		g2.fillRect((int)this.currP2_Mp_Xpos, 55, (int)this.manaBarP2, 10);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(gp.gameState == gp.battleState) {
			if(key == e.VK_A) {
				if(this.turnState == PLAYER1_TURN) {
					p1.playerAttack(p2);
					System.out.println("p1 attack p2");
				}else if(this.turnState == PLAYER2_TURN) {
					p2.playerAttack(p1);
					System.out.println("p2 attack p1");
				}
			}else if(key == e.VK_S) {
				if(this.turnState == PLAYER1_TURN && p1.getPlayerMana() >= 100) {
					p1.playerSkill(p2);
					p1.setSuccessSkillState();
					System.out.println("p1 skill p2");
					System.out.println("p1's skill state : " + p1.successSkillState);
				}else if(this.turnState == PLAYER2_TURN && p2.getPlayerMana() >= 100) {
					p2.playerSkill(p1);
					p2.setSuccessSkillState();
					System.out.println("p2 skill p1");
				}
			}else if(key == e.VK_D) {
				if(this.turnState == PLAYER1_TURN && p1.getPlayerMana() >= 150) {
					p1.playerUltimateSkill(p2);
					p1.setSuccessUltimateState();
					System.out.println("p1's ultimate state : " + p1.successUltimateState);
					System.out.println("p1 ultimate p2");
				}else if(this.turnState == PLAYER2_TURN && p2.getPlayerMana() >= 150) {
					p2.playerUltimateSkill(p1);
					p2.setSuccessUltimateState();
					System.out.println("p2 ultimate p1");
				}
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char key = e.getKeyChar();
		
		if(gp.gameState == gp.battleState) {
			if(key == e.VK_A) {
				if(this.turnState == PLAYER1_TURN) {
					if(p2.isPlayerDead()) {
						p2.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p1 win");
					}
					setHPBarP2();
					System.out.println("p2 terkena attack, switch turn");
				}else if(this.turnState == PLAYER2_TURN) {
					if(p1.isPlayerDead()) {
						p1.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p1 win");
					}
					setHPBarP1();
					System.out.println("p1 terkena attack, switch turn");
				}
				setTurnState();
			}else if(key == e.VK_S) {
				if(this.turnState == PLAYER1_TURN && p1.isSkillSuccess()) {
					if(p2.isPlayerDead()) {
						p2.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p1 win");
					}
					setHPBarP2();
					setManaBarP1();
					setTurnState();
					p1.setSuccessSkillState();
					System.out.println("p1's skill state : " + p1.successSkillState);
					System.out.println("p2 terkena skill, switch turn");
				}else if(this.turnState == PLAYER2_TURN && p2.isSkillSuccess()) {
					if(p1.isPlayerDead()) {
						p1.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p1 win");
					}
					setHPBarP1();
					setManaBarP2();
					setTurnState();
					p2.setSuccessSkillState();
					System.out.println("p1 terkena skill, switch turn");
				}else {
					System.out.println("Mana tidak cukup untuk skill");
				}
			}else if(key == e.VK_D) {
				if(this.turnState == PLAYER1_TURN && p1.isUltimateSuccess()) {
					if(p2.isPlayerDead()) {
						p2.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p1 win");
					}
					setHPBarP2();
					setManaBarP1();
					setTurnState();
					p1.setSuccessUltimateState();
					System.out.println("p1's ultimate state : " + p1.successUltimateState);
					System.out.println("p2 terkena ultimate, switch turn");
				}else if(this.turnState == PLAYER2_TURN && p2.isUltimateSuccess()) {
					if(p1.isPlayerDead()) {
						p1.playerDead();
						gp.gameState = gp.endGameState;
						System.out.println("game over p1 win");
					}
					setHPBarP1();
					setManaBarP2();
					setTurnState();
					p2.setSuccessUltimateState();
					System.out.println("p1 terkena ultimate, switch turn");
				}else {
					System.out.println("Mana tidak cukup untuk ultimate");
				}
			}
			System.out.println();
		}
		
	}
	
	
	
}
