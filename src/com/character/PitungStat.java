package com.character;


public class PitungStat extends Character implements CharaSkill{

	
	public PitungStat(int PitungHP, int PitungBaseAttPoint) {
		super(PitungHP, PitungBaseAttPoint);
	}

	@Override
	public void attBasicAttack(Character c) {
		// TODO Auto-generated method stub
		c.setHealthPoint(c.getHealthPoint() - this.getbaseAttPoint());
	}

	@Override
	public void attSkill(Character c) {
		// TODO Auto-generated method stub
	} //perlu diganti biar sesuai sama skill nya

	@Override
	public void attUltimateSkill(Character c) {
		// TODO Auto-generated method stub
		int att = this.getbaseAttPoint() + this.randExtraAtt(60, 40);
		c.setHealthPoint(c.getHealthPoint() - att);
	}
	
	
	
}
