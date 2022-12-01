package com.character;


public class PitungStat extends Character implements CharaSkill{

	
	public PitungStat(int PitungHP, int PitungBaseAttPoint) {
		super(PitungHP, PitungBaseAttPoint);
	}

	@Override
	public int attBasicAttack() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint());
	}

	@Override
	public int attSkill() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint() + this.randExtraAtt(20, 50));
	}

	@Override
	public int attUltimateSkill() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint() + this.randExtraAtt(60, 100));
	}
	
	
	
}
