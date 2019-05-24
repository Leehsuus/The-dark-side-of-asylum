package com.the_darkside_of_asylum_jogo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.the_darkside_of_asylum_jogo.game.tela.MenuTela;

public class The_DarkSide_of_Asylum_Jogo extends Game {
	public SpriteBatch lote;
	public BitmapFont fonte;
	
	@Override
	public void create () {
		lote = new SpriteBatch();
		fonte = new BitmapFont();
		fonte.getData().setScale(2,2);
		setScreen(new MenuTela(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
