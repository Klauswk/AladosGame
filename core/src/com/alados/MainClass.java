package com.alados;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.entidades.PlayerCharacter;

public class MainClass extends ApplicationAdapter {

	//nome da janela
	public static final String Title = "Alados";
	//tamanho em largura
	public static final int V_WIDTH = 800;
	//tamanho em altura
	public static final int V_HEIGHT = 600;
	
	public static final int HEROICIMA = 3;

	public static final int HEROIBAIXO = 0;

	public static final int HEROIDIREITA = 2;

	public static final int HEROIESQUERDA = 1;

	private SpriteBatch batch;
	private TiledMap tilemap;
	private TiledMapRenderer tilemaprenderer;
	private OrthographicCamera camera;
	private OrthographicCamera hudcam;
	private PlayerCharacter player;
	public SpriteBatch getSpriteBatch(){return batch;}
	public OrthographicCamera getCamera(){return camera;}
	public OrthographicCamera gethudcam(){return hudcam;}
	private Texture heroi;
	@Override
	public void create () {
        
		camera = new OrthographicCamera();
        camera.setToOrtho(false,480,300);
        camera.update();
        tilemap = new TmxMapLoader().load("map1.tmx");
        tilemaprenderer = new OrthogonalTiledMapRenderer(tilemap);
		batch = new SpriteBatch();
		player = new PlayerCharacter(V_WIDTH, V_HEIGHT);
		heroi = new Texture("Gug.png");
		/*heroi = new Texture("inimigos.png");
		sprite = new Sprite[4];
		
		sprite[0] = new Sprite(heroi, 0, 0, 32, 32);
		sprite[1] = new Sprite(heroi,0,96,32,32);
		sprite[2] = new Sprite(heroi,0,64,32,32);
		sprite[3] = new Sprite(heroi,0,32,32,32);
		
		for (int i = 0; i < sprite.length; i++) {
			int posx,posy;
			posx = V_WIDTH/2;
			posy = V_HEIGHT/2;
			while(posx%16 != 0)
			{
				posx--;
			}
			while(posy%16 != 0)
			{
				posy--;
			}
			sprite[i].setPosition(posx, posy);
		}*/
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        camera.update();
        tilemaprenderer.setView(camera);
        tilemaprenderer.render();
        
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			camera.translate(-16, 0);
			PlayerCharacter.spriteatual = PlayerCharacter.HEROIESQUERDA;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			PlayerCharacter.spriteatual = HEROIDIREITA;
			camera.translate(16, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			PlayerCharacter.spriteatual = HEROICIMA;
			camera.translate(0, 16);
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			PlayerCharacter.spriteatual = HEROIBAIXO;
			camera.translate(0, -16);
		}
	
		player.render(batch);
		//sprite[PlayerCharacter.spriteatual].draw(batch);
	}

	@Override
	public void dispose() {
		//sprite[PlayerCharacter.spriteatual].getTexture().dispose();
		batch.dispose();
	}
}
