package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;


public class ChooseCharacter implements KeyListener{

    public BufferedImage bg_ch_player1, bg_ch_player2, arjuna_card, nyirorokidul_card;

    public Player p1, p2;

    private final int leftCharacter = 1;
    private final int rightCharacter = 2;
    private int selectedCharacter = 0;

    private GamePanel gp;

    public ChooseCharacter(GamePanel gp){
        //selectedCharacter = leftCharacter;
        this.gp = gp;

        //setImageCHPlayer();
    }
    
    public void setPlayer1(){
    	switch(selectedCharacter) {
    	case 1:
    		this.p1 = new Player(leftCharacter);
    		break;
    	case 2:
    		this.p1 = new Player(rightCharacter);
    		break;
    	}
    }
    
    public void setPlayer2() {
        switch(selectedCharacter) {
            case 1:
                this.p2 = new Player(leftCharacter);
                break;
            case 2:
                this.p2 = new Player(rightCharacter);
                break;
            }
    }

    public Player getPlayer1(){
        return p1;
    }

    public Player getPlayer2(){
        return p2;
    }

    public void setImageCHPlayer(){
        if(gp.gameState == gp.selectCharacterPlayer1State || gp.gameState == gp.selectCharacterPlayer2State){
            getImageCHPlayer();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(gp.gameState == gp.selectCharacterPlayer1State || gp.gameState == gp.selectCharacterPlayer2State) {
        	if(key == e.VK_RIGHT) {
        		this.selectedCharacter = rightCharacter;
        		System.out.println("right");
        	}
        	else if(key == e.VK_LEFT) {
        		this.selectedCharacter = leftCharacter;
        		System.out.println("left");
        	}
        	else if(key == e.VK_SPACE) {
        		if(gp.gameState == gp.selectCharacterPlayer1State) {
                    setPlayer1();
        			gp.gameState = gp.selectCharacterPlayer2State;
        			System.out.println("player 1 udah pilih character");
        		}else if(gp.gameState == gp.selectCharacterPlayer2State) {
                    setPlayer2();
        			gp.gameState = gp.battleState;
        			System.out.println("player 2 udah pilih character");
        		}
        		//System.out.println("enter");
        	}
        	else if(key == e.VK_ESCAPE) {
        		gp.gameState = gp.mainMenuState;
        		System.out.println("back");
        	}
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void getImageCHPlayer(){
        try {
            bg_ch_player1 = ImageIO.read(getClass().getResourceAsStream("/choose-character/choose_character_player1.png"));
            bg_ch_player2 = ImageIO.read(getClass().getResourceAsStream("/choose-character/choose_character_player2.png"));
            arjuna_card = ImageIO.read(getClass().getResourceAsStream("/choose-character/arjuna_character_card.png"));
            nyirorokidul_card = ImageIO.read(getClass().getResourceAsStream("/choose-character/nyirorokidul_character_card.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void update() {
    	setImageCHPlayer();
    }

    public void draw(Graphics2D g2){
        if(gp.gameState == gp.selectCharacterPlayer1State ){
            g2.drawImage(bg_ch_player1, 0, 0, 640, 480, null);
        } else if(gp.gameState == gp.selectCharacterPlayer2State){
            g2.drawImage(bg_ch_player2, 0, 0, 640, 480, null);
        }
        
        g2.drawImage(arjuna_card, 100, 140, 180, 255, null);
        g2.drawImage(nyirorokidul_card, 400, 140, 180, 255, null);
        
        if(selectedCharacter == leftCharacter) {
        	g2.setColor(Color.BLACK);
        	g2.drawRect(95, 135, 190, 265);
        }
        if(selectedCharacter == rightCharacter) {
        	g2.setColor(Color.BLACK);
        	g2.drawRect(395, 135, 190, 265);
        }
        
    }

}