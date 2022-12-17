package com.character;

import java.awt.Graphics;

public class NyiRoroKidulStat extends Character{

	private final static int WATER_BALL = 0;
	private final static int WATER_WAVE = 1;
	
	public NyiRoroKidulStat(int nyiHP, int nyiBaseAttPoint, int mp) {
		super(nyiHP, nyiBaseAttPoint, mp);
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




	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		switch (this.characterState) {
		case 0:
			//nyi roro kidul do nothing
			break;
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
	public void drawAnimation(Graphics g) {
		// TODO Auto-generated method stub
		if(this.skillAnimationState == WATER_BALL) {
			//draw water ball;
		}else if(this.skillAnimationState == WATER_WAVE) {
			//draw water wave;
		}
	}
	
	
}
