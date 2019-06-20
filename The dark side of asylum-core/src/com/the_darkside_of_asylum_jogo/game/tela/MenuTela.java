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

	//bd
	//ManipulacaoDados md;

	//Menu
	private Texture fundo_menu;
	private Texture btn_continuar;
	private Texture btn_continuarI;
	private Texture btn_jogar_pt;
	private Texture btn_como_jogar;
	private Texture btn_historia_pt;
	private Texture seta_dir;
	private Texture btn_com_som;
	private Texture btn_sem_som;
	private Texture btn_som_aux;

	private int status_jogo = 1;


	private Som som_menu = new Som();
	public static boolean clicado;

	private Rectangle seta;
	private Rectangle btn_som;

	public static boolean continuar = false; 
	//construtor
	public MenuTela (The_DarkSide_of_Asylum_Jogo jogo) {
		this.jogo = jogo;

		//this.md = new ManipulacaoDados();
		//this.md.TemDadosNoBanco();

		this.fundo_menu = new Texture("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/fundo do menu.png");

		this.btn_jogar_pt = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/jogar.png"));
		this.btn_continuar = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/continuar.png"));
		this.btn_continuarI = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/continuarI.png"));
		this.btn_como_jogar = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/como_jogar.png"));
		this.btn_historia_pt = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/historia.png"));

		this.seta_dir = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/seta.png"));

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
	//desenhar opções do menu
	public void desenhar(int statusP) {
		this.jogo.lote.begin();
		if (statusP == 1) {
			this.jogo.lote.draw(fundo_menu, 0, 0);
			this.jogo.lote.draw(btn_jogar_pt, 800, 415);
			/*if (md.temDados) {
				this.jogo.lote.draw(btn_continuar, 800, 313);
			}
			else {
				this.jogo.lote.draw(btn_continuarI, 800, 313);
			}*/
			this.jogo.lote.draw(btn_como_jogar, 800, 211);
			this.jogo.lote.draw(btn_historia_pt, 800, 109);
			this.jogo.lote.draw(seta_dir, seta.x, seta.y);
		} 
		this.jogo.lote.draw(btn_som_aux, btn_som.x, btn_som.y, btn_som.width, btn_som.height);
		this.jogo.lote.end();
	}
	//capturar interação do mouse com o botão de som
	public boolean pontoEmRetangulo(Rectangle rectP) {
		int mouse_X = Gdx.input.getX();
		int mouse_Y = The_DarkSide_of_Asylum_Jogo.ALTURA_TELA - Gdx.input.getY();
		return (mouse_X < rectP.x + rectP.width && mouse_X > rectP.x) && ( mouse_Y < rectP.y + rectP.height && mouse_Y > rectP.y);
	}
	//eventos do jogador na tela do menu
	public void eventos(){

		if (this.status_jogo == 1 ||this. status_jogo == 3) {
			this.status_1_3();
		}
		if (Gdx.input.isKeyJustPressed(Keys.M) || (pontoEmRetangulo(btn_som) && Gdx.input.isTouched())) {
			if(this.clicado) {
				this.clicado = false;
				if((this.som_menu.getTocando() == "tocar"|this.som_menu.getTocando() == "retonar") && this.btn_som_aux == this.btn_com_som) {
					this.som_menu.setTocando("parar");
					this.btn_som_aux = this.btn_sem_som;
				}
				else if (this.som_menu.getTocando() =="parar"){
					this.som_menu.setTocando("retornar");
					this.btn_som_aux = this.btn_com_som;
				}
			}
		}
		else {
			this.clicado = true;
		}
	}
	// eventos de movimentação das setas no menu
	public void status_1_3 () {
		if (Gdx.input.isKeyJustPressed(Keys.DOWN) && (this.seta.y == 458 ||this. seta.y == 358|| this.seta.y == 258)) {
			this.seta.y -= 100;
		}

		if (Gdx.input.isKeyJustPressed(Keys.UP) && (this.seta.y == 258 || this.seta.y == 358|| this.seta.y == 158)) {
			this.seta.y += 100;
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 258) {
			this.dispose();
			this.som_menu.setTocando("parar");
			this.jogo.setScreen(new ComoJogar(jogo));
			this.status_jogo = 0;
			this.som_menu.stop();
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 458) {
			this.dispose();
			//md.DeletarDoBanco();
			this.som_menu.setTocando("parar");
			this.jogo.setScreen(new JogoTela(jogo));
			this.status_jogo = 0;
			this.som_menu.stop();
		}
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 158) {
			this.dispose();
			this.som_menu.setTocando("parar");
			this.jogo.setScreen(new Historia(jogo));
			this.status_jogo = 0;
			this.som_menu.stop();
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.y == 358) {
			/*if(md.temDados) {
				this.dispose();
				this.continuar = true;
				this.som_menu.setTocando("parar");
				this.jogo.setScreen(new JogoTela(jogo));
				this.status_jogo = 0;
				this.som_menu.stop();
			}*/
		}
	}

	// manipulação do som
	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.som_menu.tocar("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Musica/Musica_menu.mp3",  true);
		try {
			this.som_menu.setTocando("tocar");
			this.som_menu.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	//renderização
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
	//encerramento das imagens depois de utilizadas
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.fundo_menu.dispose();
		this.btn_jogar_pt.dispose();
		this.btn_como_jogar.dispose();
		this.btn_historia_pt.dispose();
		this.seta_dir.dispose();
	}

}


