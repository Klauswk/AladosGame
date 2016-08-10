package com.entidades;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
	private TextureRegion[][] frames;
	private float time;
	private float delay;
	private int currentframe;
	
	
	public Animation(TextureRegion[][] frames)
	{
		this(frames,1/12f);
		
	}
	public Animation(TextureRegion[][] frames , float time)
	{
		setFrames(frames,time);
	}
	public void setFrames(TextureRegion[][] Frames, float delay)
	{
		this.frames = Frames;
		this.delay = delay;
		time = 0;
		currentframe = 0;
	}
	public void update(float dt)
	{
		if(delay<=0) return;
		time+=dt;
		while(time >= delay)
		{
			step();
		}
	}
	
	public void step()
	{
		time -= delay;
		currentframe++;
		if(currentframe == frames.length-1)
		{
			currentframe = 0;
		}
		
	}
	
	public TextureRegion getFrame(int FramePrincipal) {return frames[FramePrincipal][currentframe];}
}
