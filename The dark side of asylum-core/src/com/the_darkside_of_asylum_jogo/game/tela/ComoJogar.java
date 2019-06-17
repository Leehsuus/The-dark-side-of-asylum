package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;

public class ComoJogar implements Screen{

	private The_DarkSide_of_Asylum_Jogo jogo;

	private Texture como_jogar;

	public ComoJogar (The_DarkSide_of_Asylum_Jogo jogo) {
		
		this.jogo = jogo;

		this.como_jogar = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/como jogar.png"));
	}


	public void desenhar() {
		this.jogo.lote.begin();
		this.jogo.lote.draw(como_jogar, 0, 0);
		this.jogo.lote.end();
	}

	public void eventos() {
		this.voltar();
	}

	public void voltar() {
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
      this.dispose();
			this.jogo.setScreen(new MenuTela(jogo));
		}
	}


	@Override
	public void show() {


	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		desenhar();
		eventos();


	}

	@Override
	public void resize(int width, int height) {


	}

	@Override
	public void pause() {


	}

	@Override
	public void resume() {


	}

	@Override
	public void hide() {


	}

	@Override
	public void dispose() {


	}
}
