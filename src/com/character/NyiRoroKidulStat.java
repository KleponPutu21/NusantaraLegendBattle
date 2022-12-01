package com.character;


public class NyiRoroKidulStat extends Character implements CharaSkill{

	
	public NyiRoroKidulStat(int nyiHP, int nyiBaseAttPoint) {
		super(nyiHP, nyiBaseAttPoint);
	}
	
	
	

	@Override
	public int attBasicAttack() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint());
	}

	@Override
	public int attSkill() {
		return(this.getbaseAttPoint() + this.randExtraAtt(20, 50));
	}

	@Override
	public int attUltimateSkill() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint() + this.randExtraAtt(60, 100));
	}
	
	
}
