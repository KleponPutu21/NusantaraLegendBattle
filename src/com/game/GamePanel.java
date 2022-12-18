package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	int FPS = 60;

	Thread gameThread;

	public int gameState;
	public final int mainMenuState = 0;
	public final int selectCharacterPlayer1State = 1;
	public final int selectCharacterPlayer2State = 2;
	public final int battleState = 3;
	public final int endGameState = 4;


	private BattleSystem bs;
	private ChooseCharacter Character1, Character2;
	private Player player1, player2;
	private MainMenu menuPanel;

	public GamePanel(int width, int height) {
		
		this.setPreferredSize(new Dimension(width, height));
		this.Character1 = new ChooseCharacter(this);
		this.Character2 = new ChooseCharacter(this);
		this.player1 = this.Character1.getPlayer();
		this.player2 = this.Character2.getPlayer();
		this.bs = new BattleSystem(player1, player2, this);
		this.menuPanel = new MainMenu(this);
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(menuPanel);
		this.addKeyListener(bs);
		this.addKeyListener(Character1);
		this.addKeyListener(Character2);

		this.setFocusable(true);
	}
	
	public void setupGame() {
				
		gameState = mainMenuState;
	}

	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null) {
			
			update();
			repaint();
					
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}	
	}
	
	public void update(){
		menuPanel.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		menuPanel.draw(g2);
	}
}
