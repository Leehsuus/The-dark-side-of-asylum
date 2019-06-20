package com.the_darkside_of_asylum_jogo.game.tela;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;





public class NPC extends Personagens implements Runnable{
	private String qualNpc;

	private String direcao;
	private Random aleatorio;
	private int direcaoAleatorio;

	private float delta;
	
	public static boolean estaAndando;

	//Construtor
	public NPC(JogoTela telaP, String caminhoP, String qualNpcP, int larguraPersonagemPixelP,int  alturaPersonagemPixelP,int limiteLarguraTelaP, int limiteAlturaTelaP) {
		super(telaP, caminhoP, limiteAlturaTela - alturaPersonagemPixelP * 3, larguraPersonagemPixelP, alturaPersonagemPixelP, limiteLarguraTelaP, limiteAlturaTelaP );
		this.aleatorio = new Random();
		this.setQualNpc(qualNpcP);
		this.setDirecaoAleatorio(this.aleatorio.nextInt(2));
		if (this.getDirecaoAleatorio() == 0) {
			this.setDirecao("Esquerda");}
		else {
			this.setDirecao("Direita");
		}
		estaAndando = true;
	}

	//Run Thread
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
				if(this.getColisao().colideCom(JogoTela.jogador.getColisao())){
					this.estaAndando = false;
				}
			}
		}
	}

	//Pegar a identificação do personagem
	public String getQualNpc() {
		return qualNpc;
	}

	//Passar a identificação do personagem
	public void setQualNpc(String qualNpcP) {
		this.qualNpc = qualNpcP;
	}

	//Pegar direção do personagem
	public String getDirecao() {
		return direcao;
	}

	//Passar a direção do personagem
	public void setDirecao(String direcaoP) {
		this.direcao = direcaoP;
	}

	//Pegar a direção inicial aleatoria
	public int getDirecaoAleatorio() {
		return direcaoAleatorio;
	}

	//Passar a direção inicial aleatoria
	public void setDirecaoAleatorio(int direcaoAleatorioP) {
		this.direcaoAleatorio = direcaoAleatorioP;
	}

	//reposicionar o personagem
	public void reposicionar() {
		this.setPosX(The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - larguraPersonagem /2); 
		this.setPosY(this.limiteAlturaTela - this.alturaPersonagem);
		this.estaAndando = true;
		if (this.getDirecaoAleatorio() == 0) {
			this.setDirecao("Esquerda");}
		else {
			this.setDirecao("Direita");
		}
	}

	//Pegar imagem de acordo com o seu estado e direção
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

	//Pegar o estado em que o personagem se encontra
	public Estado pegarStado() {
		if ((this.getPosX() > 0 && this.getPosX() < limiteLarguraTela - larguraPersonagem || this.getPosY() > 0 && this.getPosY() < limiteAlturaTela - alturaPersonagem) && estaAndando) {
			return Estado.CORRENDO;

		}
		else {
			return Estado.PARADO;
		}
	}

	//Pegar delta tempo
	public float getDelta() {
		return delta;
	}
	
	//Pegar delta tempo
	public void setDelta(float deltaP) {
		this.delta = deltaP;
	}

	//Movimentação do personagem
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

	//Trocar a direção do de qualquer personagem exceto o paciente
	public void trocarDirecao(){
		if (this.getPosX() == 0.0) {
			this.setDirecao("Direita");
		}
		else if (this.getPosX() == limiteLarguraTela - larguraPersonagem) {
			this.setDirecao("Esquerda");
		}
	}

	//Trocar a direção do personagem escifico para o paciente
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

	//Movimentar para diagonal esquerda com baixo
	public void andarParaDiagonalEsquerdaBaixo() {
		this.andarParaEsquerda();
		this.andarParaBaixo();
	}

	//Movimentar para diagonal esquerda com cima
	public void andarParaDiagonalEsquerdaCima() {
		this.andarParaEsquerda();
		this.andarParaCima();
	}

	//Movimentar para diagonal direita com baixo
	public void andarParaDiagonalDireitaBaixo() {
		this.andarParaDireita();
		this.andarParaBaixo();
	}

	//Movimentar para diagonal direita com cima
	public void andarParaDiagonalDireitaCima() {
		this.andarParaDireita();
		this.andarParaCima();
	}

}
