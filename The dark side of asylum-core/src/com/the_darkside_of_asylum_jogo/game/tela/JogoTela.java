package com.the_darkside_of_asylum_jogo.game.tela;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.the_darkside_of_asylum_jogo.game.The_DarkSide_of_Asylum_Jogo;


public class JogoTela implements Screen {

	private The_DarkSide_of_Asylum_Jogo jogo;

	// bd 
	//private ManipulacaoDados md;

	//escolhas
	private Escolhas jogar;
	private Texture fundo_jogo;
	private Texture escolha_um;
	private Texture escolha_dois;
	private Texture escolha_tres;
	private Texture seta_baixo;
	private Rectangle seta;
	private boolean escolheu;
	private boolean chegou_ao_fim;
	private Texture texto_escolha;
	private Texture fundo_final;
	private Texture animacao_final;
	private Rectangle animacao_f;

	//interatividade
	private Texture fundoInterativo01;

	public static  Heroi jogador;
	private Thread threadJogador;
	public static String direcaoYJogador;
	public static String direcaoXJogador;
	private boolean teclasOpostas;
	private String startadoJogador;
	
	public static NPC medico;
	private Thread threadMedico;
	private String startadoMedico;

	public static NPC louco;
	private Thread threadLouco;
	private String startadoLouco;

	public static Objetos porta;

	public static NPC enfermeiro; 
	private Thread threadEnfermeiro;
	private String startadoEnfermeiro;

	public static Objetos cafe;

	public static NPC guarda; 
	private Thread threadGuarda;
	private String startadoGuarda;

	public static Objetos cigarro;

	public static Objetos bebida;

	public static Objetos parede;

	public static Objetos cama;

	public static Objetos remedio;

	public static Objetos estante;

	public static Objetos mesa;
	
	public static Objetos estante2;
	
	public static Objetos armario;

	public static String desenhar;

	//maquina de estado
	public int estado;


