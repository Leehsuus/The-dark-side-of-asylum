package com.the_darkside_of_asylum_jogo.game.tela;


public class Colisao {

	private float posXColisao, posYColisao;
	private int larguraColisao, alturaColisao;
	
	//Construtor
	public Colisao(float posXP, float posYP, int larguraColisaoP, int alturaColisaoP) {
		this.posXColisao = posXP+5;
		this.posYColisao = posYP;
		this.larguraColisao = larguraColisaoP-10;
		this.alturaColisao = alturaColisaoP/2;
	}
	
	//Fazer a movimenta��o do objeto de colis�o
	public void mover(float x, float y) {
		this.posXColisao = x;
		this.posYColisao = y;
	}
	
	//Pegar posi��o X do objeto colis�o
	public float getPosXColisao() {
		return posXColisao;
	}

	//Passar posi��o X do objeto colis�o
	public void setPosXColisao(float posXColisao) {
		this.posXColisao = posXColisao;
	}

	//Pegar posi��o Y do objeto colis�o
	public float getPosYColisao() {
		return posYColisao;
	}

	//Passar posi��o Y do objeto colis�o
	public void setPosYColisao(float posYColisao) {
		this.posYColisao = posYColisao;
	}

	//Pegar largura do objeto colis�o
	public int getLarguraColisao() {
		return larguraColisao;
	}

	//Passar largura do objeto colis�o
	public void setLarguraColisao(int larguraColisao) {
		this.larguraColisao = larguraColisao;
	}

	//Pegar altura do objeto colis�o
	public int getAlturaColisao() {
		return alturaColisao;
	}

	//Passar altura do objeto colis�o
	public void setAlturaColisao(int alturaColisao) {
		this.alturaColisao = alturaColisao;
	}
	
	//Verifica��o de colis�o de dois objetos
	public boolean colideCom(Colisao retangulo) {
		return this.posXColisao < retangulo.posXColisao + retangulo.larguraColisao && this.posYColisao < retangulo.posYColisao + retangulo.alturaColisao && this.posXColisao + this.larguraColisao > retangulo.posXColisao && this.posYColisao + this.alturaColisao > retangulo.posYColisao;
	}
	
	//Verifica��o de colis�o do lado direito
	public boolean colideDireitoCom(Colisao retangulo) {
		return this.posXColisao + this.larguraColisao < retangulo.posXColisao + 15 && this.posXColisao + this.larguraColisao > retangulo.posXColisao;
	}
	
	//Verifica��o de colis�o do lado esquerdo
	public boolean colideEsquerdoCom(Colisao retangulo) {
		return posXColisao > retangulo.posXColisao + retangulo.larguraColisao - 15 && posXColisao  < retangulo.posXColisao + retangulo.larguraColisao;
	}
	
	//Verifica��o de colis�o da parte de cima
	public boolean colideCimaCom(Colisao retangulo) {
		return posYColisao + alturaColisao < retangulo.posYColisao +  15 && posYColisao + alturaColisao > retangulo.posYColisao;
	}

	//Verifica��o de colis�o da parte de baixo
	public boolean colideBaixoCom(Colisao retangulo) {
		return posYColisao > retangulo.posYColisao + retangulo.alturaColisao - 15 && posYColisao < retangulo.posYColisao + retangulo.alturaColisao;
	}
}
