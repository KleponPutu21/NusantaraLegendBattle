package com.character;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface CharacterSkill {

	public void attBasicAttack(Character c); // basic Attack
	
	public void attSkill(Character c); // Skill 1
	
	public void attUltimateSkill(Character c); //Skill 2
	
	public void draw(Graphics2D g2);
	
	public void drawAnimation(Graphics2D g2);
	
}
