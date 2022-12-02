package com.character;


public class ArjunaStat extends Character implements CharaSkill{

	
	public ArjunaStat(int ArjunaHP, int ArjunaBaseAttPoint) {
		super(ArjunaHP, ArjunaBaseAttPoint);
	}
	

	@Override
	public int attBasicAttack() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint());
	}

	@Override
	public int attSkill() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint() + this.randExtraAtt(20, 50)); // 120 - 170
	}

	@Override
	public int attUltimateSkill() {
		// TODO Auto-generated method stub
		return (this.getbaseAttPoint() + this.randExtraAtt(60, 100)); // 160 - 260
	}
	
	
	
}
