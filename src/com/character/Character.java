package com.character;

import java.util.Random;

public abstract class Character implements CharacterSkill{

	//untuk draw karakter
	public final static int DO_NOTHING = 0;
	public final static int USING_ATTACK = 1;
	public final static int USING_SKILL = 2;
	public final static int USING_ULTIMATE = 4;
	protected int characterState;
	
	//untuk animasi skill
	protected int skillAnimationState;
	
	private int healthPoint;
	private int baseAttPoint;
	private int manaPoint;
	private Random rand = new Random();
	
	
	public Character(int healthPoint, int baseAttPoint, int manaPoint) {
		this.healthPoint = healthPoint;
		this.baseAttPoint = baseAttPoint;
		this.manaPoint = manaPoint;
		this.characterState = DO_NOTHING;
	}
	
	public int getHealthPoint() {
		return this.healthPoint;
	}
	
	public int getbaseAttPoint() {
		return this.baseAttPoint;
	}
	
	public int getManaPoint() {
		return this.manaPoint;
	}
	
	public void setHealthPoint(int currHealthPoint) {
		this.healthPoint = currHealthPoint;
	}
	
	public void setManaPoint(int currManaPoint) {
		this.manaPoint = currManaPoint;
	}
	
	public void setCharacterState(int state) {
		this.characterState = state;
	}
	
	public int randExtraAtt(int a, int b) {
		return(a + rand.nextInt(b));
	}
	
}
