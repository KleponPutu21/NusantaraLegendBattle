package com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	public int setPlayerState;
	public final int notSettled = 0;
	public final int done = 1;

	private BattleSystem bs;
	private ChooseCharacter Character;
	private Player player1, player2;
	private MainMenu menuPanel;

	public GamePanel(int width, int height) {
		
		this.setPreferredSize(new Dimension(width, height));
		this.Character = new ChooseCharacter(this);
		this.menuPanel = new MainMenu(this);
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(menuPanel);
		this.addKeyListener(bs);
		this.addKeyListener(Character);

		this.setFocusable(true);
		this.setPlayerState = notSettled;
	}
	
	public void setupGame() {
				
		gameState = mainMenuState;
	}
	
	public void setPlayer(){
		this.player1 = this.Character.getPlayer1();
		this.player2 = this.Character.getPlayer2();
		System.out.println("udah pilih character");
	}
	
	public void setBattleSystem() {
		this.bs = new BattleSystem(player1, player2, this);
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
		if(this.gameState == mainMenuState) {
			menuPanel.update();
		}
		if(this.gameState == selectCharacterPlayer1State) {
			Character.update();
		}
		if(this.gameState == selectCharacterPlayer2State) {
			Character.update();
		}
		if(this.gameState == battleState) {
			if(this.setPlayerState == notSettled){
				setPlayer();
				setBattleSystem();
				this.setPlayerState = done;
			}
			bs.update();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		if(this.gameState == mainMenuState) {
			menuPanel.draw(g2);
		}
		if(this.gameState == selectCharacterPlayer1State) {
			Character.draw(g2);
		}
		if(this.gameState == selectCharacterPlayer2State) {
			Character.draw(g2);
		}
		if(this.gameState == battleState) {
			bs.draw(g2);
		}
		
	}
}
