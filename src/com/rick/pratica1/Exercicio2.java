package com.rick.pratica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 * Classe respons�vel por resolver a quest�o 2(1� lista de exer�cio pratica) da disciplina
 * de teoria dos grafos.
 * 
 * @author Rich Elton - 117210710
 *
 */
public class Exercicio2 {
	
	/**
	 * M�todo principal.
	 * 
	 * @param args : Nunca � usada.
	 */
	public static void main(String[] args) throws Exception{
		
		/**
		 * Crio o grafo ponderado.
		 */
		SimpleWeightedGraph<String, DefaultWeightedEdge> grafo = criandoGrafo();
		
		/**
		 * Algoritmo que retorna o menor caminho.
		 */
		DijkstraShortestPath<String, DefaultWeightedEdge> path = new DijkstraShortestPath<>(grafo);
		GraphPath<String, DefaultWeightedEdge> menorCaminho = path.getPath("a", "d");
		
		String caminho = new File("").getAbsolutePath()+"/arquivos/exercicio2.txt";
		FileWriter fl = new FileWriter(caminho);
		BufferedWriter bw = new BufferedWriter(fl);
		
		bw.write("Distância de 'a' --> 'd': \n");
		bw.newLine();
		bw.write("Menor Caminho: " + menorCaminho.toString());
		bw.newLine();
		bw.write("Quantidade de arestas: " + menorCaminho.getLength());
		bw.newLine();
		bw.write("Valor caminho: " + menorCaminho.getWeight());
		bw.close();
		fl.close();
		
		System.out.println("Terminou!");
		System.out.println("Verifique o arquivo 'exercicio2.txt' na pasta arquivos.");
	}

	/**
	 * M�todo que cria o grafo correspondente no exerc�cio 2.
	 * 
	 * @return : Um grafo ponderado(SimpleWeightedGraph<String, DefaultWeightedEdge>).
	 */
	private static SimpleWeightedGraph<String, DefaultWeightedEdge> criandoGrafo() {
		
		SimpleWeightedGraph<String, DefaultWeightedEdge> g = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		g.addVertex("a");	g.addVertex("b");	g.addVertex("c");
		g.addVertex("d");	g.addVertex("e");	g.addVertex("f");
		g.addVertex("g");	g.addVertex("h");	g.addVertex("i");
		
		g.setEdgeWeight(g.addEdge("a","b"),2);
		g.setEdgeWeight(g.addEdge("b","c"),4);
		g.setEdgeWeight(g.addEdge("d","e"),1);
		g.setEdgeWeight(g.addEdge("e","f"),6);
		g.setEdgeWeight(g.addEdge("f","a"),7);
		g.setEdgeWeight(g.addEdge("a","g"),3);
		g.setEdgeWeight(g.addEdge("c","d"),2);
		g.setEdgeWeight(g.addEdge("g","i"),1);
		g.setEdgeWeight(g.addEdge("g","b"),6);
		g.setEdgeWeight(g.addEdge("h","c"),2);
		g.setEdgeWeight(g.addEdge("g","h"),3);
		g.setEdgeWeight(g.addEdge("h","i"),4);
		g.setEdgeWeight(g.addEdge("i","f"),5);
		g.setEdgeWeight(g.addEdge("h","d"),8);
		g.setEdgeWeight(g.addEdge("i","e"),2);
		return g;
	}
}