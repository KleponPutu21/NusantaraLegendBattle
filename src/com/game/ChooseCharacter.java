package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner14;

public class ChooseCharacter implements KeyListener{
    public Player p;

    private final int leftCharacter = 1;
    private final int rightCharacter = 2;
    private int selectedCharcter;

    private List<ChooseKey> choosingKey;

    public ChooseCharacter(){
        selectedCharcter = leftCharacter;
        this.choosingKey = new ArrayList<ChooseKey>();
    }

    public Player getPlayer(){
        return p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();

        for(ChooseKey ch : this.choosingKey){
            if(ch.isCodeMatch(key) && key == 37){
                selectedCharcter = leftCharacter;
            } else if(ch.isCodeMatch(key) && key == 39){
                selectedCharcter = rightCharacter;
            } else if(ch.isCodeMatch(key) && key == 13){
                p = new Player(selectedCharcter);
                p.setKarakter();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    

}