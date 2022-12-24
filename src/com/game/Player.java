package com.game;

import com.character.Character;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import com.character.ArjunaStat;
import com.character.NyiRoroKidulStat;
import com.character.CharacterSkill;

public class Player{

	private final int defaultHP = 1000;
	private final int defaultAP = 100;
	private final int defaultMP = 500;
	private final static int DEAD = 0;
	private final static int ALIVE = 1;
	//state skill untuk dikirimkan ke masing2 karakter untuk update draw
	private final static int DO_NOTHING = 0;
	private final static int USING_ATTACK = 1;
	private final static int USING_SKILL = 2;
	private final static int USING_ULTIMATE = 3;
	
	//untuk penggunaan skil, sukses atau tidak
		public int successSkillState, successUltimateState;
		public final int success = 1;
		public final int unSuccess = 0;
	
	private int characterCode;
	private int playerStatus;
	
	private int playerPos;
	private final int p1 = 1;
	private final int p2 = 2;
	
	Character avatar;
	
	public Player(int cCode, int playerPos) {
		this.characterCode = cCode;
		this.playerPos = playerPos;
		this.playerStatus = ALIVE;
		this.successSkillState = unSuccess;
		this.successUltimateState = unSuccess;
		setKarakter();
	}
	
	public void setKarakter() {
		switch(this.characterCode) {
		case 1:
			this.avatar = new ArjunaStat(defaultHP, defaultAP, defaultMP, playerPos);
			break;
		case 2:
			this.avatar = new NyiRoroKidulStat(defaultHP, defaultAP, defaultMP, playerPos);
			break;
		}
		avatar.setCharacterState(DO_NOTHING);
		
	}
	
	public void playerAttack(Player p) {
		avatar.attBasicAttack(p.avatar);
		avatar.setCharacterState(USING_ATTACK);
	}
	
	public void playerSkill(Player p) {
		avatar.attSkill(p.avatar);
		avatar.setCharacterState(USING_SKILL);
	}
	
	public void playerUltimateSkill(Player p) {
		avatar.attUltimateSkill(p.avatar);
		avatar.setCharacterState(USING_ULTIMATE);
	}
	
	public void setSuccessSkillState() {
		if(this.successSkillState == success) {
			this.successSkillState = unSuccess;
		}else if(this.successSkillState == unSuccess) {
			this.successSkillState = success;
		}
	}
	
	public boolean isSkillSuccess() {
		if(this.successSkillState == success) {
			return true;
		}
		return false;
	}
	
	public void setSuccessUltimateState() {
		if(this.successUltimateState == success) {
			this.successUltimateState = unSuccess;
		}else if(this.successUltimateState == unSuccess) {
			this.successUltimateState = success;
		}
	}
	
	public boolean isUltimateSuccess() {
		if(this.successUltimateState == success) {
			return true;
		}
		return false;
	}
	
	public int getPlayerHealth() {
		return(avatar.getHealthPoint());
	}
	
	public int getPlayerMana() {
		return(avatar.getManaPoint());
	}

	public void playerDead() {
		if(avatar.getHealthPoint() <= 0) {
			this.playerStatus = DEAD;
		}
	}
	
	public boolean isPlayerDead() {
		if(avatar.getHealthPoint() <= 0) return true;
		return false;
	}
	

	//draw
	public void avatarDraw(Graphics2D g2) {
		avatar.draw(g2);
	}
	
}
