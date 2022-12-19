package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;

public class EndGame implements KeyListener{
    public BufferedImage bg_endgame;

    private GamePanel gp;

    public EndGame(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(gp.gameState == gp.endGameState){
            if(key == e.VK_ENTER) {
                gp.gameState = gp.selectCharacterPlayer1State;
            } else if(key == e.VK_SPACE) {
                gp.gameState = gp.mainMenuState;
            } else if(key == e.VK_ESCAPE) {
                System.exit(0);
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void setImageEndGame(){
        if(gp.gameState == gp.endGameState){
            getImageEndGame();
        }
    }
    public void getImageEndGame(){
        try {
            bg_endgame = ImageIO.read(getClass().getResourceAsStream("/end-game/endgame_background.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        setImageEndGame();
    }
    public void draw(Graphics2D g2){
        if(gp.gameState == gp.endGameState){
            g2.drawImage(bg_endgame, 0, 0, 640, 480, null);
        }
    }
}
