package com.rick.pratica2;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

public class Exercicio2 {
	
	public static void main(String[] args) {
		Graph<DefaultEdge, String> grafo = criaGrafo();
		
		ConnectivityInspector c = new ConnectivityInspector<>(grafo);
		
		System.out.println(c.isGraphConnected());
		System.out.println(c.pathExists("a", "c"));
		System.out.println(c.connectedSets());
	}
	
	public static Graph<DefaultEdge, String> criaGrafo(){
		
		Graph grafo = new SimpleGraph<>(DefaultEdge.class);
		grafo.addVertex("a");	grafo.addVertex("b");	grafo.addVertex("c");
		grafo.addVertex("d");   grafo.addVertex("e");  grafo.addVertex("f");
		
		grafo.addEdge("a", "b");	grafo.addEdge("a", "c");
		grafo.addEdge("b", "c");	grafo.addEdge("d", "e");
		grafo.addEdge("d", "f");	grafo.addEdge("f", "e");
		return grafo;
	}

}
