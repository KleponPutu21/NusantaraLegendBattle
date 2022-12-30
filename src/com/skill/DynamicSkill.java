package com.skill;

import java.awt.Graphics2D;

public abstract class DynamicSkill implements skillDraw{

	
	protected int x, y;
	protected int speedX;
	
	protected int playerPosistion;
	protected final int P1_LEFT = 1;
	protected final int P2_RIGHT = 2;
	
	protected int launchState;
	protected final int notYet = 0;
	protected final int done = 1;
	
	public DynamicSkill(int playerPos) {
		this.playerPosistion = playerPos;
		this.speedX = 0;
		this.launchState = notYet;
		setSKillPos();
	}
	
	public void setSKillPos() {
		switch(this.playerPosistion) {
		case P1_LEFT:
			//atur posisi x dari kiri ke kanan
			this.x = 200;
			this.y = 160;
			break;
		case P2_RIGHT:
			//atur posisi x dari kiri kenan
			this.x = 450;
			this.y = 160;
			break;
		}
	}
	
	public void lauchSkill() {
		switch(this.playerPosistion) {
		case P1_LEFT:
			this.speedX = 5;
			break;
		case P2_RIGHT:
			this.speedX = -5;
			break;
		}
	}
	
	public boolean isNotHitEnemyYet() {
		switch(this.playerPosistion) {
		case P1_LEFT:
			if(this.x < 460) {
				return true;
			}
			return false;
		case P2_RIGHT:
			if(this.x > 90) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void resetSkill() {
		this.speedX = 0;
		setSKillPos();
	}
	
	public abstract void update();
}
