package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;

public class Objetos {
	//bonbalsalro = 40 x 36
	
	private TextureRegion itemImagem;

	private float posX;
	private float posY;
	public static int larguraItem;
	public static int alturaItem;
	
	private Colisao colisao;
	
	private float estadoTempo;
	
	private JogoTela tela;

	public Objetos(JogoTela telaP, String caminhoP, int larguraItemPixelP, int alturaItemPixelP, int limiteAlturaTelaP) {
		this.larguraItem = larguraItemPixelP * 3;
		this.alturaItem = alturaItemPixelP * 3;
		this.posX = The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - larguraItem /2; 
		this.posY =  limiteAlturaTelaP - alturaItem;
		this.itemImagem = new TextureRegion(new Texture(caminhoP),0, 0, larguraItemPixelP, alturaItemPixelP);
		
		colisao = new Colisao(posX, posY, larguraItem, alturaItem);
	}
	
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posXP) {
		this.posX = posXP;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posYP) {
		this.posY = posYP;
	}

	public float getEstadoTempo() {
		return estadoTempo;
	}

	public void setEstadoTempo(float estadoTempoP) {
		this.estadoTempo = estadoTempoP;
	}
	
	public Colisao getColisao() {
		return colisao;
	}

	public TextureRegion getImagem() {
		return itemImagem;
	}
}
