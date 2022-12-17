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
	private ChooseCharacter p1, p2;
	
	public GamePanel(int width, int height) {
		
		this.setPreferredSize(new Dimension(width, height));
		this.p1 = new ChooseCharacter();
		this.p2 = new ChooseCharacter();
		this.bs = new BattleSystem(p1.p, p2.p);
		this.setBackground(Color.BLACK);
		this.addKeyListener(bs);
		this.addKeyListener(p1);

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

	}
}
