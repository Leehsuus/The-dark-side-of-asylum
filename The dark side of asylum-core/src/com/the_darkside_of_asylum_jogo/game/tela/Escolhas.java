package com.the_darkside_of_asylum_jogo.game.tela;

import java.util.ArrayList;
//import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Escolhas {
		String[][] matriz = new String[55][9];
		String nome_escolha;
		int numero_escolha;
		public String texto_escolha;
		ArrayList<Texture> imagens_escolhas = new ArrayList<Texture>();		
		public Texture texto_aux;
        
	public Escolhas() {
			this.nome_escolha = "Vazio";
			texto_aux = new Texture(Gdx.files.internal("/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/1.png"));
			texto_escolha = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/1.png";
			this.numero_escolha = 0;
			this.matriz [0][0] = this.nome_escolha;
			this.matriz [0][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/1.png";
			this.matriz [0][2] = "Interrogar os medicos";
			this.matriz [0][3] = "Interrogar os pacientes";
			this.matriz [0][4] = "Vasculhar o prédio";
			this.matriz [0][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [0][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/1-1.png";
			this.matriz [0][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/1-3.png";
			this.matriz [0][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/3-1.png";
			
			this.matriz [1][0] = "Interrogar os medicos";
			this.matriz [1][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/2.png";
			this.matriz [1][2] = "Ir até o quarto da vítima";
			this.matriz [1][3] = "Interrogar os pacientes";
			this.matriz [1][4] = "Continuar investigando os médicos";
			this.matriz [1][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [1][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/1-2.png";
			this.matriz [1][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/1-3.png";
			this.matriz [1][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-3.png";
			
			this.matriz [2][0] = "Ir até o quarto da vítima";
			this.matriz [2][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/3.png";
			this.matriz [2][2] = "Falar com os enfermeiros";
			this.matriz [2][3] = "Ir até o paciente";
			this.matriz [2][4] = "Vasculhar o prédio";
			this.matriz [2][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [2][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-2.png";
			this.matriz [2][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-3.png";
			this.matriz [2][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/3-1.png";
			
			this.matriz [3][0] = "Interrogar os pacientes";
			this.matriz [3][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/4.png";
			this.matriz [3][2] = "Falar com os enfermeiros";
			this.matriz [3][3] = "Ir até o paciente";
			this.matriz [3][4] = "Vasculhar o prédio";
			this.matriz [3][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [3][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-2.png";
			this.matriz [3][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-3.png";
			this.matriz [3][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/3-1.png";
			
			this.matriz [4][0] = "Continuar investigando os médicos";
			this.matriz [4][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/5.png";
			this.matriz [4][2] = "Falar com os enfermeiros";
			this.matriz [4][3] = "Ir até o paciente";
			this.matriz [4][4] = "Vasculhar o prédio";
			this.matriz [4][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [4][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-2.png";
			this.matriz [4][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-3.png";
			this.matriz [4][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/3-1.png";
			
			this.matriz [5][0] = "Falar com os enfermeiros";
			this.matriz [5][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/6.png";
			this.matriz [5][2] = "Vasculhar o prédio";
			this.matriz [5][3] = "Ir até o paciente";
			this.matriz [5][4] = "Ir até o paciente";
			this.matriz [5][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [5][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/3-1.png";
			this.matriz [5][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-3.png";
			this.matriz [5][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/2-3.png";
			
			this.matriz [6][0] = "Ir até o paciente";
			this.matriz [6][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/7.png";
			this.matriz [6][2] = "Dar um gole no café";
			this.matriz [6][3] = "Sair da sala por um momento";
			this.matriz [6][4] = "Falar para os guardas o manterem preso";
			this.matriz [6][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [6][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/3-2.png";
			this.matriz [6][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/3-3.png";
			this.matriz [6][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/4-1.png";
			
			this.matriz [7][0] = "Vasculhar o prédio";
			this.matriz [7][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/8.png";
			this.matriz [7][2] = "Ir na ala dos pacientes para observa-lós";
			this.matriz [7][3] = "Entrar no quarto da vítima";
			this.matriz [7][4] = "Ir na ala dos enfermeiros";
			this.matriz [7][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [7][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-3.png";
			this.matriz [7][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-1.png";
			this.matriz [7][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-3.png";
			
			this.matriz [8][0] = "Dar um gole no café";
			this.matriz [8][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/9.png";
			this.matriz [8][2] = "Fumar";
			this.matriz [8][3] = "Beber uma dose de whisky";
			this.matriz [8][4] = "Socar a parede";
			this.matriz [8][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [8][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/4-2.png";
			this.matriz [8][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/4-3.png";
			this.matriz [8][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-1.png";
			
			this.matriz [9][0] = "Sair da sala por um momento";
			this.matriz [9][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/10.png";
			this.matriz [9][2] = "Fumar";
			this.matriz [9][3] = "Beber uma dose de whisky";
			this.matriz [9][4] = "Socar a parede";
			this.matriz [9][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [9][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/4-2.png";
			this.matriz [9][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/4-3.png";
			this.matriz [9][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-1.png";
			
			this.matriz [10][0] = "Falar para os guardas o manterem preso";
			this.matriz [10][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/11.png";
			this.matriz [10][2] = "Ir até o quarto dele";
			this.matriz [10][3] = "Ir até o quarto dele";
			this.matriz [10][4] = "Ir até o quarto dele";
			this.matriz [10][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [10][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			this.matriz [10][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			this.matriz [10][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			
			this.matriz [11][0] = "Fumar";
			this.matriz [11][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/12.png";
			this.matriz [11][2] = "Fazer perguntas sobre o passado dele";
			this.matriz [11][3] = "Ir até o quarto dele";
			this.matriz [11][4] = "Ameaça-lo";
			this.matriz [11][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [11][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-3.png";
			this.matriz [11][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			this.matriz [11][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-2.png";
			
			this.matriz [12][0] = "Beber uma dose de whisky";
			this.matriz [12][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/13.png";
			this.matriz [12][2] = "Fazer perguntas sobre o passado dele";
			this.matriz [12][3] = "Ir até o quarto dele";
			this.matriz [12][4] = "Ameaça-lo";
			this.matriz [12][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [12][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-3.png";
			this.matriz [12][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			this.matriz [12][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-2.png";
			
			this.matriz [13][0] = "Socar a parede";
			this.matriz [13][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/14.png";
			this.matriz [13][2] = "Ameaça-lo";
			this.matriz [13][3] = "Ameaça-lo";
			this.matriz [13][4] = "Ameaça-lo";
			this.matriz [13][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [13][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-2.png";
			this.matriz [13][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-2.png";
			this.matriz [13][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/5-2.png";
			
			this.matriz [14][0] = "Ameaça-lo";
			this.matriz [14][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/15.png";
			this.matriz [14][2] = "Ir até o quarto dele";
			this.matriz [14][3] = "Ir até o quarto dele";
			this.matriz [14][4] = "Ir até o quarto dele";
			this.matriz [14][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [14][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			this.matriz [14][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			this.matriz [14][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-1.png";
			
			this.matriz [15][0] = "Fazer perguntas sobre o passado dele";
			this.matriz [15][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/16.png";
			this.matriz [15][2] = "Fumar um cigarro";
			this.matriz [15][3] = "Tentar dormir";
			this.matriz [15][4] = "Beber";
			this.matriz [15][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [15][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-2.png";
			this.matriz [15][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-3.png";
			this.matriz [15][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-1.png";
			
			this.matriz [16][0] = "Ir até o quarto dele";
			this.matriz [16][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/17.png";
			this.matriz [16][2] = "Você pega um frasco de remédio";
			this.matriz [16][3] = "Você pega um frasco de remédio";
			this.matriz [16][4] = "Você pega um frasco de remédio";
			this.matriz [16][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [16][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-2.png";
			this.matriz [16][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-2.png";
			this.matriz [16][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-2.png";
			
			this.matriz [17][0] = "Fumar um cigarro";
			this.matriz [17][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/18.png";
			this.matriz [17][2] = "Visitar a ala dos enfermeiros";
			this.matriz [17][3] = "Dar uma volta nos arredores do prédio";
			this.matriz [17][4] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [17][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [17][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-3.png";
			this.matriz [17][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-1.png";
			this.matriz [17][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-2.png";
			
			this.matriz [18][0] = "Tentar dormir";
			this.matriz [18][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/19.png";
			this.matriz [18][2] = "Visitar a ala dos enfermeiros";
			this.matriz [18][3] = "Dar uma volta nos arredores do prédio";
			this.matriz [18][4] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [18][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [18][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-3.png";
			this.matriz [18][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-1.png";
			this.matriz [18][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-2.png";
			
			this.matriz [19][0] = "Beber";
			this.matriz [19][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/20.png";
			this.matriz [19][2] = "Parte pra cima dele";
			this.matriz [19][3] = "Parte pra cima dele";
			this.matriz [19][4] = "Tentar ser racional em um lampejo de sanidade e tentar conversar";
			this.matriz [19][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [19][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-3.png";
			this.matriz [19][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-3.png";
			this.matriz [19][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/9-1.png";
			
			this.matriz [20][0] = "Você pega um frasco de remédio";
			this.matriz [20][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/21.png";
			this.matriz [20][2] = "Tentar dormir";
			this.matriz [20][3] = "Beber";
			this.matriz [20][4] = "Tomar remédios";
			this.matriz [20][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [20][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/6-3.png";
			this.matriz [20][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-1.png";
			this.matriz [20][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			
			this.matriz [21][0] = "Visitar a ala dos enfermeiros";
			this.matriz [21][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/22.png";
			this.matriz [21][2] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [21][3] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [21][4] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [21][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [21][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-2.png";
			this.matriz [21][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-2.png";
			this.matriz [21][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-2.png";
			
			this.matriz [22][0] = "Dar uma volta nos arredores do prédio";
			this.matriz [22][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/23.png";
			this.matriz [22][2] = "Pegando o frasco de remédio na cabeceira e colocando no bolso";
			this.matriz [22][3] = "Pegando o frasco de remédio na cabeceira e colocando no bolso";
			this.matriz [22][4] = "Ignorando o frasco de remédio";
			this.matriz [22][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [22][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/9-3.png";
			this.matriz [22][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/9-3.png";
			this.matriz [22][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/10-1.png";
			
			this.matriz [23][0] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [23][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/24.png";
			this.matriz [23][2] = "Tenta convencer o assassino a falar sobre o corpo";
			this.matriz [23][3] = "Volta pra ilha com uma equipe de busca";
			this.matriz [23][4] = "Resolve visitar seu bar favorito";
			this.matriz [23][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [23][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/10-2.png";
			this.matriz [23][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/10-3.png";
			this.matriz [23][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-1.png";
			
			this.matriz [24][0] = "Parte pra cima dele";
			this.matriz [24][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/25.png";
			this.matriz [24][2] = "Se dirige até ele e se senta ao seu lado";
			this.matriz [24][3] = "Se dirige ao guarda que estava cuidando do refeitório para fazer perguntas sobre a rotina do suspeito";
			this.matriz [24][4] = "Se senta em uma mesa próxima ao suspeito na expectativa de perceber alguma coisa estranha";
			this.matriz [24][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [24][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-2.png";
			this.matriz [24][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-3.png";
			this.matriz [24][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-2.png";
			
			this.matriz [25][0] = "Tentar ser racional em um lampejo de sanidade e tentar conversar";
			this.matriz [25][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/26.png";
			this.matriz [25][2] = "Se dirige até ele e se senta ao seu lado";
			this.matriz [25][3] = "Se dirige ao guarda que estava cuidando do refeitório para fazer perguntas sobre a rotina do suspeito";
			this.matriz [25][4] = "Se senta em uma mesa próxima ao suspeito na expectativa de perceber alguma coisa estranha";
			this.matriz [25][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [25][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-2.png";
			this.matriz [25][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-3.png";
			this.matriz [25][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-2.png";
			
			this.matriz [26][0] = "Tomar remédios";
			this.matriz [26][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/27.png";
			this.matriz [26][2] = "Parte pra cima dele";
			this.matriz [26][3] = "Parte pra cima dele";
			this.matriz [26][4] = "Tentar ser racional em um lampejo de sanidade e tentar conversar";
			this.matriz [26][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [26][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-3.png";
			this.matriz [26][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-3.png";
			this.matriz [26][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/9-1.png";
			
			this.matriz [27][0] = "Pegando o frasco de remédio na cabeceira e colocando no bolso";
			this.matriz [27][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/28.png";
			this.matriz [27][2] = "Resolve tomar os remédios que havia encontrado";
			this.matriz [27][3] = "Vai até os médicos fazer mais perguntas sobre a vítima";
			this.matriz [27][4] = "Vai até o suspeito";
			this.matriz [27][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [27][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [27][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/12-1.png";
			this.matriz [27][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/12-2.png";
			
			this.matriz [28][0] = "Ignorando o frasco de remédio";
			this.matriz [28][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/29.png";
			this.matriz [28][2] = "Vai encher a cara";
			this.matriz [28][3] = "Vai até os médicos fazer mais perguntas sobre a vítima";
			this.matriz [28][4] = "Vai até o suspeito";
			this.matriz [28][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [28][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/12-3.png";
			this.matriz [28][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/12-1.png";
			this.matriz [28][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/12-2.png";
			
			this.matriz [29][0] = "Tenta convencer o assassino a falar sobre o corpo";
			this.matriz [29][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/30.png";
			this.matriz [29][2] = "";
			this.matriz [29][3] = "";
			this.matriz [29][4] = "";
			
			this.matriz [30][0] = "Volta pra ilha com uma equipe de busca";
			this.matriz [30][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/31.png";
			this.matriz [30][2] = "";
			this.matriz [30][3] = "";
			this.matriz [30][4] = "";
			
			this.matriz [31][0] = "Resolve visitar seu bar favorito";
			this.matriz [31][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/32.png";
			this.matriz [31][2] = "";
			this.matriz [31][3] = "";
			this.matriz [31][4] = "";
			
			this.matriz [32][0] = "Se dirige até ele e se senta ao seu lado";
			this.matriz [32][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/33.png";
			this.matriz [32][2] = "Guarda o frasco";
			this.matriz [32][3] = "Guarda o frasco";
			this.matriz [32][4] = "Guarda o frasco";
			this.matriz [32][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [32][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			this.matriz [32][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			this.matriz [32][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			
			this.matriz [33][0] = "Se dirige ao guarda que estava cuidando do refeitório para fazer perguntas sobre a rotina do suspeito";
			this.matriz [33][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/34.png";
			this.matriz [33][2] = "Guarda o frasco";
			this.matriz [33][3] = "Guarda o frasco";
			this.matriz [33][4] = "Guarda o frasco";
			this.matriz [33][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [33][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			this.matriz [33][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			this.matriz [33][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			
			this.matriz [34][0] = "Se senta em uma mesa próxima ao suspeito na expectativa de perceber alguma coisa estranha";
			this.matriz [34][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/35.png";
			this.matriz [34][2] = "Guarda o frasco";
			this.matriz [34][3] = "Guarda o frasco";
			this.matriz [34][4] = "Guarda o frasco";
			this.matriz [34][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [34][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			this.matriz [34][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			this.matriz [34][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			
			this.matriz [35][0] = "Resolve tomar os remédios que havia encontrado";
			this.matriz [35][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/36.png";
			this.matriz [35][2] = "";
			this.matriz [35][3] = "";
			this.matriz [35][4] = "";
			
			this.matriz [36][0] = "Vai até os médicos fazer mais perguntas sobre a vítima";
			this.matriz [36][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/37.png";
			this.matriz [36][2] = "";
			this.matriz [36][3] = "";
			this.matriz [36][4] = "";
			
			this.matriz [37][0] = "Vai até o suspeito";
			this.matriz [37][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/37.png";
			this.matriz [37][2] = "";
			this.matriz [37][3] = "";
			this.matriz [37][4] = "";
			
			this.matriz [38][0] = "Vai encher a cara";
			this.matriz [38][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/38.png";
			this.matriz [38][2] = "";
			this.matriz [38][3] = "";
			this.matriz [38][4] = "";
			
			this.matriz [39][0] = "Guarda o frasco";
			this.matriz [39][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/39.png";
			this.matriz [39][2] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [39][3] = "Resolve tomar os remédios que havia encontrado";
			this.matriz [39][4] = "Dar uma volta nos arredores";
			this.matriz [39][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [39][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-2.png";
			this.matriz [39][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [39][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-2.png";
			
			this.matriz [40][0] = "Dar uma volta nos arredores";
			this.matriz [40][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/40.png";
			this.matriz [40][2] = "Procurar novas evidências no quarto do paciente suspeito";
			this.matriz [40][3] = "Resolve tomar os remédios que havia encontrado";
			this.matriz [40][4] = "Resolve tomar os remédios que havia encontrado";
			this.matriz [40][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [40][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/8-2.png";
			this.matriz [40][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [40][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			
			this.matriz [41][0] = "Ir na ala dos pacientes para observa-lós";
			this.matriz [41][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/41.png";
			this.matriz [41][2] = "Entrar no quarto da vítima";
			this.matriz [41][3] = "Entrar no quarto da vítima";
			this.matriz [41][4] = "Entrar no quarto da vítima";
			this.matriz [41][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [41][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-1.png";
			this.matriz [41][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-1.png";
			this.matriz [41][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-1.png";
			
			this.matriz [42][0] = "Entrar no quarto da vítima";
			this.matriz [42][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/42.png";
			this.matriz [42][2] = "Toma alguns comprimidos";
			this.matriz [42][3] = "Toma alguns comprimidos";
			this.matriz [42][4] = "Guarda o remédio como evidência";
			this.matriz [42][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [42][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [42][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [42][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-2.png";
			
			this.matriz [43][0] = "Ir na ala dos enfermeiros";
			this.matriz [43][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/43.png";
			this.matriz [43][2] = "Toma alguns comprimidos";
			this.matriz [43][3] = "Toma alguns comprimidos";
			this.matriz [43][4] = "Guarda o remédio como evidência";
			this.matriz [43][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [43][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [43][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [43][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-2.png";
			
			this.matriz [44][0] = "Toma alguns comprimidos";
			this.matriz [44][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/44.png";
			this.matriz [44][2] = "Você toma o remédio";
			this.matriz [44][3] = "Você toma o remédio";
			this.matriz [44][4] = "Guardar";
			this.matriz [44][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [44][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [44][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-1.png";
			this.matriz [44][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/13-1.png";
			
			this.matriz [45][0] = "Guarda o remédio como evidência";
			this.matriz [45][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/45.png";
			this.matriz [45][2] = "Interrogar pacientes";
			this.matriz [45][3] = "Interrogar pacientes";
			this.matriz [45][4] = "Interrogar pacientes";
			this.matriz [45][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [45][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-1.png";
			this.matriz [45][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-1.png";
			this.matriz [45][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-1.png";
			
			this.matriz [46][0] = "Você toma o remédio";
			this.matriz [46][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/46.png";
			this.matriz [46][2] = "Tomar mais alguns comprimidos";
			this.matriz [46][3] = "Tomar mais alguns comprimidos";
			this.matriz [46][4] = "Tomar mais alguns comprimidos";
			this.matriz [46][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [46][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-2.png";
			this.matriz [46][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-2.png";
			this.matriz [46][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-2.png";
			
			this.matriz [47][0] = "Guardar";
			this.matriz [47][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/47.png";
			this.matriz [47][2] = "Ameaçar ele";
			this.matriz [47][3] = "Pressioná-lo";
			this.matriz [47][4] = "Interrogá-lo com mais cautela";
			this.matriz [47][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [47][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/15-3.png";
			this.matriz [47][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/16-1.png";
			this.matriz [47][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/16-3.png";
		
			this.matriz [48][0] = "Tomar mais alguns comprimidos";
			this.matriz [48][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/48.png";
			this.matriz [48][2] = "Os pega";
			this.matriz [48][3] = "Os pega";
			this.matriz [48][4] = "Os pega";
			this.matriz [48][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [48][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/16-2.png";
			this.matriz [48][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/16-2.png";
			this.matriz [48][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/16-2.png";
			
			this.matriz [49][0] = "Os pega";
			this.matriz [49][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/49.png";
			this.matriz [49][2] = "";
			this.matriz [49][3] = "";
			this.matriz [49][4] = "";
			
			this.matriz [50][0] = "Ameaçar ele";
			this.matriz [50][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/50.png";
			this.matriz [50][2] = "Beber";
			this.matriz [50][3] = "Beber";
			this.matriz [50][4] = "Tomar mais remédios";
			this.matriz [50][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [50][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-1.png";
			this.matriz [50][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/7-1.png";
			this.matriz [50][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-2.png";
			
			this.matriz [51][0] = "Pressioná-lo";
			this.matriz [51][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/51.png";
			this.matriz [51][2] = "Se dirige até ele e se senta ao seu lado";
			this.matriz [51][3] = "Se dirige ao guarda que estava cuidando do refeitório para fazer perguntas sobre a rotina do suspeito";
			this.matriz [51][4] = "Se senta em uma mesa próxima ao suspeito na expectativa de perceber alguma coisa estranha";
			this.matriz [51][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [51][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-2.png";
			this.matriz [51][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-3.png";
			this.matriz [51][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-2.png";
			
			this.matriz [52][0] = "Interrogá-lo com mais cautela";
			this.matriz [52][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/52.png";
			this.matriz [52][2] = "Se dirige até ele e se senta ao seu lado";
			this.matriz [52][3] = "Se dirige ao guarda que estava cuidando do refeitório para fazer perguntas sobre a rotina do suspeito";
			this.matriz [52][4] = "Se senta em uma mesa próxima ao suspeito na expectativa de perceber alguma coisa estranha";
			this.matriz [52][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [52][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-2.png";
			this.matriz [52][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/11-3.png";
			this.matriz [52][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-2.png";
			
			this.matriz [53][0] = "Tomar mais remédios";
			this.matriz [53][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/53.png";
			this.matriz [53][2] = "";
			this.matriz [53][3] = "";
			this.matriz [53][4] = "";
			
			this.matriz [54][0] = "Interrogar pacientes";
			this.matriz [54][1] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Textos/54.png";
			this.matriz [54][2] = "Ir até o quarto da vítima";
			this.matriz [54][3] = "Interrogar os pacientes";
			this.matriz [54][4] = "Continuar investigando os médicos";
			this.matriz [54][5] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Cenarios/preto.png";
			this.matriz [54][6] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/14-1.png";
			this.matriz [54][7] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-1.png";
			this.matriz [54][8] = "/home/leticia/git/The-dark-side-of-asylum/The dark side of asylum-core/assets/Imagens/Escolhas/17-3.png";
			
		}
        
		public ArrayList<Texture> Ponto_decisao(){
			int l = this.numero_escolha;
			if (l < this.matriz.length) {
				//System.out.println(this.matriz[this.numero_escolha][1]);
			}
			for (int i = 5; i < 9; i++) {
            	Texture botao_aux;
            	botao_aux = Consultar_imagem(this.matriz[this.numero_escolha][i]);
            	this.imagens_escolhas.add(botao_aux);
            }
			return this.imagens_escolhas;
         }

        public void Mostrar_opcoes(int numero_escolha){
        	this.imagens_escolhas.clear();
            for (int c = 2; c < 5; c++){
                //System.out.println((c-1) + ": " + this.matriz[this.numero_escolha][c]);
            }
            this.nome_escolha = this.matriz [this.numero_escolha][numero_escolha + 1];
        }      
        
        public Texture Consultar_imagem(String local_file) {
        	Texture botao;
        	botao = new Texture(Gdx.files.internal(local_file));
        	return botao;
        }      
        
        public boolean Consultar_texto(){
            for (int l = 0; l <this.matriz.length; l ++){
                if (this.matriz[l][0] == this.nome_escolha){
                    this.texto_escolha = this.matriz[l][1];
                    texto_aux = Consultar_imagem(this.texto_escolha);
                    this.numero_escolha = l;
                    break;
                }
            
            }
            
            if(matriz[this.numero_escolha][2] == ""){
                System.out.println(this.texto_escolha);
                return true;
            }
            else{
                return false;
            }
        }
    }
