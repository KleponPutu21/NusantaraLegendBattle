package com.character;


public class ArjunaStat extends Character{

	
	public ArjunaStat(int ArjunaHP, int ArjunaBaseAttPoint) {
		super(ArjunaHP, ArjunaBaseAttPoint);
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
	
	
	
}
