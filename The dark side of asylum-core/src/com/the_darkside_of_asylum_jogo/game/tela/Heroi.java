package com.the_darkside_of_asylum_jogo.game.tela;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;


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
			
			if (JogoTela.desenhar == "Medico") {
				this.colidiu(JogoTela.medico.getColisao());
			}
			else if(JogoTela.desenhar == "Paciente") {
				this.colidiu(JogoTela.louco.getColisao());	
			}

			else if(JogoTela.desenhar == "Porta") {
				this.colidiu(JogoTela.porta.getColisao());
			}
			else if(JogoTela.desenhar == "Enfermeiro") {
				this.colidiu(JogoTela.enfermeiro.getColisao());

			}
			else if(JogoTela.desenhar == "Cafe") {
				this.colidiu(JogoTela.cafe.getColisao());
			}
			else if(JogoTela.desenhar == "Guarda") {
				this.colidiu(JogoTela.guarda.getColisao());
			}
			else if(JogoTela.desenhar == "Cigarro") {
				this.colidiu(JogoTela.cigarro.getColisao());
			}
			else if(JogoTela.desenhar == "Bebida") {
				this.colidiu(JogoTela.bebida.getColisao());
			}
			else if(JogoTela.desenhar == "Parede") {
				this.colidiu(JogoTela.parede.getColisao());
			}
			else if(JogoTela.desenhar == "Cama") {
				this.colidiu(JogoTela.estante.getColisao());
				this.colidiu(JogoTela.estante2.getColisao());
				this.colidiu(JogoTela.armario.getColisao());
				this.colidiu(JogoTela.cama.getColisao());
			}
			else if (JogoTela.desenhar == "Remedio") {
				this.colidiu(JogoTela.remedio.getColisao());
			}
			else if (JogoTela.desenhar == "Estante") {
				this.colidiu(JogoTela.estante.getColisao());
				this.colidiu(JogoTela.estante2.getColisao());
				this.colidiu(JogoTela.cama.getColisao());
			}
			else if(JogoTela.desenhar == "Mesa") {
				this.colidiu(JogoTela.mesa.getColisao());
			}
			colisao.mover(this.getPosX(), this.getPosY());
			
		}

	}

	public TextureRegion pegarImagem(float deltaP) {
		estadoAtual = pegarStado();

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

	public Estado pegarStado() {
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
	
	
	public void reposicionar() {
		this.setPosX(The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - larguraPersonagem /2); 
		this.setPosY(15);
	}
}

