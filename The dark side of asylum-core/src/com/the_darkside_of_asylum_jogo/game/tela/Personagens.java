package com.the_darkside_of_asylum_jogo.game.tela;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;

public class Personagens{

	protected enum Estado {PARADO, CORRENDO}
	protected Estado estadoAtual;
	protected Estado estadoAnterior;

	protected static final float VELOCIDADE = 300;
	protected static final float VELOCIDADE_ANIMACAO_PERSONAGEM = 0.2f;

	protected Animation<TextureRegion>[] rolosImagemPersonagemAndando;
	protected TextureRegion[] imagemPersonagemParado;
	protected int roloImagem;

	protected float posX;
	protected float posY;
	public static int larguraPersonagem;
	public static int alturaPersonagem;
	
	protected Colisao colisao;
	
	protected float estadoTempo;
	
	protected JogoTela tela;
	protected static int limiteLarguraTela;
	protected static int limiteAlturaTela;
	

	public Personagens(JogoTela telaP, String caminhoP, float posYP, int larguraPersonagemPixelP,int  alturaPersonagemPixelP,int limiteLarguraTelaP,int limiteAlturaTelaP) {
		this.larguraPersonagem = larguraPersonagemPixelP * 3;
		this.alturaPersonagem = alturaPersonagemPixelP * 3;
		this.tela = telaP;
		this.limiteLarguraTela = limiteLarguraTelaP;  
		this.limiteAlturaTela = limiteAlturaTelaP;
		this.setPosX(The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - larguraPersonagem /2); 
		this.setPosY(posYP);
		
		this.colisao = new Colisao(this.getPosX(), this.getPosY(), larguraPersonagem, alturaPersonagem);

		this.setRoloImagem(0);
		this.rolosImagemPersonagemAndando = new Animation[4];
		this.imagemPersonagemParado = new TextureRegion[4];

		TextureRegion[][] roloSpriteSheet = TextureRegion.split(new Texture(caminhoP), larguraPersonagemPixelP, alturaPersonagemPixelP);

		this.rolosImagemPersonagemAndando[0] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[0]);
		this.rolosImagemPersonagemAndando[1] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[1]);
		this.rolosImagemPersonagemAndando[2] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[2]);
		this.rolosImagemPersonagemAndando[3] = new Animation(VELOCIDADE_ANIMACAO_PERSONAGEM, roloSpriteSheet[3]);

		this.imagemPersonagemParado[0] = new TextureRegion(new Texture(caminhoP), 0, 0, larguraPersonagemPixelP, alturaPersonagemPixelP);
		this.imagemPersonagemParado[1] = new TextureRegion(new Texture(caminhoP), 0, alturaPersonagemPixelP, larguraPersonagemPixelP, alturaPersonagemPixelP);
		this.imagemPersonagemParado[2] = new TextureRegion(new Texture(caminhoP), 0, alturaPersonagemPixelP * 2, larguraPersonagemPixelP, alturaPersonagemPixelP);
		this.imagemPersonagemParado[3] = new TextureRegion(new Texture(caminhoP), 0, alturaPersonagemPixelP * 3, larguraPersonagemPixelP, alturaPersonagemPixelP);
	}

	public static float getVelocidade() {
		return VELOCIDADE;
	}
	
	public int getRoloImagem() {
		return roloImagem;
	}

	public void setRoloImagem(int roloImagemP) {
		this.roloImagem = roloImagemP;
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
	
	public int getLarguraPersonagem () {
		return larguraPersonagem;
	}
	
	public int getAlturaPersonagem () {
		return alturaPersonagem;
	}
	
	public float getEstadoTempo() {
		return estadoTempo;
	}

	public void setEstadoTempo(float estadoTempoP) {
		this.estadoTempo = estadoTempoP;
	}

	public void andarParaEsquerda() {
		if( this.getPosX() > 0) {
			this.setPosX(this.getPosX() - this.getVelocidade() * Gdx.graphics.getDeltaTime());
		}
		else if(this.getPosX() <= 0){
			this.setPosX(0);
		}
		this.setRoloImagem(2);
	}

	public void andarParaDireita() {
		if(this.getPosX() + this.larguraPersonagem < this.limiteLarguraTela) {
			this.setPosX(this.getPosX() + this.getVelocidade() * Gdx.graphics.getDeltaTime());
		}
		else if(this.getPosX() + this.larguraPersonagem >= this.limiteLarguraTela ){
			this.setPosX(limiteLarguraTela - larguraPersonagem);
		}
		this.setRoloImagem(1);
	}
	
	public void andarParaCima() {
		if(this.getPosY() + alturaPersonagem < this.limiteAlturaTela ) {
			this.setPosY(this.getPosY() + this.getVelocidade() * Gdx.graphics.getDeltaTime());
		}
		else if(this.getPosY() + alturaPersonagem >= this.limiteAlturaTela) {
			this.setPosY(limiteAlturaTela  - alturaPersonagem);
		}
		this.setRoloImagem(3);

	}

	public void andarParaBaixo() {
		if( this.getPosY()  > 0) {
			this.setPosY(this.getPosY() - this.getVelocidade() * Gdx.graphics.getDeltaTime());
		}
		else if ( this.getPosY()  <= 0){
			this.setPosY(0);
		}
		this.setRoloImagem(0);
	}
	
	public void colidiu(Colisao colisaoP) {
		if(getColisao().colideCom(colisaoP)){
			if(getColisao().colideDireitoCom(colisaoP)) {
				this.setPosX(this.getPosX() - this.getVelocidade() * Gdx.graphics.getDeltaTime());
				//NPC.estaAndando = false;
			}
			else if(getColisao().colideEsquerdoCom(colisaoP)) { 
				this.setPosX(getPosX()  + this.getVelocidade() * Gdx.graphics.getDeltaTime());
				//NPC.estaAndando = false;
			}
			else if(getColisao().colideCimaCom(colisaoP)) {		
				this.setPosY(getPosY()  - this.getVelocidade() * Gdx.graphics.getDeltaTime());
				//NPC.estaAndando = false;
			}
			else if(getColisao().colideBaixoCom(colisaoP)){
				this.setPosY(getPosY()  + this.getVelocidade() * Gdx.graphics.getDeltaTime());
				//NPC.estaAndando = false;
			}
		}
		
	}
	
	public Colisao getColisao() {
		return colisao;
	}
}
