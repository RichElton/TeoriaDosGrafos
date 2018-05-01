package com.rick.pratica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

/**
 * Classe responsável pela resolução da questão 1(1º lista de exerício pratica) da disciplina
 * Teoria dos grafos.
 * 
 * @author Rich Elton - 117210710
 *
 */
public class Exercicio1 {

	/**
	 * Método principal.
	 * 
	 * @param args : Nunca é usado.
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * Chamo a função que vai criar e retornar meu grafo.
		 */
		Graph<String, DefaultEdge> grafo = criarGrafo();
		
		/**
		 * Chama a função que vai procurar minha matriz de incidência.
		 */
		achaMatrizIncidencia(grafo);
		
		System.out.println("Terminou!");
		System.out.println("Verifique o arquivo 'exercicio1.txt' na pasta arquivos.");
	}
	
	/**
	 * Método que vai achar minha matriz incidência de um grafo.
	 * 
	 * @param g : Grafo na qual eu quero achar a matriz de incidência.
	 * @throws IOException 
	 */
	private static void achaMatrizIncidencia(Graph<String, DefaultEdge> g) throws IOException {
		
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
		 * Função que vai imprimir minha matriz.
		 */
		constroiMatriz(g, listaVertices, iterator);
		
	}
	
	/**
	 * Método que vai escrever minha matriz de incidência no meu arquivo 'exercicio1.txt'.
	 * @param g : Graph<String, DefaultEdge>.
	 * @param listaVertices : List<String>.
	 * @param iterator : Iterator<DefaultEdge>.
	 * @throws IOException 
	 */
	private static void constroiMatriz(Graph<String, DefaultEdge> g, List<String> listaVertices,
			Iterator<DefaultEdge> iterator) throws IOException {
		
		List<DefaultEdge> arestas = new ArrayList<DefaultEdge>();
		/**
		 * Adiciono todas as arestas do meu grafo.
		 */
		while(iterator.hasNext()) {
			arestas.add(iterator.next());
		}
		
		/**
		 * Pego o caminho até o meu projeto e concateno com a pasta do meu arquivo. 
		 */
		String caminho = new File("").getAbsolutePath()+"/arquivos/exercicio1.txt";
		File fl = new File(caminho);
		FileWriter fw = new FileWriter(fl);
		BufferedWriter bw = new BufferedWriter(fw);
		
		/**
		 * Escrevo no meu arquivo o inicio e o fim de cada aresta do meu grafo.
		 */
		for(DefaultEdge aresta : g.edgeSet()) {
			String inicio = g.getEdgeSource(aresta);
			String fim = g.getEdgeTarget(aresta);
			bw.write("  |" + inicio+fim);
		}
		bw.newLine();
		
		/**
		 * Pego cada vertice e cada aresta(inicio e fim) e comparo se um dos terminais da
		 * aresta é igual ao meu vertice.
		 * Se for, imprimo "1", caso contrário imprimo "0".
		 */
		for(String v : listaVertices) {
			bw.write(v + " |");
			for(DefaultEdge aresta : arestas) {
				String inicio = g.getEdgeSource(aresta);
				String fim = g.getEdgeTarget(aresta);
				if(inicio.equals(v) || fim.equals(v)) {
					bw.write(" 1  |");
				} else {
					bw.write(" 0  |");
				}
			}
			bw.newLine();
		}
		bw.close();
		fw.close();
	}

	/**
	 * Método que irá criar um grafo.
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