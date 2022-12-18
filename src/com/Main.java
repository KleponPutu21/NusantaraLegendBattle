package com;

import javax.swing.JFrame;

import com.game.GamePanel;
import com.game.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Nusantara Legend Battle");

		GamePanel gamePanel = new GamePanel(640, 480);
		frame.add(gamePanel);
		
		gamePanel.startGameThread();
		gamePanel.setupGame();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		gamePanel.setupGame();

	}

}
