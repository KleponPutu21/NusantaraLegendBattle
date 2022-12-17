package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenu implements KeyListener {

    public BufferedImage bg_mainmenu, exit_button, play_button;

    GamePanel gp;

    private final int playButton = 1;
    private final int exitButton = 2;
    private int selectedButton;

    private List<MainMenuKey> selectingKey;

    public MainMenu(GamePanel gp){
        selectedButton = playButton;
        this.gp = gp;

        this.selectingKey = new ArrayList<MainMenuKey>();
        this.selectingKey.add(new MainMenuKey(38));
        this.selectingKey.add(new MainMenuKey(40));
        this.selectingKey.add(new MainMenuKey(13));

        setImageMainMenu();
    }

    public void setImageMainMenu(){
        if(gp.gameState == gp.mainMenuState){
            getImageMainMenu();
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

        if(gp.gameState == gp.mainMenuState) {
            for(MainMenuKey mk : this.selectingKey){
                if(mk.isCodeMatch(key) && key == 38){
                    selectedButton = playButton;
                } else if(mk.isCodeMatch(key) && key == 40){
                    selectedButton = exitButton;
                } else if(mk.isCodeMatch(key) && key == 13){
                    if(selectedButton == playButton){
                        gp.gameState = gp.selectCharacterPlayer1State;
                    } else if(selectedButton == exitButton){
                        System.exit(0);   
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void getImageMainMenu(){
        try {
            bg_mainmenu = ImageIO.read(getClass().getResourceAsStream("/mainmenu/main_menu_background.png"));
            exit_button = ImageIO.read(getClass().getResourceAsStream("/mainmenu/exit_button.png"));
            play_button = ImageIO.read(getClass().getResourceAsStream("/mainmenu/play_button.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        
        g2.drawImage(bg_mainmenu, 0, 0, 640, 480, null);
        g2.drawImage(play_button, 300, 200, 45, 45, null);
        g2.drawImage(exit_button, 300, 270, 45, 45, null);
    }
 
}
