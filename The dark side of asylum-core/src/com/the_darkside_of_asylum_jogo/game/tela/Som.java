package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;


public class Som extends Thread{
	private String nome_musica;
	private Music musica;


	public void tocar(String mp3) {
		this.nome_musica = mp3;
	}


	public void run() {
		this.musica = Gdx.audio.newMusic(Gdx.files.internal(this.nome_musica));
		if(MenuTela.tocando.equals("tocar")) {
			musica.setLooping(true);
			musica.play();
		}
		while(true){
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e){
				
			}
			if(MenuTela.tocando.equals("parar")) {
				this.musica.stop();
			} 
			else if(MenuTela.tocando.equals("retornar")){
				this.musica.play();
				MenuTela.tocando = "tocar";
			}
			
		}
	}
}