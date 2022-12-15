package com.character;


public class NyiRoroKidulStat extends Character{

	
	public NyiRoroKidulStat(int nyiHP, int nyiBaseAttPoint) {
		super(nyiHP, nyiBaseAttPoint);
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
	
	
}
