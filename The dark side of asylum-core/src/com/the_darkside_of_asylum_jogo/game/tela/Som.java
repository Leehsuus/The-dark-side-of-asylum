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
	try {
		musica = Gdx.audio.newMusic(Gdx.files.internal(this.nome_musica));
		musica.setLooping(true);
		musica.play();
		while(MenuTela.tocando){
			//System.out.print(JogarTela.tocando);
		}
		musica.stop();
		while(true){
			if(MenuTela.tocando) {
				run();
			}
		}
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	

}