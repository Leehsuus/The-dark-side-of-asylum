package com.the_darkside_of_asylum_jogo.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;



public class MenuTela implements Screen {

	private The_DarkSide_of_Asylum_Jogo jogo;

	//bd
	ManipulacaoDados md;

	//Menu
	private Texture fundo_menu;
	private Texture btn_continuar;
	private Texture btn_continuarI;
	private Texture btn_jogar_pt;
	private Texture btn_idioma_pt;
	private Texture btn_historia_pt;
	private Texture btn_jogar_en;
	private Texture btn_idioma_en;
	private Texture btn_historia_en;
	private Texture btn_pt;
	private Texture btn_eng;
	private Texture seta_dir;
	private Texture seta_esq;
	private Texture btn_com_som;
	private Texture btn_sem_som;
	private Texture btn_som_aux;

	private int status_jogo = 1;

	private String local_musica = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Musica/Musica_menu.mp3";
	private Som som = new Som();
	public static String tocando = ""; 
	public static boolean clicado;

	private Rectangle seta;
	private Rectangle btn_som;

	public static boolean continuar = false; 

	public MenuTela (The_DarkSide_of_Asylum_Jogo jogo) {
		this.jogo = jogo;

		this.md = new ManipulacaoDados();
		this.md.TemDadosNoBanco();

		this.fundo_menu = new Texture("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/fundo do menu.png");

		this.btn_pt = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/portugues.png"));
		this.btn_jogar_pt = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/jogar.png"));
		this.btn_continuar = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/continuar.png"));
		this.btn_continuarI = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/continuarI.png"));
		this.btn_idioma_pt = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/idioma.png"));
		this.btn_historia_pt = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/historia.png"));

		this.btn_eng = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/english.png"));
		this.btn_jogar_en = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/play.png"));
		this.btn_idioma_en = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/language.png"));
		this.btn_historia_en = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/story.png"));

		this.seta_dir = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/seta.png"));
		this.seta_esq = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/seta e.png"));

		this.btn_com_som = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/som.png"));
		this.btn_sem_som = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/sem_som.png"));
		this.btn_som_aux = btn_com_som;

		this.btn_som = new Rectangle();
		this.btn_som.x = 20;
		this.btn_som.y = 20;
		this.btn_som.width = 40;
		this.btn_som.height = 30;

		this.seta = new Rectangle();
		this.seta.x = 760;
		this.seta.y = 458;
	}

	public void desenhar(int statusP) {
		this.jogo.lote.begin();
		if (statusP == 1) {
			this.jogo.lote.draw(fundo_menu, 0, 0);
			this.jogo.lote.draw(btn_jogar_pt, 800, 415);
			if (md.temDados) {
				this.jogo.lote.draw(btn_continuar, 800, 313);
			}
			else {
				this.jogo.lote.draw(btn_continuarI, 800, 313);
			}
			this.jogo.lote.draw(btn_idioma_pt, 800, 211);
			this.jogo.lote.draw(btn_historia_pt, 800, 109);
			this.jogo.lote.draw(seta_dir, seta.x, seta.y);
		} 
		else if(statusP == 2) {
			this.jogo.lote.draw(fundo_menu, 0, 0);
			this.jogo.lote.draw(btn_pt, 14, 326);
			this.jogo.lote.draw(btn_eng, 14, 214);
			this.jogo.lote.draw(seta_esq, seta.x, seta.y);
		}
		else if (statusP == 3) {
			this.jogo.lote.draw(fundo_menu, 0, 0);
			this.jogo.lote.draw(btn_jogar_en, 800, 415);
			if(md.temDados) {
				this.jogo.lote.draw(btn_continuar, 800, 313);
			}
			else {
				this.jogo.lote.draw(btn_continuarI, 800, 313);
			}

			this.jogo.lote.draw(btn_idioma_en, 800, 211);
			this.jogo.lote.draw(btn_historia_en, 800, 109);
			this.jogo.lote.draw(seta_dir, seta.x, seta.y);
		}
		this.jogo.lote.draw(btn_som_aux, btn_som.x, btn_som.y, btn_som.width, btn_som.height);
		this.jogo.lote.end();
	}

	public boolean pontoEmRetangulo(Rectangle rectP) {
		int mouse_X = Gdx.input.getX();
		int mouse_Y = The_DarkSide_of_Asylum_Jogo.ALTURA_TELA - Gdx.input.getY();
		return (mouse_X < rectP.x + rectP.width && mouse_X > rectP.x) && ( mouse_Y < rectP.y + rectP.height && mouse_Y > rectP.y);
	}

	public void eventos(){

		if (this.status_jogo == 1 ||this. status_jogo == 3) {
			this.status_1_3();
		} else if (this.status_jogo == 2) {
			status_2();
		}

		if (Gdx.input.isKeyJustPressed(Keys.M) || (pontoEmRetangulo(btn_som) && Gdx.input.isTouched())) {
			if(this.clicado) {
				this.clicado = false;
				if((this.tocando == "tocar"|this.tocando == "retonar") && this.btn_som_aux == this.btn_com_som) {
					this.tocando = "parar";
					this.btn_som_aux = this.btn_sem_som;
				}
				else if (this.tocando == "parar"){
					this.tocando = "retornar";
					this.btn_som_aux = this.btn_com_som;
				}
			}
		}
		else {
			this.clicado = true;
		}
	}
	
	public void status_1_3 () {
		if (Gdx.input.isKeyJustPressed(Keys.DOWN) && (this.seta.y == 458 ||this. seta.y == 358|| this.seta.y == 258)) {
			this.seta.y -= 100;
		}

		if (Gdx.input.isKeyJustPressed(Keys.UP) && (this.seta.y == 258 || this.seta.y == 358|| this.seta.y == 158)) {
			this.seta.y += 100;
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 258) {
			this.seta.x = 233;
			this.seta.y = 385;
			this.status_jogo = 2;
		}
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 158) {
			this.dispose();
			this.tocando ="parar";
			this.jogo.setScreen(new Historia(jogo));
			this.status_jogo = 0;
			this.som.stop();
		}
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 458) {
			this.dispose();
			md.DeletarDoBanco();
			this.tocando ="parar";
			this.jogo.setScreen(new JogoTela(jogo));
			this.status_jogo = 0;
			this.som.stop();
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 358) {
			if(md.temDados) {
				this.dispose();
				this.continuar = true;
				this.tocando ="parar";
				this.jogo.setScreen(new JogoTela(jogo));
				this.status_jogo = 0;
				this.som.stop();
			}
		}
	}

	public void status_2() {
		if (Gdx.input.isKeyJustPressed(Keys.DOWN) && this.seta.y == 385) {
			this.seta.y -= 105;
		}

		if(Gdx.input.isKeyJustPressed(Keys.UP) && this.seta.y == 280) {
			this.seta.y += 105;
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 385) { 
			this.seta.x = 760;
			this.seta.y = 458;
			this.status_jogo = 1;
		} else if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 280) { 
			this.seta.x = 760;
			this.seta.y = 458;
			this.status_jogo = 3;
		}
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.som.tocar(local_musica);
		try {
			this.tocando = "tocar";
			this.som.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.desenhar(status_jogo);
		this.eventos();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.fundo_menu.dispose();
		this.btn_jogar_pt.dispose();
		this.btn_idioma_pt.dispose();
		this.btn_historia_pt.dispose();
		this.btn_jogar_en.dispose();
		this.btn_idioma_en.dispose();
		this.btn_historia_en.dispose();
		this.btn_pt.dispose();
		this.btn_eng.dispose();
		this.seta_dir.dispose();
		this.seta_esq.dispose();
	}

}


