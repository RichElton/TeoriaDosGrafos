package com.rick.pratica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * Classe respons�vel por resolver a quest�o 3(1� lista de exer�cio pratica) da disciplina
 * de teoria dos grafos.
 * 
 * @author Rich Elton - 117210710
 *
 */
public class Exercicio3 {

	/**
	 * M�todo principal.
	 * 
	 * @param args : Nunca � usada.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/**
		 * Criando um grafo simples.
		 */
		Graph<String, DefaultEdge> grafo = criandoGrafo();
		
		/**
		 * Instanciando um objeto da classe(PatonCycleBase) que no construtor recebe o
		 * grafo criado.
		 */
		PatonCycleBase<String, DefaultEdge> cycleBase = new PatonCycleBase<String,DefaultEdge>(grafo);
		
		/**
		 * Uma lista que tem outra lista de string dentro dela.
		 * O objeto 'cycleBase' tem o m�todo 'findCycleBase()' que retorna uma lista de string.
		 * Essa lista de string s�o todos os ciclos do grafo.
		 */
		List<List<String>> circulos = cycleBase.findCycleBase();
		
		String caminho = new File("").getAbsolutePath()+"/arquivos/exercicio3.txt";
		FileWriter fw = new FileWriter(caminho);
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		if(ehBipartido(circulos)) {
			bw.write("� bipartido");
		} else {
			bw.write("N�o � bipartido");
		}
		bw.close();
		
		System.out.println("Terminou!");
		System.out.println("Verifique o arquivo 'exercicio3.txt' na pasta arquivos.");
	}

	/**
	 * M�todo que verifica se um grafo, a partir de todos os seus ciclos, � bipartido ou n�o.
	 * 
	 * @param circulos : List<List<String>> s�o todos os c�rculos desse grafo.
	 * @return : true ou false.
	 */
	private static boolean ehBipartido(List<List<String>> circulos) {
		for(List<String> c : circulos) {
			if(c.size() % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * M�todo para criar o grafo.
	 * 
	 * @return : Graph<String, DefaultEdge>.
	 */
	private static Graph<String, DefaultEdge> criandoGrafo() {
		Graph<String, DefaultEdge> graph = new SimpleGraph<String,DefaultEdge>(DefaultEdge.class);
		
		graph.addVertex("a");		graph.addVertex("b");	graph.addVertex("c");
		graph.addVertex("d");	 	graph.addVertex("e");	graph.addVertex("f");
		
		graph.addEdge("a", "b"); 	graph.addEdge("a", "c");    graph.addEdge("b", "e");
		graph.addEdge("b", "c");	graph.addEdge("b", "d");	graph.addEdge("e", "f");
	 	graph.addEdge("e", "c");	graph.addEdge("e", "d");	graph.addEdge("f", "d");
		graph.addEdge("d", "c");
		
		return graph;
	}
}