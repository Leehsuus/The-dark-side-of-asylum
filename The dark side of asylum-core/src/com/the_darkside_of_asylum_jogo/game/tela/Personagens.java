package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;
import com.the_darkside_of_asylum_jogo.game.tela.JogoTela;

public class Personagens {
	public enum Estado {PARADO, CORRENDO}
	public Estado estadoAtual;
	public Estado estadoAnterior;

	public static final float VELOCIDADE = 300;
	public static final float VELOCIDADE_ANIMACAO_PERSONAGEM = 0.2f;

	public static final int LARGURA_PERSONAGEM_PIXEL = 40;
	public static final int ALTURA_PERSONAGEM_PIXEL = 36;

	public static final int LARGURA_PERSONAGEM = LARGURA_PERSONAGEM_PIXEL * 2;
	public static final int ALTURA_PERSONAGEM = ALTURA_PERSONAGEM_PIXEL * 2;

	Animation<TextureRegion>[] rolosPersonagemAndando;
	TextureRegion[] personagemParado;

	float x;
	int rolo;
	float estadoTempo;
	JogoTela tela;

	public Personagens(JogoTela tela, String caminho) {
		this.tela = tela;
		x = The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - LARGURA_PERSONAGEM /2; 

		rolo = 0;
		rolosPersonagemAndando = new Animation[4];
		personagemParado = new TextureRegion[4];

		TextureRegion[][] roloSpriteSheet = TextureRegion.split(new Texture(caminho), LARGURA_PERSONAGEM_PIXEL, ALTURA_PERSONAGEM_PIXEL);

		rolosPersonagemAndando[0] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[0]);
		rolosPersonagemAndando[1] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[1]);
		rolosPersonagemAndando[2] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[2]);
		rolosPersonagemAndando[3] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[3]);

		personagemParado[0] = new TextureRegion(new Texture(caminho), LARGURA_PERSONAGEM_PIXEL * 2, 0, LARGURA_PERSONAGEM_PIXEL, ALTURA_PERSONAGEM_PIXEL);
		personagemParado[1] = new TextureRegion(new Texture(caminho), LARGURA_PERSONAGEM_PIXEL * 2, ALTURA_PERSONAGEM_PIXEL, LARGURA_PERSONAGEM_PIXEL, ALTURA_PERSONAGEM_PIXEL);
		personagemParado[2] = new TextureRegion(new Texture(caminho), LARGURA_PERSONAGEM_PIXEL * 2, ALTURA_PERSONAGEM_PIXEL * 2, LARGURA_PERSONAGEM_PIXEL, ALTURA_PERSONAGEM_PIXEL);
		personagemParado[3] = new TextureRegion(new Texture(caminho), LARGURA_PERSONAGEM_PIXEL * 2, ALTURA_PERSONAGEM_PIXEL * 3, LARGURA_PERSONAGEM_PIXEL, ALTURA_PERSONAGEM_PIXEL);
	}


	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}


	public int getRolo() {
		return rolo;
	}

	public void setRolo(int rolo) {
		this.rolo = rolo;
	}

	public float getEstadoTempo() {
		return estadoTempo;
	}

	public void setEstadoTempo(float estadoTempo) {
		this.estadoTempo = estadoTempo;
	}

	public void andarParaEsquerda() {
		if( this.getX() > 0) {
			this.setX(this.getX() - this.VELOCIDADE * Gdx.graphics.getDeltaTime());
		}
		else if(this.getX() <= 0){
			this.setX(0);
		}
		this.setRolo(1);
	}

	public void andarParaDireta() {
		if(this.getX() + 100 < The_DarkSide_of_Asylum_Jogo.LARGURA_TELA ) {
			this.setX(this.getX() + this.VELOCIDADE * Gdx.graphics.getDeltaTime());
		}
		else if(this.getX() + 100 >= The_DarkSide_of_Asylum_Jogo.LARGURA_TELA ){
			this.setX(Gdx.graphics.getWidth() - LARGURA_PERSONAGEM);
		}
		this.setRolo(2);
	}

}
