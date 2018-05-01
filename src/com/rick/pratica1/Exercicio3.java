package com.rick.pratica1;

import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * Classe responsável por resolver a questão 3(1º lista de exerício pratica) da disciplina
 * de teoria dos grafos.
 * 
 * @author Rich Elton - 117210710
 *
 */
public class Exercicio3 {

	/**
	 * Método principal.
	 * 
	 * @param args : Nunca é usada.
	 */
	public static void main(String[] args) {
		
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
		 * O objeto 'cycleBase' tem o método 'findCycleBase()' que retorna uma lista de string.
		 * Essa lista de string são todos os ciclos do grafo.
		 */
		List<List<String>> circulos = cycleBase.findCycleBase();
		
		if(ehBipartido(circulos)) {
			System.out.println("É bipartido");
		} else {
			System.out.println("Não é bipartido");
		}
	}

	/**
	 * Método que verifica se um grafo, a partir de todos os seus ciclos, é bipartido ou não.
	 * 
	 * @param circulos : List<List<String>> são todos os círculos desse grafo.
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
	 * Método para criar o grafo.
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