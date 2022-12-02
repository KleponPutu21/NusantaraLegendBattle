package com.character;

import java.util.Random;

public class Character {

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