	public JogoTela(The_DarkSide_of_Asylum_Jogo jogoP) {
		//bd
		//this.md = new ManipulacaoDados();

		//escolhas
		this.jogo = jogoP;
		this.jogar = new Escolhas();
		this.seta_baixo = new Texture("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Menu/Seta_baixo.png");
		this.seta = new Rectangle();
		this.seta.x = 150;
		this.seta.y = 120;
		this.escolheu = true;
		this.texto_escolha = jogar.getTexto_aux();
		this.animacao_f = new Rectangle();
		this.animacao_f.y = 600;
		/*if (MenuTela.continuar == true) {
			md.BuscarDados(jogar);
		}*/

		//interatividade
		this.fundoInterativo01 = new Texture("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/fundo01.png");

		this.jogador = new Heroi(this,"/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Investigador.png", 17, 26, Gdx.graphics.getWidth(), 250);
		this.threadJogador = new Thread(jogador);

		this.medico = new NPC(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Medico.png","Medico", 17, 26, Gdx.graphics.getWidth(), 250);
		this.threadMedico = new Thread(medico);

		this.louco = new NPC(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Louco.png","Louco", 17, 26, Gdx.graphics.getWidth(),250);
		this.threadLouco = new Thread(louco);

		this.porta = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Porta.png", 70, 116, 310, (70 - 50 /2));

		this.enfermeiro = new NPC(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Enfermeiro.png","Enfermeiro", 17, 26, Gdx.graphics.getWidth(),250);
		this.threadEnfermeiro = new Thread(enfermeiro);

		this.cafe = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Cafe.png", 65, 78, 247, (The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - 65/2));

		this.guarda = new NPC(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Guarda.png","Guarda", 17, 26, Gdx.graphics.getWidth(),250);
		this.threadGuarda = new Thread(guarda);

		this.cigarro = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Cigarro.png", 65, 78, 247, (The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - 65/2));

		this.bebida = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Bebida.png", 65, 78, 247, (The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - 65 /2));

		this.parede = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Parede.png", 51, 78, 265, (The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - 51 /2));

		this.cama = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Cama.png", 65, 78, 230, (900 - 65 /2));

		this.remedio = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Remedio.png", 65, 78, 247, (The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - 65 /2));

		this.estante = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Estante.png", 65, 78, 250, (The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - 65 /2));

		this.mesa = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Mesa.png", 65, 78, 250, (The_DarkSide_of_Asylum_Jogo.LARGURA_TELA / 2 - 65 /2));

		this.estante2 = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Estante2.png", 60,60, 230, (400 - 60 /2));
		
		this.armario = new Objetos(this, "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Interativos/Armario.png", 130, 150, 320,(140 - 130 /2));
		
		this.setTeclasOpostas(false);
		this.setStartadoJogador("n");
		this.setStartadoMedico("n");
		this.setStartadoLouco("n");
		this.setStartadoEnfermeiro("n");
		this.setStartadoGuarda("n");

		//maquina de estado
		this.setEstado(1);

	}

	public boolean isTeclasOpostas() {
		return teclasOpostas;
	}

	public void setTeclasOpostas(boolean teclasOpostasP) {
		this.teclasOpostas = teclasOpostasP;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estadoP) {
		this.estado = estadoP;
	}

	public String getStartadoJogador() {
		return startadoJogador;
	}

	public void setStartadoJogador(String startadoJogadorP) {
		this.startadoJogador = startadoJogadorP;
	}
	
	public String getStartadoMedico() {
		return startadoMedico;
	}

	public void setStartadoMedico(String startadoMedico) {
		this.startadoMedico = startadoMedico;
	}

	public String getStartadoLouco() {
		return startadoLouco;
	}

	public void setStartadoLouco(String startadoLouco) {
		this.startadoLouco = startadoLouco;
	}

	public String getStartadoEnfermeiro() {
		return startadoEnfermeiro;
	}

	public void setStartadoEnfermeiro(String startadoEnfermeiro) {
		this.startadoEnfermeiro = startadoEnfermeiro;
	}

	public String getStartadoGuarda() {
		return startadoGuarda;
	}

	public void setStartadoGuarda(String startadoGuarda) {
		this.startadoGuarda = startadoGuarda;
	}

	public void desenharEscolhas() {
		int pos_x_escolhas = 0;
		int pos_y_escolhas = 50;
		if (this.escolheu == true && this.chegou_ao_fim == false) {
			ArrayList<Texture> imagens_escolhas = new ArrayList<Texture>();
			imagens_escolhas = this.jogar.Ponto_decisao();
			this.fundo_jogo = imagens_escolhas.get(0);
			this.escolha_um = imagens_escolhas.get(1);
			this.escolha_dois = imagens_escolhas.get(2);
			this.escolha_tres = imagens_escolhas.get(3);
			this.jogo.lote.begin();
			this.jogo.lote.draw(this.fundo_jogo, pos_x_escolhas, 0);
			this.jogo.lote.draw(this.escolha_um, pos_x_escolhas + 15, pos_y_escolhas, (this.escolha_um.getWidth()/2), (this.escolha_um.getHeight()/2));
			this.jogo.lote.draw(this.escolha_dois, pos_x_escolhas + 365, pos_y_escolhas, (this.escolha_dois.getWidth()/2), (this.escolha_dois.getHeight()/2));
			this.jogo.lote.draw(this.escolha_tres, pos_x_escolhas + 730 , pos_y_escolhas, (this.escolha_tres.getWidth()/2), (this.escolha_tres.getHeight()/2));
			this.texto_escolha = this.jogar.getTexto_aux();
			this.jogo.lote.end();
			this.escolheu = false;
		} else if (this.escolheu == false && this.chegou_ao_fim == false) {
			this.jogo.lote.begin();
			this.jogo.lote.draw(this.fundo_jogo, pos_x_escolhas, 0);
			this.jogo.lote.draw(this.escolha_um, pos_x_escolhas + 15, pos_y_escolhas, (this.escolha_um.getWidth()/2), (this.escolha_um.getHeight()/2));
			this.jogo.lote.draw(this.escolha_dois, pos_x_escolhas + 365, pos_y_escolhas, (this.escolha_dois.getWidth()/2), (this.escolha_dois.getHeight()/2));
			this.jogo.lote.draw(this.escolha_tres, pos_x_escolhas + 730 , pos_y_escolhas, (this.escolha_tres.getWidth()/2), (this.escolha_tres.getHeight()/2));
			this.jogo.lote.draw(this.seta_baixo,this.seta.x, this.seta.y, (this.seta_baixo.getWidth()/2), (this.seta_baixo.getHeight()/2));
			this.jogo.lote.draw(this.texto_escolha, 40, 180);
			this.jogo.lote.end();
		}else if (this.chegou_ao_fim == true){
			this.jogo.lote.begin();
			this.fundo_final = jogar.getFundo_final();
			this.animacao_final = jogar.getAnimacao_final();
			this.jogo.lote.draw(this.fundo_final, pos_x_escolhas, 0);
			if (this.animacao_f.y > -450) {
				this.animacao_f.y -= 2;
			}
			this.jogo.lote.draw(this.animacao_final, 0, this.animacao_f.y);
			this.texto_escolha = this.jogar.getTexto_aux();
			this.jogo.lote.draw(this.texto_escolha, 40, 30);
			this.jogo.lote.end();
		}
	}

	public void desenharIteratividade(float deltaP) {
		this.jogo.lote.begin();
		this.jogo.lote.draw(fundoInterativo01, 0, 0, The_DarkSide_of_Asylum_Jogo.LARGURA_TELA, The_DarkSide_of_Asylum_Jogo.ALTURA_TELA);
		if (desenhar == "Medico") {
			this.sobreposicao(deltaP, medico);
		}
		else if(desenhar == "Paciente") {
			this.sobreposicao(deltaP, louco);	
		}

		else if(desenhar == "Porta") {
			this.jogo.lote.draw(this.porta.getImagem(),this. porta.getPosX(), this.porta.getPosY(), this.porta.larguraItem, this.porta.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if(desenhar == "Enfermeiro") {
			this.sobreposicao(deltaP, enfermeiro);

		}
		else if(desenhar == "Cafe") {
			this.jogo.lote.draw(this.cafe.getImagem(),this. cafe.getPosX(), this.cafe.getPosY(), this.cafe.larguraItem, this.cafe.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if(desenhar == "Guarda") {
			this.sobreposicao(deltaP, guarda);
		}
		else if(desenhar == "Cigarro") {
			this.jogo.lote.draw(this.cigarro.getImagem(),this. cigarro.getPosX(), this.cigarro.getPosY(), this.cigarro.larguraItem, this.cigarro.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if(desenhar == "Bebida") {
			this.jogo.lote.draw(this.bebida.getImagem(),this. bebida.getPosX(), this.bebida.getPosY(), this.bebida.larguraItem, this.bebida.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if(desenhar == "Parede") {
			this.jogo.lote.draw(this.parede.getImagem(),this. parede.getPosX(), this.parede.getPosY(), this.parede.larguraItem, this.parede.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if(desenhar == "Cama") {
			this.jogo.lote.draw(this.estante.getImagem(),this. estante.getPosX(), this.estante.getPosY(), this.estante.larguraItem, this.estante.alturaItem);
			this.jogo.lote.draw(this.armario.getImagem(),this. armario.getPosX(), this.armario.getPosY(), this.armario.larguraItem, this.armario.alturaItem);
			this.jogo.lote.draw(this.estante2.getImagem(),this. estante2.getPosX(), this.estante2.getPosY(), this.estante2.larguraItem, this.estante2.alturaItem);
			this.jogo.lote.draw(this.cama.getImagem(),this. cama.getPosX(), this.cama.getPosY(), this.cama.larguraItem, this.cama.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if (desenhar == "Remedio") {
			this.jogo.lote.draw(this.remedio.getImagem(),this. remedio.getPosX(), this.remedio.getPosY(), this.remedio.larguraItem, this.remedio.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if (desenhar == "Estante") {
			this.jogo.lote.draw(this.estante.getImagem(),this. estante.getPosX(), this.estante.getPosY(), this.estante.larguraItem, this.estante.alturaItem);
			this.jogo.lote.draw(this.estante2.getImagem(),this. estante2.getPosX(), this.estante2.getPosY(), this.estante2.larguraItem, this.estante2.alturaItem);
			this.jogo.lote.draw(this.cama.getImagem(),this. cama.getPosX(), this.cama.getPosY(), this.cama.larguraItem, this.cama.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		else if(desenhar == "Mesa") {
			this.jogo.lote.draw(this.mesa.getImagem(),this. mesa.getPosX(), this.mesa.getPosY(), this.mesa.larguraItem, this.mesa.alturaItem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
		this.jogo.lote.end();
	}

	public void sobreposicao(float deltaP, NPC npcP) {
		if( this.jogador.getPosY() >= npcP.getPosY()) {
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
			this.jogo.lote.draw(npcP.pegarImagem(deltaP), npcP.getPosX(), npcP.getPosY(), npcP.larguraPersonagem, npcP.alturaPersonagem);
		}
		else {
			this.jogo.lote.draw(npcP.pegarImagem(deltaP), npcP.getPosX(), npcP.getPosY(), npcP.larguraPersonagem, npcP.alturaPersonagem);
			this.jogo.lote.draw(this.jogador.pegarImagem(deltaP), this.jogador.getPosX(), this.jogador.getPosY(), this.jogador.larguraPersonagem, this.jogador.alturaPersonagem);
		}
	}

	public void threadStartado() {
		if (this.getStartadoMedico() == "n") {
			if (desenhar == "Medico") {
				this.threadMedico.start();
				this.setStartadoMedico("s");
			}
		}
		if(this.getStartadoLouco() == "n") {
			if (desenhar == "Paciente") {
				this.threadLouco.start();
				this.setStartadoLouco("s");
			}
		}
		if(this.getStartadoEnfermeiro() == "n") {
			if (desenhar == "Enfermeiro") {
				this.threadEnfermeiro.start();
				this.setStartadoEnfermeiro("s");
			}
		}
		if(this.getStartadoGuarda() == "n") {
			 if(desenhar == "Guarda") {
				this.threadGuarda.start();
				this.setStartadoGuarda("s");
			}
		}
		if(this.getStartadoJogador() == "n") {
			this.threadJogador.start();
			this.setStartadoJogador("s");
		}
		if (this.getStartadoMedico() == "s") {
			if (desenhar == "Medico") {
				this.medico.reposicionar();
				NPC.estaAndando = true;
				this.threadMedico.resume();
			}
		}
		if (this.getStartadoLouco() == "s") {
			if (desenhar == "Paciente") {
				this.louco.reposicionar();
				NPC.estaAndando = true;
				this.threadLouco.resume();
			}
		}
		if (this.getStartadoEnfermeiro() == "s"){
			if (desenhar == "Enfermeiro") {
				this.enfermeiro.reposicionar();
				NPC.estaAndando = true;
				this.threadEnfermeiro.resume();
			}
		}
		if (this.getStartadoGuarda() == "s") {
			if(desenhar == "Guarda") {
				this.guarda.reposicionar();
				NPC.estaAndando = true;
				this.threadGuarda.resume();
			}
		}
		if (this.getStartadoJogador() == "s") {
			this.direcaoYJogador = "Cima";
			this.jogador.reposicionar();
			this.threadJogador.resume();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void escolher() {
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT) && (this.seta.x == 150 || this.seta.x == 515)) {
			this.seta.x += 365;
		}
		if (Gdx.input.isKeyJustPressed(Keys.LEFT) && (this.seta.x == 515 || this.seta.x == 880)) {
			this.seta.x -= 365;
		}

		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.x == 150) {
			if (this.chegou_ao_fim) {
				this.setEstado(1);
			}
			else{
				this.desenhar = this.jogar.Consultar_Oque_Desenhar(1);
				this.setEstado(2);
			}
			this.threadStartado();
			this.jogar.Mostrar_opcoes(1);
			this.chegou_ao_fim = this.jogar.Consultar_texto();
			this.escolheu = true;
			//md.InserirDadosBanco(jogar);
			/*if (this.chegou_ao_fim == true) {
				md.DeletarDoBanco();
			}*/
		}
		else if (Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.x == 515) {
			if (this.chegou_ao_fim) {
				this.setEstado(1);
			}
			else{
				this.desenhar = this.jogar.Consultar_Oque_Desenhar(2);
				this.setEstado(2);
			}
			
			this.threadStartado();
			this.jogar.Mostrar_opcoes(2);
			this.chegou_ao_fim = this.jogar.Consultar_texto();
			this.escolheu = true;
			//md.InserirDadosBanco(jogar);
			/*if (this.chegou_ao_fim == true) {
				md.DeletarDoBanco();
			}*/
		}
		else if(Gdx.input.isKeyJustPressed(Keys.ENTER) && this.seta.x == 880) {
			if (this.chegou_ao_fim) {
				this.setEstado(1);
			}
			else{
				this.desenhar = this.jogar.Consultar_Oque_Desenhar(3);
				this.setEstado(2);
			}
			this.threadStartado();
			this.jogar.Mostrar_opcoes(3);
			this.chegou_ao_fim = this.jogar.Consultar_texto();			
			this.escolheu = true;
			//md.InserirDadosBanco(jogar);
			/*if (this.chegou_ao_fim == true) {
				md.DeletarDoBanco();
			}*/
		}
	}

	public void capturarMovimentosHeroi() {
		if(Gdx.input.isKeyPressed(Keys.DOWN) && !this.isTeclasOpostas())  {
			this.direcaoYJogador = "Baixo";
		}else if(Gdx.input.isKeyPressed(Keys.UP) && !this.isTeclasOpostas()) {
			this.direcaoYJogador = "Cima";
		}else {
			this.direcaoYJogador ="";
		}

		if(Gdx.input.isKeyPressed(Keys.LEFT) && !this.isTeclasOpostas()) {
			this.direcaoXJogador = "Esquerda";
		}
		else  if(Gdx.input.isKeyPressed(Keys.RIGHT) && !this.isTeclasOpostas()) {
			this.direcaoXJogador = "Direita";
		}
		else {
			this.direcaoXJogador ="";
		}

		if ((Gdx.input.isKeyPressed(Keys.LEFT) && Gdx.input.isKeyPressed(Keys.RIGHT)) || Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.DOWN)){
			this.setTeclasOpostas(true);
		}
		else {
			this.setTeclasOpostas(false);
		}

		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			if (desenhar == "Medico") {
				this.interagirNPC(medico);
			}
			else if(desenhar == "Paciente") {
				this.interagirNPC(louco);
			}

			else if(desenhar == "Porta") {
				this.interagirObjetos(porta);
			}
			else if(desenhar == "Enfermeiro") {
				this.interagirNPC(enfermeiro);

			}
			else if(desenhar == "Cafe") {
				this.interagirObjetos(cafe);
			}
			else if(desenhar == "Guarda") {
				this.interagirNPC(guarda);

			}
			else if(desenhar == "Cigarro") {
				this.interagirObjetos(cigarro);
			}
			else if(desenhar == "Bebida") {
				this.interagirObjetos(bebida);
			}
			else if(desenhar == "Parede") {
				this.interagirObjetos(parede);
			}
			else if(desenhar == "Cama") {
				this.interagirObjetos(cama);
			}
			else if (desenhar == "Remedio") {
				this.interagirObjetos(remedio);
			}
			else if (desenhar == "Estante") {
				this.interagirObjetos(estante);
			}
			else if(desenhar == "Mesa") {
				this.interagirObjetos(mesa);
			}
		}

	}

	public void interagirObjetos(Objetos objetosP) {
		if(jogador.getColisao().colideCom(objetosP.getColisao())) {
			this.setEstado(1);
			this.threadJogador.suspend();
		}
	}

	public void interagirNPC(NPC npcP) {
		if(jogador.getColisao().colideCom(npcP.getColisao())) {
			this.setEstado(1);
			if (desenhar == "Medico") {
				this.threadMedico.suspend();
			}
			else if (desenhar == "Paciente") {
				this.threadLouco.suspend();
			}
			else if (desenhar == "Enfermeiro") {
				this.threadEnfermeiro.suspend();
			}
			else if(desenhar == "Guarda") {
				this.threadGuarda.suspend();
			}
			this.threadJogador.suspend();
		}
	}

	public void retornarMenu() {
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			if (desenhar == "Medico") {
				this.threadMedico.suspend();
			}
			else if (desenhar == "Paciente") {
				this.threadLouco.suspend();
			}
			else if (desenhar == "Enfermeiro") {
				this.threadEnfermeiro.suspend();
			}
			else if(desenhar == "Guarda") {
				this.threadGuarda.suspend();
			}
			this.threadJogador.suspend();
			//md.TemDadosNoBanco();
			this.jogo.setScreen(new MenuTela(jogo));
		}
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		if (this.getEstado() == 1) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			this.desenharEscolhas();
			if (this.escolheu == false) {
				this.escolher();
			}
		}
		else {
			this.capturarMovimentosHeroi();
			this.louco.setDelta(delta);
			this.jogador.setDelta(delta);
			//this.jogador.colidiu(louco.getColisao());

			this.desenharIteratividade(delta);
		}
		this.retornarMenu();
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
		this.jogo.lote.dispose();
		this.jogo.fonte.dispose();
	}

}