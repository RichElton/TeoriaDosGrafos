package com.rick.pratica2;

import org.jgrapht.alg.ConnectivityInspector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.jgrapht.Graph;

public class Exercicio2 {
	
	public static void main(String[] args) {
		Graph<Object, RelationshipEdge> grafo = ImportGraphGML.importaGrafo();
		
		Object vInicio = null;
		for(Object a : grafo.vertexSet()) {
			if(a.toString().equals("C")) {
				vInicio = a;
				break;
			}
		}
	}
	
	public static ArrayList<RelationshipEdge> algFleury(Graph<Object, RelationshipEdge> grafo, Object v){		
		ArrayList<RelationshipEdge> saida = new ArrayList<>();
		ArrayList verticesUsados = new ArrayList();
		
		Graph<Object, RelationshipEdge> gCopia = grafo;
		Object vertice = v;
		verticesUsados.add(vertice);
		
		ConnectivityInspector<Object, RelationshipEdge> c = new ConnectivityInspector<Object, RelationshipEdge>(gCopia);

		
		Set<RelationshipEdge> arestas = gCopia.edgeSet();
		Iterator<RelationshipEdge> it = arestas.iterator();
		
		while (it.hasNext()) {
			Object vi = (Object) verticesUsados.get(verticesUsados.size()-1);
			if (gCopia.inDegreeOf(vi) == 1) {
				Set<RelationshipEdge> ai = gCopia.edgesOf(vi);
			} else {
				
			}
		}
		
		
		return saida;
	}
	
}