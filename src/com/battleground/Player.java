package com.battleground;

import com.character.Character;
import com.character.ArjunaStat;
import com.character.NyiRoroKidulStat;
import com.character.PitungStat;
import com.character.CharaSkill;

public class Player{

	private final int defaultHP = 1000;
	private final int defaultAP = 100;
	
	private int characterCode;
	private Character avatar;
	
	public Player(int cCode) {
		this.characterCode = cCode;
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


	
	
}
