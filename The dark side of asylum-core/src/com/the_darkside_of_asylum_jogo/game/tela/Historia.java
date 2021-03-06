package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;


public class Historia implements Screen{
		private The_DarkSide_of_Asylum_Jogo jogo;
		private Texture fundo_escolhas;
		private Texture historia_personagem;
		private Rectangle historia;

		private Som narracao;
		
		//Construtor
		public Historia (The_DarkSide_of_Asylum_Jogo jogo) {
			this.jogo = jogo;

			this.fundo_escolhas = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/london.png"));
			this.historia_personagem = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/historia_harry.png"));

			this.historia = new Rectangle();
			this.historia.y = -1480;
			
			narracao = new Som();
			narracao.setTocando("tocar");
		}

		//Desenhar da Tela
		public void desenhar() {
			this.jogo.lote.begin();
			this.jogo.lote.draw(fundo_escolhas, 0, 0);
			this.jogo.lote.draw(historia_personagem, 20, this.historia.y);
			this.jogo.lote.end();
		}
		
		//Anima��o do texto da historia
		public void status_4() {
			if(this.historia.y < 554) {
				this.historia.y += 0.25;
			}
			else {
				this.dispose();
				this.jogo.setScreen(new JogoTela(jogo));
			}
			if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
	      		this.dispose();
	      		this.jogo.setScreen(new MenuTela(jogo));
	      		narracao.setTocando("parar");
	      		
			}
		}

		@Override
		public void show() {
			narracao.tocar("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Musica/FINALMENTE.mp3", false);
			narracao.start();
		}

		@Override
		public void render(float delta) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			this.desenhar();
			this.status_4();
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