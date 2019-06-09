package com.the_darkside_of_asylum_jogo.game.tela;

import java.util.Random;


import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class NPC extends Personagens implements Runnable{

	private String qualNpc;
	
	private String direcao;
	private Random aleatorio = new Random();
	private int direcaoAleatorio;
	
	private float delta;
	public static boolean estaAndando;

	public NPC(JogoTela telaP, String caminhoP, String qualNpcP, int larguraPersonagemPixelP,int  alturaPersonagemPixelP,int limiteLarguraTelaP, int limiteAlturaTelaP) {
		super(telaP, caminhoP, limiteAlturaTela - alturaPersonagemPixelP * 3, larguraPersonagemPixelP, alturaPersonagemPixelP, limiteLarguraTelaP, limiteAlturaTelaP );
		this.setQualNpc(qualNpcP);
		this.setDirecaoAleatorio(this.aleatorio.nextInt(2));
		if (this.getDirecaoAleatorio() == 0) {
			this.setDirecao("Esquerda");}
		else {
			this.setDirecao("Direita");
		}
		estaAndando = true;
	}

	public void run() {
		while (true){
			this.setEstadoTempo(this.getEstadoTempo() + getDelta());
			try {
				Thread.sleep(15);
			}
			catch(InterruptedException e){

			}
			if (estaAndando) {
			this.andar();
			colisao.mover(this.getPosX(), this.getPosY());
			}
		}
	}

	public String getQualNpc() {
		return qualNpc;
	}

	public void setQualNpc(String qualNpcP) {
		this.qualNpc = qualNpcP;
	}
	
	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcaoP) {
		this.direcao = direcaoP;
	}
	
	public int getDirecaoAleatorio() {
		return direcaoAleatorio;
	}

	public void setDirecaoAleatorio(int direcaoAleatorioP) {
		this.direcaoAleatorio = direcaoAleatorioP;
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
		if (this.getPosX() > 0 && this.getPosX() < limiteLarguraTela - larguraPersonagem || this.getPosY() > 0 && this.getPosY() < limiteAlturaTela - alturaPersonagem) {
			return Estado.CORRENDO;

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

	public void andar() {
		if(this.getQualNpc() == "Medico"|| this.getQualNpc() == "Enfermeiro" || this.getQualNpc() == "Guarda") {
			if(this.getDirecao() == "Direita") {
				this.andarParaDireita();
				this.trocarDirecao();
			}
			else if(this.getDirecao() == "Esquerda") {
				this.andarParaEsquerda();
				this.trocarDirecao();
			}
		}
		else if (this.getQualNpc() == "Louco") {
			if(this.getDirecao() == "Direita") {
				this.andarParaDireita();
				this.trocarDirecaoLouco();
			}
			else if(this.getDirecao() == "Esquerda") {
				this.andarParaEsquerda();
				this.trocarDirecaoLouco();
			}
			else if(this.getDirecao()== "Cima"){
				this.andarParaCima();
				this.trocarDirecaoLouco();
			}
			else if(this.getDirecao() == "Baixo") {
				this.andarParaBaixo();
				this.trocarDirecaoLouco();
			} 
			else if (this.getDirecao() == "DiagonalDireitaBaixo") {
				this.andarParaDiagonalDireitaBaixo();
				this.trocarDirecaoLouco();
			}
			else if (this.getDirecao() == "DiagonalDireitaCima") {
				this.andarParaDiagonalDireitaCima();
				this.trocarDirecaoLouco();
			}
			else if (this.getDirecao() == "DiagonalEsquerdaBaixo") {
				this.andarParaDiagonalEsquerdaBaixo();
				this.trocarDirecaoLouco();
			}
			else if (this.getDirecao() == "DiagonalEsquerdaCima") {
				this.andarParaDiagonalEsquerdaCima();
				this.trocarDirecaoLouco();
			}
		}
	}

	public void trocarDirecao(){
		if (this.getPosX() == 0.0) {
			this.setDirecao("Direita");
		}
		else if (this.getPosX() == limiteLarguraTela - larguraPersonagem) {
			this.setDirecao("Esquerda");
		}
	}

	public void trocarDirecaoLouco(){
		//saindo
		if(this.getPosX() == 0.0 && this.getPosY() == limiteAlturaTela - alturaPersonagem) {
			if(this.getDirecao() == "Cima" || this.getDirecao() == "Esquerda"|| this.getDirecao() =="DiagonalEsquerdaCima") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(3));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao("DiagonalDireitaBaixo");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao("Baixo");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao("Direita");
				}
			}
		}
		else if(this.getPosX() == 0.0 && this.getPosY() == 0.0) {
			if(this.getDirecao() == "Baixo" || this.getDirecao() == "Esquerda"|| this.getDirecao() =="DiagonalEsquerdaBaixo") {
				this.setDirecaoAleatorio( this.aleatorio.nextInt(3));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "DiagonalDireitaCima");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "Cima");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao( "Direita");
				}
			}
		}
		else if(this.getPosX() == limiteLarguraTela - larguraPersonagem && this.getPosY() == limiteAlturaTela - alturaPersonagem) {
			if(this.getDirecao() == "Cima" || this.getDirecao() == "Direita"|| this.getDirecao() =="DiagonalDireitaCima") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(3));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "DiagonalEsquerdaBaixo");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "Baixo");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao( "Esquerda");
				}
			}
		}
		else if(this.getPosX() == limiteLarguraTela - larguraPersonagem && this.getPosY() == 0.0) {
			if(this.getDirecao() == "Baixo" || this.getDirecao() == "Direita"||this.getDirecao() == "DiagonalDireitaBaixo") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(3));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "DiagonalEsquerdaCima");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "Cima");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao( "Esquerda");
				}
			}
		}
		else if (this.getPosX() == 0 && ((this.getPosY() >= (limiteAlturaTela - alturaPersonagem)/2 - 3) && this.getPosY() <= ((limiteAlturaTela - alturaPersonagem)/2 + 3))) {
			if(this.getDirecao() == "Baixo" || this.getDirecao() == "Cima"|| this.getDirecao() == "Esquerda") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(5));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Cima");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "DiagonalDireitaCima");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao( "Direita");
				}
				else if(this.getDirecaoAleatorio () == 3) {
					this.setDirecao( "DiagonalDireitaBaixo");
				}
				else if(this.getDirecaoAleatorio () == 4) {
					this.setDirecao( "Baixo");
				}
			}
		} 
		else if ((this.getPosX() >= ((limiteLarguraTela - larguraPersonagem)/2 - 3 ) && this.getPosX() <= ((limiteLarguraTela - larguraPersonagem)/2 + 3)) && this.getPosY() == 0) {
			if(this.getDirecao() == "Esquerda" || this.getDirecao() == "Direita"|| this.getDirecao() == "Baixo") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(5));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Esquerda");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "DiagonalEsquerdaCima");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao( "Cima");
				}
				else if(this.getDirecaoAleatorio () == 3) {
					this.setDirecao( "DiagonalDireitaCima");
				}
				else if(this.getDirecaoAleatorio () == 4) {
					this.setDirecao( "Direita");
				}
			}
		}
		else if (this.getPosX() == limiteLarguraTela - larguraPersonagem && ((this.getPosY() >= (limiteAlturaTela - alturaPersonagem)/2 - 3) && this.getPosY() <= ((limiteAlturaTela - alturaPersonagem)/2 + 3))) {
			if(this.getDirecao() == "Baixo" || this.getDirecao() == "Cima"|| this.getDirecao() == "Direita") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(5));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Cima");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "DiagonalEsquerdaCima");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao( "Esquerda");
				}
				else if(this.getDirecaoAleatorio () == 3) {
					this.setDirecao( "DiagonalEsquerdaBaixo");
				}
				else if(this.getDirecaoAleatorio () == 4) {
					this.setDirecao( "Baixo");
				}
			}
		}
		else if ((this.getPosX() >= ((limiteLarguraTela - larguraPersonagem)/2 - 3) && this.getPosX() <= ((limiteLarguraTela - larguraPersonagem)/2 + 3))  && this.getPosY() == limiteAlturaTela - alturaPersonagem) {
			if(this.getDirecao() == "Esquerda" || this.getDirecao() == "Direita"|| this.getDirecao() == "Cima") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(5));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Esquerda");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "DiagonalEsquerdaBaixo");
				}
				else if(this.getDirecaoAleatorio () == 2) {
					this.setDirecao( "Baixo");
				}
				else if(this.getDirecaoAleatorio () == 3) {
					this.setDirecao( "DiagonalDireitaBaixo");
				}
				else if(this.getDirecaoAleatorio () == 4) {
					this.setDirecao( "Direita");
				}
			}
		}
		else if (this.getPosX() == 0.0) {
			if(this.getDirecao() == "DiagonalDireitaBaixo" || this.getDirecao() =="DiagonalDireitaCima" || this.getDirecao() == "DiagonalEsquerdaBaixo" || this.getDirecao() =="DiagonalEsquerdaCima") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(2));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Baixo");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "Cima");
				}
			}
		}
		else if(this.getPosY() == 0.0 ){
			if(this.getDirecao() == "DiagonalDireitaBaixo" || this.getDirecao() =="DiagonalDireitaCima" || this.getDirecao() == "DiagonalEsquerdaBaixo" || this.getDirecao() =="DiagonalEsquerdaCima") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(2));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Esquerda");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "Direita");
				}
			}
		}
		else if(this.getPosX() == limiteLarguraTela - larguraPersonagem) {
			if(this.getDirecao() == "DiagonalDireitaBaixo" || this.getDirecao() =="DiagonalDireitaCima" || this.getDirecao() == "DiagonalEsquerdaBaixo" || this.getDirecao() =="DiagonalEsquerdaCima") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(2));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Baixo");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "Cima");
				}
			}
		}
		else if(this.getPosY() == limiteAlturaTela - alturaPersonagem) {
			if(this.getDirecao() == "DiagonalDireitaBaixo" || this.getDirecao() =="DiagonalDireitaCima" || this.getDirecao() == "DiagonalEsquerdaBaixo" || this.getDirecao() =="DiagonalEsquerdaCima") {
				this.setDirecaoAleatorio(this.aleatorio.nextInt(2));
				if(this.getDirecaoAleatorio () == 0) {
					this.setDirecao( "Esquerda");
				}
				else if(this.getDirecaoAleatorio () == 1) {
					this.setDirecao( "Direita");
				}
			}
		}

	}

	public void andarParaDiagonalEsquerdaBaixo() {
		this.andarParaEsquerda();
		this.andarParaBaixo();
	}

	public void andarParaDiagonalEsquerdaCima() {
		this.andarParaEsquerda();
		this.andarParaCima();
	}

	public void andarParaDiagonalDireitaBaixo() {
		this.andarParaDireita();
		this.andarParaBaixo();
	}

	public void andarParaDiagonalDireitaCima() {
		this.andarParaDireita();
		this.andarParaCima();
	}
	
}
