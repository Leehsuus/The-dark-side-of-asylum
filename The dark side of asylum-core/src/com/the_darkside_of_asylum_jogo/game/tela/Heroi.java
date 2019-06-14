package com.the_darkside_of_asylum_jogo.game.tela;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureRegion;




public class Heroi extends Personagens implements Runnable{
	
	private float delta;

	public Heroi(JogoTela telaP, String caminhoP, int larguraPersonagemPixelP,int  alturaPersonagemPixelP, int limiteLarguraTelaP,int limiteAlturaTelaP){
		super(telaP, caminhoP, 15, larguraPersonagemPixelP, alturaPersonagemPixelP, limiteLarguraTelaP, limiteAlturaTelaP); 
	}

	public void run() {
		while(true) {
			this.setEstadoTempo(this.getEstadoTempo() + this.getDelta());
			try {
				Thread.sleep(15);
			}
			catch(InterruptedException e){

			}
			if(JogoTela.direcaoXJogador == "Esquerda") {
				this.andarParaEsquerda();
			}
			else if(JogoTela.direcaoXJogador == "Direita") {
				this.andarParaDireita();
			}
			if(JogoTela.direcaoYJogador == "Cima") {
				this.andarParaCima();				
			}
			else if(JogoTela.direcaoYJogador == "Baixo") {
				this.andarParaBaixo();
			}
			
			//this.colidiu(JogoTela.mesa.getColisao());
			this.colidiu(JogoTela.louco.getColisao());
			colisao.mover(this.getPosX(), this.getPosY());
			
		}

	}

	public TextureRegion getImagem(float deltaP) {
		estadoAtual = getStado();

		TextureRegion region;

		switch(estadoAtual) {
		case CORRENDO:
			region = rolosImagemPersonagemAndando[roloImagem].getKeyFrame(estadoTempo, true);
			break;
		case PARADO:
		default:
			region = imagemPersonagemParado[roloImagem];
			break;
		}
		estadoTempo = estadoAtual == estadoAnterior ? estadoTempo + deltaP : 0;
		estadoAnterior = estadoAtual;
		return region;
	}

	public Estado getStado() {
		if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.RIGHT) ) {
			if ((Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.DOWN)) || (Gdx.input.isKeyPressed(Keys.LEFT) &&  Gdx.input.isKeyPressed(Keys.RIGHT))) {
				return Estado.PARADO;
			}
			else {
				return Estado.CORRENDO;
			}
		}
		else {
			return Estado.PARADO;
		}

	}

	public float getDelta() {
		return delta;
	}

	public void setDelta(float deltaP) {
		this.delta = deltaP;
	}
	
}

