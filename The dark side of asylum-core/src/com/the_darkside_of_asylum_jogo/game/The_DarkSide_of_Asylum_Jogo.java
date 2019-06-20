package com.the_darkside_of_asylum_jogo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.the_darkside_of_asylum_jogo.game.tela.MenuTela;

public class The_DarkSide_of_Asylum_Jogo extends Game {
	public SpriteBatch lote;
	public BitmapFont fonte;
	public static final int LARGURA_TELA = 1043;
	public static final int ALTURA_TELA = 553;
	
	@Override
	public void create() {
		this.lote = new SpriteBatch();
		this.fonte = new BitmapFont();
		this.fonte.getData().setScale(2,2);
		this.setScreen(new MenuTela(this));
	}

	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
}