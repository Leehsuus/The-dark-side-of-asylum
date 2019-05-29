package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;
import com.the_darkside_of_asylum_jogo.game.tela.JogoTela;



public class Heroi extends Personagens{
	float y;
	public Heroi(JogoTela tela, String caminho){
		super(tela, caminho);
		y = 15; 
	}
	
	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}


	public void andarParaCima() {
		if(this.getY() + ALTURA_PERSONAGEM < The_DarkSide_of_Asylum_Jogo.ALTURA_TELA ) {
			this.setY(this.getY() + this.VELOCIDADE * Gdx.graphics.getDeltaTime());
		}
		else if(this.getY() + ALTURA_PERSONAGEM >= The_DarkSide_of_Asylum_Jogo.ALTURA_TELA ) {
			this.setY(Gdx.graphics.getHeight()  - ALTURA_PERSONAGEM);
		}
		this.setRolo(3);

	}

	public void andarParaBaixo() {
		if( this.getY()  > 0) {
			this.setY(this.getY() - VELOCIDADE * Gdx.graphics.getDeltaTime());
		}
		else if ( this.getY()  <= 0){
			this.setY(0);
		}
		this.setRolo(0);

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



}
