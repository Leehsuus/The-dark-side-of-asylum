package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Som extends Thread{
	//Varivel com o caminho da musica
		private String nome_musica;
		private Music musica;
		private String tocando;
		private boolean loop;

		//Passando o caminho
		public void tocar(String mp3, boolean loopP) {
			this.nome_musica = mp3;
			this.loop = loopP;
		}
		
		public String getTocando() {
			return tocando;
		}

		public void setTocando(String tocando) {
			this.tocando = tocando;
		}


		//Run da thread
		public void run() {
			this.musica = Gdx.audio.newMusic(Gdx.files.internal(this.nome_musica));
			if(this.getTocando() == "tocar") {
				musica.setLooping(this.loop);
				musica.play();
			}
			while(true){
				try {
					Thread.sleep(10);
				}
				catch(InterruptedException e){
					
				}
				if(this.getTocando() == "parar") {
					this.musica.stop();
				} 
				else if(this.getTocando() == "retornar"){
					this.musica.play();
					this.setTocando("tocar");
				}
				
			}
		}

	}
