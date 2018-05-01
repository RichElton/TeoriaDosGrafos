package com.rick.pratica1;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 * Classe responsável por resolver a questão 2(1º lista de exerício pratica) da disciplina
 * de teoria dos grafos.
 * 
 * @author Rich Elton - 117210710
 *
 */
public class Exercicio2 {
	
	/**
	 * Método principal.
	 * 
	 * @param args : Nunca é usada.
	 */
	public static void main(String[] args) {
		
		/**
		 * Crio o grafo ponderado.
		 */
		SimpleWeightedGraph<String, DefaultWeightedEdge> grafo = criandoGrafo();
		
		/**
		 * Algoritmo que retorna o menor caminho.
		 */
		DijkstraShortestPath<String, DefaultWeightedEdge> path = new DijkstraShortestPath<>(grafo);
		GraphPath<String, DefaultWeightedEdge> menorCaminho = path.getPath("a", "d");
		
		System.out.println("Menor Caminho: " + menorCaminho.toString());
		System.out.println("Quantidade de arestas: " + menorCaminho.getLength());
		System.out.println("Valor caminho: " + menorCaminho.getWeight());
	}

	/**
	 * Método que cria o grafo correspondente no exercício 2.
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