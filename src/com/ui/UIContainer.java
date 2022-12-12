package com.ui;

import java.awt.*;
public abstract class UIContainer extends UIComponent{
    protected Color backgroundColor;
    protected Image sprite;

    public UIContainer() {
        super();
        backgroundColor = new Color(0, 0, 0, 0);
    }

    public Image getSprite() {
        return sprite;
    }

    protected void generateSprite(){
        Graphics2D graphics = (Graphics2D) sprite.getGraphics();
        
        graphics.setColor(backgroundColor);
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
    }
}
