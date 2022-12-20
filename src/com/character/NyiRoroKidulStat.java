package com.character;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NyiRoroKidulStat extends Character{

	private final static int WATER_BALL = 0;
	private final static int WATER_WAVE = 1;
	
	public BufferedImage nyirorokidulP1Idle1, nyirorokidulP1Idle2;
	public BufferedImage nyirorokidulP2Idle1, nyirorokidulP2Idle2;
	
	private int idleState;
	private final int firstIdle = 1;
	private final int secondIdle = 2;
	
	private int playerPos;
	private final int p1 = 1;
	private final int p2 = 2;
	
	public NyiRoroKidulStat(int nyiHP, int nyiBaseAttPoint, int mp, int playerPos) {
		super(nyiHP, nyiBaseAttPoint, mp);
		this.playerPos = playerPos;
		this.idleState = firstIdle;
		getImageNyirorokidul();
	}
	
	public void setIdleState() {
		if(this.idleState == firstIdle) {
			this.idleState = secondIdle;
		}else if(this.idleState == secondIdle) {
			this.idleState = firstIdle;
		}
	}

	@Override
	public void attBasicAttack(Character c) {
		// TODO Auto-generated method stub
		c.setHealthPoint(c.getHealthPoint() - this.getbaseAttPoint());
	}

	@Override
	public void attSkill(Character c) {
		int att = this.getbaseAttPoint() + this.randExtraAtt(20, 30);
		c.setHealthPoint(c.getHealthPoint() - att);
	}

	@Override
	public void attUltimateSkill(Character c) {
		// TODO Auto-generated method stub
		int att = this.getbaseAttPoint() + this.randExtraAtt(60, 40);
		c.setHealthPoint(c.getHealthPoint() - att);
	}

	public void getImageNyirorokidul() {
		try {
			nyirorokidulP1Idle1 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/nyirorokidul_p1_idle_cut1.png"));
			nyirorokidulP1Idle2 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/nyirorokidul_p1_idle_cut2.png"));
			nyirorokidulP2Idle1 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/nyirorokidul_p2_idle_cut1.png"));
			nyirorokidulP2Idle2 = ImageIO.read(getClass().getResourceAsStream("/idle-cut/nyirorokidul_p2_idle_cut2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		switch (this.characterState) {
		case 0:
			//nyi roro kidul do nothing
			if(this.playerPos == p1) {
				if(this.idleState == firstIdle) {
					g2.drawImage(nyirorokidulP1Idle1, 0, 150, 200, 200, null);
					setIdleState();
					break;
				}else if(this.idleState == secondIdle) {
					g2.drawImage(nyirorokidulP1Idle2, 0, 150, 200, 200, null);
					setIdleState();
					break;
				}
			}else if(this.playerPos == p2) {
				if(this.idleState == firstIdle) {
					g2.drawImage(nyirorokidulP2Idle1, 450, 150, 200, 200, null);
					setIdleState();
					break;
				}else if(this.idleState == secondIdle) {
					g2.drawImage(nyirorokidulP2Idle2, 450, 150, 200, 200, null);
					setIdleState();
					break;
				}
			}
		case 1:
			//nyi roro kidul attack
			break;
		case 2:
			//nyi roro kidul using skill
			break;
		case 3:
			//nyi roro kidul using ultimate
			break;
		}
	}




	@Override
	public void drawAnimation(Graphics2D g2) {
		// TODO Auto-generated method stub
		if(this.skillAnimationState == WATER_BALL) {
			//draw water ball;
		}else if(this.skillAnimationState == WATER_WAVE) {
			//draw water wave;
		}
	}
	
	
}
