package com.character;


public class PitungStat extends Character{

	
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
		int att = this.getbaseAttPoint() + this.randExtraAtt(10, 20);
		c.setHealthPoint(c.getHealthPoint() - att); //Berkurang 110 - 130
		this.setHealthPoint(this.randExtraAtt(50, 50)); // heal 50 - 100
		
	} //perlu diganti biar sesuai sama skill nya

	@Override
	public void attUltimateSkill(Character c) {
		// TODO Auto-generated method stub
		int att = this.getbaseAttPoint() + this.randExtraAtt(60, 40);
		c.setHealthPoint(c.getHealthPoint() - att);
	}
	
	
	
}
