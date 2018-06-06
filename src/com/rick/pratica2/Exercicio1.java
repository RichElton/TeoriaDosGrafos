package com.rick.pratica2;

import java.io.*;

/**
 * Classe responsavel pela resposta da questao 1 da pratica 2 de grafo.
 * 
 * @author Rich Elton
 *
 */
public class Exercicio1 {

	/**
	 * Atributo estatico que vai escrever a resposta no meu arquivo de texto da questão.
	 */
	private static BufferedWriter principal;
	
	/**
	 * Método principal da minha classe.
	 * 
	 * @param args Não é utilizada.
	 * @throws IOException Caso aconteça alguma exceção na escrita do meu arquivo.
	 */
	public static void main(String[] args) throws IOException {
		
		// Caminho do meu arquivo.
		String caminho = new File("").getAbsolutePath()+"/arquivos/pratica2-ex1.txt";
		principal = new BufferedWriter(new FileWriter(caminho));
		
		// Inicio da questao 1.
		String inicio = "Questão 1 da pratica 2 de grafos: " + caminho;
		System.out.println(inicio);
		
		//Resposta da minha questao 1.
		principal.write(inicio+"\n");
		String resposta = "\nO melhor layout para a visualização do grafo da planilha 'airlineAA.xlsx' é " +
						  "o layout circular, pois além de facilitar a visualização do grafo, facilita também " +
						  "para ver quais os aeroportos chegam em outros aeroportos e quais os caminhos possivéis " + 
						  "e os menores caminhos, assim podendo visualizar qual o melhor trajeto saindo de um determinado "+
						  "aeroporto para outro.";
		principal.write(resposta);
		principal.close();
	}
}
