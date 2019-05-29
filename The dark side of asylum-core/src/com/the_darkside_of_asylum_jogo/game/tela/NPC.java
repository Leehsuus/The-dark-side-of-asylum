package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.the_darkside_of_asylum_jogo.game.tela.JogoTela;

public class NPC extends Personagens implements Runnable{

	private float y;
	String direcao;
	float delta;

	public NPC(JogoTela tela, String caminho) {
		super(tela, caminho);
		y = Gdx.graphics.getHeight() - ALTURA_PERSONAGEM - 15; 
		setDirecao("Esquerda");
	}

	public void run() {
		while (true){
			this.setEstadoTempo(this.getEstadoTempo() + delta);
			this.andar();
			try {
				Thread.sleep((int)delta);
			}
			catch(InterruptedException e){
				
			}
		}
	}

	public void andar() {
		if(direcao == "Direita") {
			this.andarParaDireta();
			this.trocarDirecao();
		}
		else if(direcao == "Esquerda") {
			this.andarParaEsquerda();
			this.trocarDirecao();
		}
	}

	public void trocarDirecao(){
		if (this.getX() == 0.0) {
			this.direcao = "Direita";
		}
		else if (this.getX() == Gdx.graphics.getWidth() - LARGURA_PERSONAGEM) {
			this.direcao = "Esquerda";
		}
	}

	public TextureRegion getFrame(float dt) {
		estadoAtual = getStado();

		TextureRegion region;

		switch(estadoAtual) {
		case CORRENDO:
			region = rolosPersonagemAndando[rolo].getKeyFrame(estadoTempo, true);
			break;
		case PARADO:
		default:
			region = personagemParado[rolo];
			break;
		}
		estadoTempo = estadoAtual == estadoAnterior ? estadoTempo + dt : 0;
		estadoAnterior = estadoAtual;
		return region;
	}

	public Estado getStado() {
		if (x > 0 && x < Gdx.graphics.getWidth() - LARGURA_PERSONAGEM ) {
			return Estado.CORRENDO;

		}
		else {
			return Estado.PARADO;
		}
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public float getDelta() {
		return delta;
	}

	public void setDelta(float delta) {
		this.delta = delta;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
