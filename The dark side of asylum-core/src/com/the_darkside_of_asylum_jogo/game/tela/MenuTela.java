package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;


public class MenuTela implements Screen {
	private The_DarkSide_of_Asylum_Jogo jogo;
	Texture fundo_menu;
	Texture btn_jogar_pt;
	Texture btn_idioma_pt;
	Texture btn_historia_pt;
	Texture btn_jogar_en;
	Texture btn_idioma_en;
	Texture btn_historia_en;
	Texture btn_pt;
	Texture btn_eng;
	Texture seta_dir;
	Texture seta_esq;
	Texture btn_com_som;
	Texture btn_sem_som;
	Texture btn_som_aux;
	
	OrthographicCamera camera;
	
	Rectangle seta;
	Rectangle btn_som;
	
	int status_jogo = 1;
	

	
	String local_musica = "/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Musica/From The Inside Lyrics.mp3";
	
	Som som = new Som();
	public static boolean tocando = true ; 
	
	Vector3 touchPoint;
	
	public MenuTela(The_DarkSide_of_Asylum_Jogo jogo) {
		this.jogo = jogo;
		fundo_menu = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Fundo do Menu.png");
		
		btn_jogar_pt = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Jogar.png");
		btn_idioma_pt = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Idioma.png");
		btn_historia_pt = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Historia.png");
		btn_jogar_en = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Play.png");
		btn_idioma_en = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Language.png");
		btn_historia_en = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Story.png");
		btn_pt = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Portugues.png");
		btn_eng = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/English.png");
		seta_dir = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Seta.png");
		seta_esq = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/Seta e.png");

		//fundo_jogando_aux = fun 
		btn_com_som = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/som.png");
		btn_sem_som = new Texture("/home/leticia/eclipse-workspace/The dark side of asylum-core/assets/Imagens/Menu/sem_som.png");
		btn_som_aux = btn_com_som;
		btn_som = new Rectangle();
		seta = new Rectangle();
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false, 2086, 1106);
		//touchPoint = new Vector3();
		seta.x = 760;
		seta.y = 458;
		btn_som.x = 20;
		btn_som.y = 20;
	}
	
	@Override
	public void show() {
		som.tocar(local_musica);
		try {
				som.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desenhar(int status) {
		if (status == 1) {
			jogo.lote.begin();
			jogo.lote.draw(fundo_menu, 0, 0);
			jogo.lote.draw(btn_jogar_pt, 800, 415);
			jogo.lote.draw(btn_idioma_pt, 800, 313);
			jogo.lote.draw(btn_historia_pt, 800, 211);
			jogo.lote.draw(seta_dir, seta.x, seta.y);
			jogo.lote.end();
		} 
		else if(status == 2) {
			jogo.lote.begin();
			jogo.lote.draw(fundo_menu, 0, 0);
			jogo.lote.draw(btn_pt, 14, 326);
			jogo.lote.draw(btn_eng, 14, 214);
			jogo.lote.draw(seta_esq, seta.x, seta.y);
			jogo.lote.end();
		}
		else if (status == 3) {
			jogo.lote.begin();
			jogo.lote.draw(fundo_menu, 0, 0);
			jogo.lote.draw(btn_jogar_en, 800, 415);
			jogo.lote.draw(btn_idioma_en, 800, 313);
			jogo.lote.draw(btn_historia_en, 800, 211);
			jogo.lote.draw(seta_dir, seta.x, seta.y);
			jogo.lote.end();
		}
		else {
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}
		jogo.lote.begin();
		jogo.lote.draw(btn_som_aux, btn_som.x, btn_som.y, 40, 30);
		jogo.lote.end();		
	}
	
	/*public boolean pointInRectangle (Rectangle r, float x, float y) {
	       return r.x <= x && r.x + r.width >= x && r.y <= y && r.y + r.height >= y;
	   }
	
	public void update() {
		camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
	         if (Gdx.input.justTouched()) {
	        	System.out.printf("cursor:" + camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0)) + "\n");
	        	System.out.printf("botao_som" + btn_som.x + "," + btn_som.y);
	            if (pointInRectangle(btn_som, touchPoint.x, touchPoint.y)) {
	            	System.out.println("Colidiu");
	                if (btn_som_aux == btn_com_som) {
	                	btn_som_aux = btn_sem_som;
	                } else {
	                	btn_som_aux = btn_com_som;
	                }
	            }
	        }
	}*/
	
	public void status_1_3 () {
		if (Gdx.input.isKeyJustPressed(Keys.DOWN) && (seta.y == 458 || seta.y == 358)) {
			seta.y -= 100;
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.UP) && (seta.y == 258 || seta.y == 358)) {
			seta.y += 100;
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && seta.y == 358) {
			seta.x = 233;
			seta.y = 385;
			status_jogo = 2;
			}
		
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && seta.y == 458) {
			dispose();
			jogo.setScreen(new JogoTela(jogo));
			status_jogo = 0;
			
		}
	}
	
	public void status_2() {
		if (Gdx.input.isKeyJustPressed(Keys.DOWN) && seta.y == 385) {
			seta.y -= 105;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.UP) && seta.y == 280) {
			seta.y += 105;
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && seta.y == 385) { 
			seta.x = 760;
			seta.y = 458;
			status_jogo = 1;
		} else if (Gdx.input.isKeyJustPressed(Keys.ENTER) && seta.y == 280) { 
			seta.x = 760;
			seta.y = 458;
			status_jogo = 3;
			}
	}
	
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		desenhar(status_jogo);
		//update();
		
		if (status_jogo == 1 || status_jogo == 3) {
			status_1_3();
		} else if (status_jogo == 2) {
			status_2();
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.M)) {
			if(tocando) {
				tocando = false;
				btn_som_aux = btn_sem_som;
			}
			else if (tocando == false){
				tocando = true;
				btn_som_aux = btn_com_som;
			}
		}
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		//jogo.lote.dispose();
		fundo_menu.dispose();
		btn_jogar_pt.dispose();
		btn_idioma_pt.dispose();
		btn_historia_pt.dispose();
		btn_jogar_en.dispose();
		btn_idioma_en.dispose();
		btn_historia_en.dispose();
		btn_pt.dispose();
		btn_eng.dispose();
		seta_dir.dispose();
		seta_esq.dispose();
	}

}
