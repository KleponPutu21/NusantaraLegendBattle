package com.character;

import java.util.Random;

public abstract class Character implements CharacterSkill{

	public final static int DO_NOTHING = 0;
	public final static int USING_ATTACK = 1;
	public final static int USING_SKILL = 2;
	public final static int USING_ULTIMATE = 4;
	
	protected int skillAnimationState;
	protected int characterState;
	
	private int healthPoint;
	private int baseAttPoint;
	private Random rand = new Random();
	
	
	public Character(int healthPoint, int baseAttPoint) {
		this.healthPoint = healthPoint;
		this.baseAttPoint = baseAttPoint;
	}
	
	public int getHealthPoint() {
		return this.healthPoint;
	}
	
	public int getbaseAttPoint() {
		return this.baseAttPoint;
	}
	
	public void setHealthPoint(int currHealthPoint) {
		this.healthPoint = currHealthPoint;
	}
	
	public int randExtraAtt(int a, int b) {
		return(a + rand.nextInt(b));
	}
	
}
