package com.rick.pratica2;

import org.jgrapht.alg.cycle.HierholzerEulerianCycle;
import java.util.ArrayList;
import java.util.List;
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
		HierholzerEulerianCycle<Object, RelationshipEdge> hz = new HierholzerEulerianCycle<>();
		List<Object> listaVertices = hz.getEulerianCycle(grafo).getVertexList();
		List<Object> circuito = listaVertices;
		
		int indiceInicial = 0;
		for (int i = 0; i < circuito.size(); i++) {
			if (vInicio.equals(circuito.get(i))) {
				indiceInicial = i;
				break;
			}
		}
		
		ArrayList<Object> caminho = new ArrayList<Object>();
		int a = circuito.size();
		while (a >= 0) {
			if (indiceInicial == circuito.size()) {
				indiceInicial = 0;
			} else {
				caminho.add(circuito.get(indiceInicial));
			}
			indiceInicial++;
			a--;
		}
		System.out.println(caminho);
	}
	/*public static boolean arestaPonte(Graph<Object, RelationshipEdge> grafo, RelationshipEdge aresta) {
		PatonCycleBase cb = new PatonCycleBase<>(grafo);

		ArrayList<ArrayList<Object>> ciclos = (ArrayList<ArrayList<Object>>) cb.findCycleBase();
		for(ArrayList<Object> lista : ciclos) {
			for(int i = 0; i < lista.size(); i++) {
				RelationshipEdge a = null;
				if (i != lista.size() - 1) {
					a = grafo.getEdge(lista.get(i), lista.get(i+1));
				}
				if (a != null && aresta != null) {
					if (aresta.equals(a)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static RelationshipEdge arestaIncidente(Graph<Object, RelationshipEdge> g, Object v) {
		Set<RelationshipEdge> arestas = g.edgesOf(v);
		Object fim = null;
		for(RelationshipEdge a : arestas) {
			if (!a.getV1().equals(v)) {
				fim = a.getV1();
			} else {
				fim = a.getV2();
			}
		}
		RelationshipEdge aresta = g.getEdge(v, fim);
		return aresta;
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
			RelationshipEdge ai = null;
			if (gCopia.inDegreeOf(vi) == 1) {
				ai = arestaIncidente(gCopia, vi);
			} else {
				RelationshipEdge a = arestaIncidente(gCopia, vi);
				if(!arestaPonte(grafo, a)) {
					ai = a;
				}
			}
			gCopia.removeEdge(ai);
			verticesUsados.add(ai);
			Object vj = grafo.getEdgeSource(ai);
			verticesUsados.add(vj);
		}
		return verticesUsados;
	}*/	
}