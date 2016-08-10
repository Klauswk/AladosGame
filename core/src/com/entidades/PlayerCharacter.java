package com.entidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class PlayerCharacter{

	public static final int HEROICIMA = 3;

	public static final int HEROIBAIXO = 0;

	public static final int HEROIDIREITA = 2;

	public static final int HEROIESQUERDA = 1;
	
	private Texture heroi;
	public static int spriteatual = 0;
	private Animation animation;
	private int widht , height;
	private int posx,posy;
	private Body body;
	
	public PlayerCharacter(int width,int height)
	{
		this.widht = width;
		this.height = height;
		heroi = new Texture("inimigos.png");
		
		TextureRegion[][] sprites = TextureRegion.split(heroi, 32, 32);
			posx = widht/2;
			posy = height/2;
			while(posx%16 != 0)
			{
				posx--;
			}
			while(posy%16 != 0)
			{
				posy--;
			}
		animation = new Animation(sprites,1/12f);
	}
	
	public void update(float dt)
	{
		animation.update(dt);
	}
	public void render(SpriteBatch sb)
	{
		update(1/20f);
		sb.begin();
		sb.draw(animation.getFrame(spriteatual), posx, posy);
		sb.end();
	}
}
