package com.the_darkside_of_asylum_jogo.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1043;
		config.height = 553;
		new LwjglApplication(new The_DarkSide_of_Asylum_Jogo(), config);
				
	}
}
