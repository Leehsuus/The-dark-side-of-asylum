package com.the_darkside_of_asylum_jogo.game.tela;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;
import com.the_darkside_of_asylum_jogo.game.tela.Escolhas;

public class JogoTela implements Screen {
	//Escolhas
	private The_DarkSide_of_Asylum_Jogo jogo;
	Escolhas jogar;
	Texture fundo_jogo;
	Texture escolha_um;
	Texture escolha_dois;
	Texture escolha_tres;
	Texture seta_baixo;
	Rectangle seta;
	boolean escolheu;
	boolean chegou_ao_fim;
	Texture texto_escolha;

	//Interatividade
	Heroi jogador;
	boolean teclasOpostas = false;
	NPC npc1;
	Thread thread1;

	//Maquina de estado
	public int estado;

	public JogoTela(The_DarkSide_of_Asylum_Jogo jogo) {
		this.jogo = jogo;
		jogar = new Escolhas();
		seta_baixo = new Texture("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core"
				+ "/assets/Imagens/Menu/Seta_baixo.png");
		seta = new Rectangle();
		seta.x = 150;
		seta.y = 270;
		escolheu = true;
		texto_escolha = jogar.texto_aux;

		//Interatividade
		jogador = new Heroi(this,"/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Personagens/poke.png");
		npc1 = new NPC(this,"/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Personagens/poke.png");
		thread1 = new Thread(npc1);

		//Maquina de estado
		estado = 1;
	}

	public void desenhar() {
		int pos_x_escolhas = 0;
		int pos_y_escolhas = 200;
		if (escolheu == true) {
			ArrayList<Texture> imagens_escolhas = new ArrayList<Texture>();
			imagens_escolhas = jogar.Ponto_decisao();
			fundo_jogo = imagens_escolhas.get(0);
			escolha_um = imagens_escolhas.get(1);
			escolha_dois = imagens_escolhas.get(2);
			escolha_tres = imagens_escolhas.get(3);
			jogo.lote.begin();
			jogo.lote.draw(fundo_jogo, pos_x_escolhas, 0);
			jogo.lote.draw(escolha_um, pos_x_escolhas + 15, pos_y_escolhas, (escolha_um.getWidth()/2), (escolha_um.getHeight()/2));
			jogo.lote.draw(escolha_dois, pos_x_escolhas + 365, pos_y_escolhas, (escolha_dois.getWidth()/2), (escolha_dois.getHeight()/2));
			jogo.lote.draw(escolha_tres, pos_x_escolhas + 730 , pos_y_escolhas, (escolha_tres.getWidth()/2), (escolha_tres.getHeight()/2));
			texto_escolha = jogar.texto_aux;
			jogo.lote.end();
			escolheu = false;
		} else if (escolheu == false) {
			jogo.lote.begin();
			jogo.lote.draw(fundo_jogo, pos_x_escolhas, 0);
			jogo.lote.draw(escolha_um, pos_x_escolhas + 15, pos_y_escolhas, (escolha_um.getWidth()/2), (escolha_um.getHeight()/2));
			jogo.lote.draw(escolha_dois, pos_x_escolhas + 365, pos_y_escolhas, (escolha_dois.getWidth()/2), (escolha_dois.getHeight()/2));
			jogo.lote.draw(escolha_tres, pos_x_escolhas + 730 , pos_y_escolhas, (escolha_tres.getWidth()/2), (escolha_tres.getHeight()/2));
			jogo.lote.draw(seta_baixo, seta.x, seta.y, (seta_baixo.getWidth()/2), (seta_baixo.getHeight()/2));
			jogo.lote.draw(texto_escolha, 50, 330);
			jogo.lote.end();
		}
	}

	public void escolher() {
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && (seta.x == 150 || seta.x == 515)) {
			seta.x += 365;
		}
		if (Gdx.input.isKeyJustPressed(Keys.LEFT) && (seta.x == 515 || seta.x == 880)) {
			seta.x -= 365;
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && seta.x == 150) {
			estado = 2;
			thread1.start();
			jogar.Mostrar_opcoes(1);
			chegou_ao_fim = jogar.Consultar_texto();
			escolheu = true;
		}
		else if (Gdx.input.isKeyJustPressed(Keys.ENTER) && seta.x == 515) {
			estado = 2;
			thread1.start();
			jogar.Mostrar_opcoes(2);
			chegou_ao_fim = jogar.Consultar_texto();
			escolheu = true;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.ENTER) && seta.x == 880) {
			estado = 2;
			thread1.start();
			jogar.Mostrar_opcoes(3);
			chegou_ao_fim = jogar.Consultar_texto();			
			escolheu = true;
		}
	}

	@SuppressWarnings("deprecation")
	public void movimentosPersonagem() {
		if(Gdx.input.isKeyPressed(Keys.DOWN) && !teclasOpostas)  {
			jogador.andarParaBaixo();
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT) && !teclasOpostas) {
			jogador.andarParaEsquerda();
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT) && !teclasOpostas) {
			jogador.andarParaDireta();
		}
		if(Gdx.input.isKeyPressed(Keys.UP) && !teclasOpostas) {
			jogador.andarParaCima();
		}

		if ((Gdx.input.isKeyPressed(Keys.LEFT) && Gdx.input.isKeyPressed(Keys.RIGHT)) || Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.DOWN)){
			teclasOpostas = true;
		}
		else {
			teclasOpostas = false;
		}

		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			estado = 1;
			thread1.stop();
		}

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		if (estado == 1) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			desenhar();
			if (escolheu == false) {
				escolher();
			}
		}
		else {
			movimentosPersonagem();
			npc1.setDelta(delta);
			jogador.setEstadoTempo(jogador.getEstadoTempo() + delta);

			Gdx.gl.glClearColor(0.2f, 0.5f, 0.2f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			jogo.lote.begin();
			jogo.lote.draw(jogador.getFrame(delta), jogador.getX(), jogador.getY(), jogador.LARGURA_PERSONAGEM, jogador.ALTURA_PERSONAGEM);
			jogo.lote.draw(npc1.getFrame(delta), npc1.getX(), npc1.getY(), npc1.LARGURA_PERSONAGEM, npc1.ALTURA_PERSONAGEM);
			jogo.lote.end();
		}

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
		jogo.lote.dispose();
		jogo.fonte.dispose();

	}

}
