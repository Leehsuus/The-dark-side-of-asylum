package com.the_darkside_of_asylum_jogo.game.tela;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;



public class JogoTela implements Screen {

	private The_DarkSide_of_Asylum_Jogo jogo;
	//escolhas
	private Escolhas jogar;
	private Texture fundo_jogo;
	private Texture escolha_um;
	private Texture escolha_dois;
	private Texture escolha_tres;
	private Texture seta_baixo;
	private Rectangle seta;
	private boolean escolheu;
	private boolean chegou_ao_fim;
	private Texture texto_escolha;

	//interatividade
	private Texture fundoInterativo01;
	
	public static  Heroi jogador;
	private Thread threadJogador;
	public static String direcaoYJogador;
	public static String direcaoXJogador;
	private boolean teclasOpostas;

	public static NPC louco;
	private Thread threadNpc;

	public static Objetos mesa;

	private String startado;

	//maquina de estado
	public int estado;

	public JogoTela(The_DarkSide_of_Asylum_Jogo jogoP) {
		//escolhas
		this.jogo = jogoP;
		this.jogar = new Escolhas();
		this.seta_baixo = new Texture("Imagens/Menu/Seta_baixo.png");
		this.seta = new Rectangle();
		this.seta.x = 150;
		this.seta.y = 270;
		this.escolheu = true;
		this.texto_escolha = jogar.texto_aux;

		//interatividade
		this.fundoInterativo01 = new Texture("Imagens/Interativos/fundo01.png");
		
		this.jogador = new Heroi(this,"Imagens/Interativos/Investigador.png", 17,26, Gdx.graphics.getWidth(),250);
		this.threadJogador = new Thread(jogador);
		
		this.louco = new NPC(this, "Imagens/Interativos/Louco.png","Louco", 17, 26, Gdx.graphics.getWidth(),250);
		this.threadNpc = new Thread(louco);
		
		this.mesa = new Objetos(this, "Imagens/Interativos/Investigador.png", 17, 26, 250);
		
		this.setTeclasOpostas(false);
		this.setStartado("n");

		//maquina de estado
		this.setEstado(1);

	}
	
	public boolean isTeclasOpostas() {
		return teclasOpostas;
	}

	public void setTeclasOpostas(boolean teclasOpostasP) {
		this.teclasOpostas = teclasOpostasP;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estadoP) {
		this.estado = estadoP;
	}

	public String getStartado() {
		return startado;
	}

	public void setStartado(String startadoP) {
		this.startado = startadoP;
	}
	
	public void desenharEscolhas() {
		int pos_x_escolhas = 0;
		int pos_y_escolhas = 200;
		if (this.escolheu == true && this.chegou_ao_fim == false) {
			ArrayList<Texture> imagens_escolhas = new ArrayList<Texture>();
			imagens_escolhas = this.jogar.Ponto_decisao();
			this.fundo_jogo = imagens_escolhas.get(0);
			this.escolha_um = imagens_escolhas.get(1);
			this.escolha_dois = imagens_escolhas.get(2);
			this.escolha_tres = imagens_escolhas.get(3);
			this.jogo.lote.begin();
			this.jogo.lote.draw(this.fundo_jogo, pos_x_escolhas, 0);
			this.jogo.lote.draw(this.escolha_um, pos_x_escolhas + 15, pos_y_escolhas, (this.escolha_um.getWidth()/2), (this.escolha_um.getHeight()/2));
			this.jogo.lote.draw(this.escolha_dois, pos_x_escolhas + 365, pos_y_escolhas, (this.escolha_dois.getWidth()/2), (this.escolha_dois.getHeight()/2));
			this.jogo.lote.draw(this.escolha_tres, pos_x_escolhas + 730 , pos_y_escolhas, (this.escolha_tres.getWidth()/2), (this.escolha_tres.getHeight()/2));
			this.texto_escolha = this.jogar.texto_aux;
			this.jogo.lote.end();
			this.escolheu = false;
		} else if (this.escolheu == false && this.chegou_ao_fim == false) {
			this.jogo.lote.begin();
			this.jogo.lote.draw(this.fundo_jogo, pos_x_escolhas, 0);
			this.jogo.lote.draw(this.escolha_um, pos_x_escolhas + 15, pos_y_escolhas, (this.escolha_um.getWidth()/2), (this.escolha_um.getHeight()/2));
			this.jogo.lote.draw(this.escolha_dois, pos_x_escolhas + 365, pos_y_escolhas, (this.escolha_dois.getWidth()/2), (this.escolha_dois.getHeight()/2));
			this.jogo.lote.draw(this.escolha_tres, pos_x_escolhas + 730 , pos_y_escolhas, (this.escolha_tres.getWidth()/2), (this.escolha_tres.getHeight()/2));
			this.jogo.lote.draw(this.seta_baixo,this.seta.x, this.seta.y, (this.seta_baixo.getWidth()/2), (this.seta_baixo.getHeight()/2));
			this.jogo.lote.draw(this.texto_escolha, 50, 330);
			this.jogo.lote.end();
		}
	}

