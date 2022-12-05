package com.battleground;


import javax.swing.JPanel;
import com.character.PitungStat;
import com.character.ArjunaStat;
import com.character.NyiRoroKidulStat;


public class BattlePanel extends JPanel{

	private Character player1, player2;
	
	public BattlePanel(Character P1, Character P2, int width, int height) {
		this.player1 = P1;
		this.player2 = P2;
	}

	
}
