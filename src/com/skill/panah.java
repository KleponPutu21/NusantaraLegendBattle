package com.skill;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class panah extends DynamicSkill{

BufferedImage panahP1, panahP2;
	
	protected int visiblePanah;
	protected final int visible = 64;
	protected final int invisible = 0;

	public panah(int playerPos) {
		super(playerPos);
		this.visiblePanah = invisible;
		setImagePanah();
	}
	
	public void setImagePanah() {
		getImagePanah();
	}
	
	public void getImagePanah() {
		try {
			panahP1 = ImageIO.read(getClass().getResourceAsStream("/attack-cut/arjuna/arrow_p1_cut.png"));
			panahP2 = ImageIO.read(getClass().getResourceAsStream("/attack-cut/arjuna/arrow_p2_cut.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setVisile() {
		this.visiblePanah = 1;
	}
	
	public void setInvisible() {
		this.visiblePanah = 0;
	}
	
	public void update() {
		if(this.playerPosistion == P1_LEFT) {
			this.x += this.speedX;
		}else if(this.playerPosistion == P2_RIGHT) {
			this.x -= this.speedX;
		}
		
		setImagePanah();
	}
	

	@Override
	public void draw(Graphics2D g2) {
		if(this.playerPosistion == this.P1_LEFT) {
			g2.drawImage(panahP1, this.x, this.y, 64, 64, null);
			System.out.println(this.x + " " + this.y);
		}else if(this.playerPosistion == this.P2_RIGHT) {
			g2.drawImage(panahP2, this.x, this.y, 64, 64, null);
			System.out.println(this.x + " " + this.y);
		}
		
	}
}
