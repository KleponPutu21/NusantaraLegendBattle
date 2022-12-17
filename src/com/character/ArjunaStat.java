package com.character;

import java.awt.Graphics;

public class ArjunaStat extends Character{

	private final static int ARROW = 0;
	private final static int FIRE_ARROW = 1;
	
	
	public ArjunaStat(int ArjunaHP, int ArjunaBaseAttPoint) {
		super(ArjunaHP, ArjunaBaseAttPoint);
		this.characterState = DO_NOTHING;
		//perlu ditambahi buat ngatur statenya
	}
	

	@Override
	public void attBasicAttack(Character c) {
		// TODO Auto-generated method stub
		c.setHealthPoint(c.getHealthPoint() - this.getbaseAttPoint());
	}

	@Override
	public void attSkill(Character c) {
		// TODO Auto-generated method stub
		// 120 - 150
		int att = this.getbaseAttPoint() + this.randExtraAtt(20, 30);
		c.setHealthPoint(c.getHealthPoint() - att);
	}

	@Override
	public void attUltimateSkill(Character c) {
		// TODO Auto-generated method stub
		// 160 - 200
		int att = this.getbaseAttPoint() + this.randExtraAtt(60, 40);
		c.setHealthPoint(c.getHealthPoint() - att);
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void drawAnimation(Graphics g) {
		// TODO Auto-generated method stub
		if(this.skillAnimationState == ARROW) {
			//draw arrow
		}else if(this.skillAnimationState == FIRE_ARROW) {
			//draw fire arrow
		}
	}
	
	
	
}
