package com.rick.pratica2;

import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.cycle.PatonCycleBase;

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
		System.out.println(verticePonte(grafo, vInicio));
	}
	
	public static boolean verticePonte(Graph<Object, RelationshipEdge> grafo, Object vertice) {
		PatonCycleBase cb = new PatonCycleBase<>(grafo);
		
		ArrayList<ArrayList<Object>> ciclos = (ArrayList<ArrayList<Object>>) cb.findCycleBase();
		for(ArrayList<Object> lista : ciclos) {
			for(Object a : lista) {
				if (a.equals(vertice)) {
					System.out.println(lista);
					System.out.println("aqui");
					return true;
				}
			}
		}
		return false;
	}
	
	public static void arestaIncidente(Graph<Object, RelationshipEdge> g) {
		
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
				if (!verticePonte(grafo, vi)) {
					
				}
			}
		}
		
		return saida;
	}
	
}