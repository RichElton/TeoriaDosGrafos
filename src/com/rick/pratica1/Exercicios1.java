package com.rick.pratica1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

/**
 * Classe respons�vel pela resolu��o da quest�o 1(1� lista de exer�cios praticas) da disciplina
 * Teoria dos grafos.
 * 
 * @author Rich Elton - 117210710
 *
 */
public class Exercicios1 {

	/**
	 * M�todo principal.
	 * 
	 * @param args : Nunca � usado.
	 */
	public static void main(String[] args) {
		
		/**
		 * Chamo a fun��o que vai criar e retornar meu grafo.
		 */
		Graph<String, DefaultEdge> grafo = criarGrafo();
		
		/**
		 * Chama a fun��o que vai procurar minha matriz de incid�ncia.
		 */
		achaMatrizIncidencia(grafo);
	}
	
	/**
	 * M�todo que vai achar minha matriz incid�ncia de um grafo.
	 * 
	 * @param g : Grafo na qual eu quero achar a matriz de incid�ncia.
	 */
	private static void achaMatrizIncidencia(Graph<String, DefaultEdge> g) {
		
		/**
		 * Lista de arestas.
		 */
		Set<DefaultEdge> arestas = g.edgeSet();
		
		/**
		 * Lista dos vertices.
		 */
		Set<String> vertices = g.vertexSet();
		
		
		List<String> listaVertices = new ArrayList<String>();
		Iterator<String> it = vertices.iterator();
		
		/**
		 * Pego todos os meus vertices e coloco dentro da minha listaVertices.
		 */
		while(it.hasNext()) {
			listaVertices.add(it.next());
		}
		
		Iterator<DefaultEdge> iterator = arestas.iterator();
		Collections.sort(listaVertices);
		
		/**
		 * Fun��o que vai imprimir minha matriz.
		 */
		constroiMatriz(g, listaVertices, iterator);
		
	}
	
	/**
	 * M�todo que vai imprimir minha matriz de incid�ncia.
	 * @param g : Graph<String, DefaultEdge>.
	 * @param listaVertices : List<String>.
	 * @param iterator : Iterator<DefaultEdge>.
	 */
	private static void constroiMatriz(Graph<String, DefaultEdge> g, List<String> listaVertices,
			Iterator<DefaultEdge> iterator) {
		
		List<DefaultEdge> arestas = new ArrayList<DefaultEdge>();
		/**
		 * Adiciono todas as arestas do meu grafo.
		 */
		while(iterator.hasNext()) {
			arestas.add(iterator.next());
		}
		
		/**
		 * Imprimo o inicio e o fim de cada aresta do meu grafo.
		 */
		for(DefaultEdge aresta : g.edgeSet()) {
			String inicio = g.getEdgeSource(aresta);
			String fim = g.getEdgeTarget(aresta);
			System.out.print("  |" + inicio+fim);
		}
		System.out.println("");
		
		/**
		 * Pego cada vertice e cada aresta(inicio e fim) e comparo se um dos terminais da
		 * aresta � igual ao meu vertice.
		 * Se for, imprimo "1", caso contr�rio imprimo "0".
		 */
		for(String v : listaVertices) {
			System.out.print(v + " |");
			for(DefaultEdge aresta : arestas) {
				String inicio = g.getEdgeSource(aresta);
				String fim = g.getEdgeTarget(aresta);
				if(inicio.equals(v) || fim.equals(v)) {
					System.out.print(" 1  |");
				} else {
					System.out.print(" 0  |");
				}
			}
			System.out.println("");
		}
	}

	/**
	 * M�todo que ir� criar um grafo.
	 * 
	 * @return : Um grafo(Graph<String, DefaultEdge>)
	 */
	public static Graph<String, DefaultEdge> criarGrafo(){
		
		Graph<String, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
		
		grafo.addVertex("a");	grafo.addVertex("b");	grafo.addVertex("c");
		grafo.addVertex("d");	grafo.addVertex("e");   grafo.addVertex("f");
		
		grafo.addEdge("a", "b");	grafo.addEdge("a", "b");
		grafo.addEdge("b", "c");	grafo.addEdge("b", "d");	grafo.addEdge("b", "e");
		grafo.addEdge("c", "e");	grafo.addEdge("c", "d");
		grafo.addEdge("e", "d");	grafo.addEdge("d", "f");	grafo.addEdge("e", "f");
		return grafo;
	}
}