package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.lang.model.util.ElementScanner14;

public class ChooseCharacter implements KeyListener{

    public BufferedImage bg_ch_player1, arjuna_card, nyirorokidul_card;

    public Player p;

    private final int leftCharacter = 1;
    private final int rightCharacter = 2;
    private int selectedCharacter = 0;

    private List<ChooseKey> choosingKey;
    private GamePanel gp;

    public ChooseCharacter(GamePanel gp){
        //selectedCharacter = leftCharacter;
        this.gp = gp;
        
        this.choosingKey = new ArrayList<ChooseKey>();
        this.choosingKey.add(new ChooseKey(37));
        this.choosingKey.add(new ChooseKey(39));
        this.choosingKey.add(new ChooseKey(13));

        //setImageCHPlayer();
    }
    
    public void setPlayer1(){
    	switch(selectedCharacter) {
    	case 1:
    		this.p = new Player(leftCharacter);
    		break;
    	case 2:
    		this.p = new Player(rightCharacter);
    		break;
    	}
    }
    
    public void setPlayer2() {
    	
    }

    public Player getPlayer(){
        return p;
    }

    public void setImageCHPlayer(){
        if(gp.gameState == gp.selectCharacterPlayer1State || gp.gameState == gp.selectCharacterPlayer2State){
            getImageCHPlayer();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();
        
        if(gp.gameState == gp.selectCharacterPlayer1State || gp.gameState == gp.selectCharacterPlayer2State) {
        	//for(ChooseKey ch : this.choosingKey){
                //if(ch.isCodeMatch(key) && key == 37){
                  //  selectedCharacter = leftCharacter;
                //} else if(ch.isCodeMatch(key) && key == 39){
                  //  selectedCharacter = rightCharacter;
                //} else if(ch.isCodeMatch(key) && key == 13){
                  //  p = new Player(selectedCharacter);
                //    p.setKarakter();
              //  }
            //}
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
        			gp.gameState = gp.selectCharacterPlayer2State;
        			System.out.println("enter");
        		}else if(gp.gameState == gp.selectCharacterPlayer2State) {
        			gp.gameState = gp.battleState;
        			System.out.println("enter");
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
        // TODO Auto-generated method stub
        
    }

    public void getImageCHPlayer(){
        try {
            bg_ch_player1 = ImageIO.read(getClass().getResourceAsStream("/choose-character/choose_character_player1.png"));
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
        g2.drawImage(bg_ch_player1, 0, 0, 640, 480, null);
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