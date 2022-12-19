package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenu implements KeyListener {

    public BufferedImage bg_mainmenu, exit_button, play_button;

    GamePanel gp;

    private final int playButton = 1;
    private final int exitButton = 2;
    private int selectedButton;
    private int buttonState;

    public MainMenu(GamePanel gp){
        this.gp = gp;
    
        setDefaultMainMenu();
        setImageMainMenu();
    }
    
    public void setDefaultMainMenu() {
    	this.buttonState = playButton;
    }

    public void setImageMainMenu(){
        if(gp.gameState == gp.mainMenuState){
            getImageMainMenu();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(gp.gameState == gp.mainMenuState) {
        	if(key == e.VK_UP) {
        		selectedButton = playButton;
        		System.out.println("up pressed");
        	} else if(key == e.VK_DOWN) {
        		selectedButton = exitButton;
        		System.out.println("down pressed");
        	} else if(key == e.VK_ENTER) {
        		if(selectedButton == playButton) {
        			gp.gameState = gp.selectCharacterPlayer1State;
        			System.out.println("enter from menu");
        		}else if(selectedButton == exitButton) {
        			System.exit(0);
        		}
        	}
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void getImageMainMenu(){
        try {
            bg_mainmenu = ImageIO.read(getClass().getResourceAsStream("/main-menu/main_menu_background.png"));
            exit_button = ImageIO.read(getClass().getResourceAsStream("/main-menu/exit_button.png"));
            play_button = ImageIO.read(getClass().getResourceAsStream("/main-menu/play_button.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void update() {
    	this.buttonState = selectedButton;
    }

    // public void update(){
    //     if()
    // }

    public void draw(Graphics2D g2){
        
        g2.drawImage(bg_mainmenu, 0, 0, 640, 480, null);
        
        if(this.buttonState == playButton) {
        	g2.drawImage(play_button, 300, 200, 50, 50, null);
        	g2.drawImage(exit_button, 300, 270, 45, 45, null);
        }else if(this.buttonState == exitButton) {
        	g2.drawImage(play_button, 300, 200, 45, 45, null);
        	g2.drawImage(exit_button, 300, 270, 50, 50, null);
        }else {
        	g2.drawImage(play_button, 300, 200, 50, 50, null);
        	g2.drawImage(exit_button, 300, 270, 45, 45, null);
        }
    }
 
}
