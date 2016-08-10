package com.alados.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.alados.MainClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = MainClass.Title;
		config.height = MainClass.V_HEIGHT;
		config.width = MainClass.V_WIDTH;
		config.foregroundFPS = 15;
		new LwjglApplication(new MainClass(), config);
	}
}
