package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;

public class Colisao {
	private float posXColisao, posYColisao;
	private int larguraColisao, alturaColisao;
	
	public Colisao(float posXP, float posYP, int larguraColisaoP, int alturaColisaoP) {
		this.posXColisao = posXP+5;
		this.posYColisao = posYP;
		this.larguraColisao = larguraColisaoP-10;
		this.alturaColisao = alturaColisaoP/2;
	}
	
	
	public void mover(float x, float y) {
		this.posXColisao = x;
		this.posYColisao = y;
	}
	
	public float getPosXColisao() {
		return posXColisao;
	}


	public void setPosXColisao(float posXColisao) {
		this.posXColisao = posXColisao;
	}


	public float getPosYColisao() {
		return posYColisao;
	}


	public void setPosYColisao(float posYColisao) {
		this.posYColisao = posYColisao;
	}


	public int getLarguraColisao() {
		return larguraColisao;
	}


	public void setLarguraColisao(int larguraColisao) {
		this.larguraColisao = larguraColisao;
	}


	public int getAlturaColisao() {
		return alturaColisao;
	}


	public void setAlturaColisao(int alturaColisao) {
		this.alturaColisao = alturaColisao;
	}
	
	public boolean colideCom(Colisao retangulo) {
		return this.posXColisao < retangulo.posXColisao + retangulo.larguraColisao && this.posYColisao < retangulo.posYColisao + retangulo.alturaColisao && this.posXColisao + this.larguraColisao > retangulo.posXColisao && this.posYColisao + this.alturaColisao > retangulo.posYColisao;

	}
	
	public boolean colideDireitoCom(Colisao retangulo) {
		return this.posXColisao + this.larguraColisao < retangulo.posXColisao + 15 && this.posXColisao + this.larguraColisao > retangulo.posXColisao;
	}
	
	public boolean colideEsquerdoCom(Colisao retangulo) {
		return posXColisao > retangulo.posXColisao + retangulo.larguraColisao - 15 && posXColisao  < retangulo.posXColisao + retangulo.larguraColisao;
	}
	
	public boolean colideCimaCom(Colisao retangulo) {
		return posYColisao + alturaColisao < retangulo.posYColisao +  15 && posYColisao + alturaColisao > retangulo.posYColisao;
	}
	
	public boolean colideBaixoCom(Colisao retangulo) {
		return posYColisao > retangulo.posYColisao + retangulo.alturaColisao - 15 && posYColisao < retangulo.posYColisao + retangulo.alturaColisao;
	}
}
