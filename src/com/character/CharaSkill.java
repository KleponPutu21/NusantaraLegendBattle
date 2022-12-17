package com.character;

import java.awt.Graphics;

public interface CharaSkill {

	public void attBasicAttack(Character c); // basic Attack
	
	public void attSkill(Character c); // Skill 1
	
	public void attUltimateSkill(Character c); //Skill 2
	
	public void draw(Graphics g);
	
}
