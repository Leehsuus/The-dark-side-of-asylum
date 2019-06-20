package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



public class Objetos {
	private TextureRegion itemImagem;

	private float posX;
	private float posY;
	
	public int larguraItem;
	public int alturaItem;
	
	private Colisao colisao;
	
	private float estadoTempo;
	
	private JogoTela tela;

	//Construtor
	public Objetos(JogoTela telaP, String caminhoP, int larguraItemPixelP, int alturaItemPixelP, int limiteAlturaTelaP, int posXP) {
		this.larguraItem = larguraItemPixelP;
		this.alturaItem = alturaItemPixelP;
		this.posX = posXP; 
		this.posY =  limiteAlturaTelaP - alturaItem;
		this.itemImagem = new TextureRegion(new Texture(caminhoP),0, 0, larguraItemPixelP, alturaItemPixelP);
		
		colisao = new Colisao(posX, posY, larguraItem, alturaItem);
	}
	
	//Pegar posi��o X
	public float getPosX() {
		return posX;
	}
	
	//Passar posi��o X
	public void setPosX(float posXP) {
		this.posX = posXP;
	}

	//Pegar posi��o Y
	public float getPosY() {
		return posY;
	}

	//Passar posi��o Y
	public void setPosY(float posYP) {
		this.posY = posYP;
	}

	//Pegar Estado Tempo
	public float getEstadoTempo() {
		return estadoTempo;
	}

	//Passar Estado Tempo
	public void setEstadoTempo(float estadoTempoP) {
		this.estadoTempo = estadoTempoP;
	}

	//Pegar objeto colis�o
	public Colisao getColisao() {
		return colisao;
	}

	//Pegar Imagem
	public TextureRegion getImagem() {
		return itemImagem;
	}
}
