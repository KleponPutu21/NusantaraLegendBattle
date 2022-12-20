package com.character;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArjunaStat extends Character{

	private final static int ARROW = 0;
	private final static int FIRE_ARROW = 1;
	
	private int idleState;
	private final int firstIdle = 1;
	private final int secondIdle = 2;
	
	public BufferedImage arjunaP1Idle1, arjunaP1Idle2;
	public BufferedImage arjunaP2Idle1, arjunaP2Idle2;
	public BufferedImage arjunaP1Attack1, arjunaP1Attack2;
	public BufferedImage arjunaP2Attack1, arjunaP2Attck2;
	
	private int playerPos;
	private final int p1 = 1;
	private final int p2 = 2;
	
	public ArjunaStat(int ArjunaHP, int ArjunaBaseAttPoint, int mp, int playerPos) {
		super(ArjunaHP, ArjunaBaseAttPoint, mp);
		this.playerPos = playerPos;
		//perlu ditambahi buat ngatur statenya
		getImageArjuna();
		this.idleState = firstIdle;
	}
	
	public void setIdleState() {
		if(this.idleState == firstIdle) {
			this.idleState = secondIdle;
		}else if(this.idleState == secondIdle) {
			this.idleState = firstIdle;
		}
	}

	@Override
	public void attBasicAttack(Character enemy) {
		// TODO Auto-generated method stub
		enemy.setHealthPoint(enemy.getHealthPoint() - this.getbaseAttPoint());
	}

	@Override
	public void attSkill(Character enemy) {
		// TODO Auto-generated method stub
		// 120 - 150
		int att = this.getbaseAttPoint() + this.randExtraAtt(20, 30);
		enemy.setHealthPoint(enemy.getHealthPoint() - att);
	}

	@Override
	public void attUltimateSkill(Character enemy) {
		// TODO Auto-generated method stub
		// 160 - 200
		int att = this.getbaseAttPoint() + this.randExtraAtt(60, 40);
		enemy.setHealthPoint(enemy.getHealthPoint() - att);
	}
	
	public void getImageArjuna() {
		try {
			arjunaP1Idle1 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/arjuna_p1_idle_cut1.png"));
			arjunaP1Idle2 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/arjuna_p1_idle_cut2.png"));
			arjunaP2Idle1 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/arjuna_p2_idle_cut1.png"));
			arjunaP2Idle2 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/arjuna_p2_idle_cut2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		switch (this.characterState) {
		case 0:
			//Arjuna do nothing
			if(this.playerPos == p1) {
				if(this.idleState == firstIdle) {
					g2.drawImage(arjunaP1Idle1, 0, 150, 200, 200, null);
					setIdleState();
					break;
				}else if(this.idleState == secondIdle) {
					g2.drawImage(arjunaP1Idle2, 0, 150, 200, 200, null);
					setIdleState();
					break;
				}
			}else if(this.playerPos == p2) {
				if(this.idleState == firstIdle) {
					g2.drawImage(arjunaP2Idle1, 450, 150, 200, 200, null);
					setIdleState();
					break;
				}else if(this.idleState == secondIdle) {
					g2.drawImage(arjunaP2Idle2, 450, 150, 200, 200, null);
					setIdleState();
					break;
				}
			}
		case 1:
			//arjuna attack
			break;
		case 2:
			//arjuna using skill
			break;
		case 3:
			//arjuna using ultimate
			break;
		}
	}


	@Override
	public void drawAnimation(Graphics2D g2) {
		// TODO Auto-generated method stub
		if(this.skillAnimationState == ARROW) {
			//draw arrow
		}else if(this.skillAnimationState == FIRE_ARROW) {
			//draw fire arrow
		}
	}
	
	
	
}
