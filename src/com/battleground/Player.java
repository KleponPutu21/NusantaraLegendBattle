package com.battleground;

import com.character.Character;
import com.character.ArjunaStat;
import com.character.NyiRoroKidulStat;
import com.character.PitungStat;
import com.character.CharaSkill;

public class Player{

	private final int defaultHP = 1000;
	private final int defaultAP = 100;
	private final static int DEAD = 0;
	private final static int ALIVE = 1;
	
	private int characterCode;
	private int playerStatus;
	Character avatar;
	
	public Player(int cCode) {
		this.characterCode = cCode;
		this.playerStatus = ALIVE;
	}
	
	public void setKarakter() {
		switch(this.characterCode) {
		case 1:
			this.avatar = new NyiRoroKidulStat(defaultHP, defaultAP);
			break;
		case 2:
			this.avatar = new ArjunaStat(defaultHP, defaultAP);
		}
		
	}
	
	public void playerAttack(Player p) {
		avatar.attBasicAttack(p.avatar);
	}
	
	public void playerSkill(Player p) {
		avatar.attSkill(p.avatar);
	}
	
	public void playerUltimateSkill(Player p) {
		avatar.attUltimateSkill(p.avatar);
	}

	public void playerDead() {
		if(avatar.getHealthPoint() == 0) {
			this.playerStatus = DEAD;
		}
	}
	
	public boolean isPlayerDead() {
		if(avatar.getHealthPoint() == 0) return true;
		return false;
	}
	
}