	public void desenharIteratividade(float deltaP) {
		this.jogo.lote.begin();
		this.jogo.lote.draw(fundoInterativo01, 0, 0, The_DarkSide_of_Asylum_Jogo.LARGURA_TELA, The_DarkSide_of_Asylum_Jogo.ALTURA_TELA);
		this.jogo.lote.draw(this.mesa.getImagem(),this. mesa.getPosX(), this.mesa.getPosY(), this.mesa.larguraItem, this.mesa.alturaItem);
		//this.jogo.lote.draw(this.jogador.getImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		this.sobrePosicao(deltaP, louco);
		this.jogo.lote.end();
	}
	
	public void sobrePosicao(float deltaP, NPC npcP) {
		if( this.jogador.getPosY() >= npcP.getPosY()) {
			this.jogo.lote.draw(this.jogador.getImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
			this.jogo.lote.draw(npcP.getImagem(deltaP), npcP.getPosX(), npcP.getPosY(), npcP.larguraPersonagem, npcP.alturaPersonagem);
		}
		else {
			this.jogo.lote.draw(npcP.getImagem(deltaP), npcP.getPosX(), npcP.getPosY(), npcP.larguraPersonagem, npcP.alturaPersonagem);
			this.jogo.lote.draw(this.jogador.getImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void escolher() {
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && (this.seta.x == 150 || this.seta.x == 515)) {
			this.seta.x += 365;
		}
		if (Gdx.input.isKeyJustPressed(Keys.LEFT) && (this.seta.x == 515 || this.seta.x == 880)) {
			this.seta.x -= 365;
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.x == 150) {
			if (this.chegou_ao_fim) {
				this.setEstado(1);
			}
			else{
				this.setEstado(2);
			}

			if (this.getStartado() == "n") {
				this.threadNpc.start();
				this.threadJogador.start();
				this.setStartado("s");;
			}
			else if (this.getStartado() == "s") {
				this.threadNpc.resume();
			}
			this.jogar.Mostrar_opcoes(1);
			this.chegou_ao_fim = this.jogar.Consultar_texto();
			this.escolheu = true;
		}
		else if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.x == 515) {
			if (this.chegou_ao_fim) {
				this.setEstado(1);
			}
			else{
				this.setEstado(2);
			}

			if (this.getStartado() == "n") {
				this.threadJogador.start();
				this.threadNpc.start();
				this.setStartado("s");
			}
			else if (this.getStartado() == "s") {
				this.threadNpc.resume();
			}
			this.jogar.Mostrar_opcoes(2);
			this.chegou_ao_fim = jogar.Consultar_texto();
			this.escolheu = true;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.x == 880) {
			if (this.chegou_ao_fim) {
				this.setEstado(1);
			}
			else{
				this.setEstado(2);
			}
			if (this.getStartado() == "n") {
				this.threadJogador.start();
				this.threadNpc.start();
				this.setStartado("s");
			}
			else if (this.getStartado() == "s") {
				this.threadNpc.resume();
			}
			this.jogar.Mostrar_opcoes(3);
			this.chegou_ao_fim = this.jogar.Consultar_texto();			
			this.escolheu = true;
		}
	}

	public void capturarMovimentosHeroi() {
		if(Gdx.input.isKeyPressed(Keys.DOWN) && !this.isTeclasOpostas())  {
			this.direcaoYJogador = "Baixo";
		}else if(Gdx.input.isKeyPressed(Keys.UP) && !this.isTeclasOpostas()) {
			this.direcaoYJogador = "Cima";
		}else {
			this.direcaoYJogador ="";
		}

		if(Gdx.input.isKeyPressed(Keys.LEFT) && !this.isTeclasOpostas()) {
			this.direcaoXJogador = "Esquerda";
		}
		else  if(Gdx.input.isKeyPressed(Keys.RIGHT) && !this.isTeclasOpostas()) {
			this.direcaoXJogador = "Direita";
		}
		else {
			this.direcaoXJogador ="";
		}

		if ((Gdx.input.isKeyPressed(Keys.LEFT) && Gdx.input.isKeyPressed(Keys.RIGHT)) || Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.DOWN)){
			this.setTeclasOpostas(true);
		}
		else {
			this.setTeclasOpostas(false);
		}

		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			this.setEstado(1);
			this.threadNpc.suspend();
		}

	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		if (this.getEstado() == 1) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			this.desenharEscolhas();
			if (this.escolheu == false) {
				this.escolher();
			}
		}
		else {
			this.capturarMovimentosHeroi();
			this.louco.setDelta(delta);
			this.jogador.setDelta(delta);
			//this.jogador.colidiu(louco.getColisao());
			
			this.desenharIteratividade(delta);
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
		this.jogo.lote.dispose();
		this.jogo.fonte.dispose();
	}

}
