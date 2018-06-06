package com.rick.pratica2;

import org.jgrapht.alg.cycle.HierholzerEulerianCycle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.jgrapht.Graph;

/**
 * Classe responsável por resolver o problema da questão 2 da pratica 2 da disciplina de Teoria dos
 * Grafos.
 * 
 * @author Rich Elton
 *
 */
public class Exercicio2 {
	
	/**
	 * Atributo estatico responsável por saber se o grafo possui um ciclo de Euler, e se sim qual
	 * o caminho do ciclo.
	 */
	private static HierholzerEulerianCycle<Object, RelationshipEdge> hz;
	/**
	 * Atributo estatico responsavel pela escrita no meu arquivo de texto.
	 */
	private static BufferedWriter principal;
	
	/**
	 * Método principal da minha classe.
	 * 
	 * @param args Não é utilizada.
	 * @throws IOException Caso aconteça alguma exceção na escrita no meu arquivo de texto("pratica2-ex2.txt").
	 */
	public static void main(String[] args) throws IOException {
		
		// Criando arquivo de escrita(txt).
		String caminho = new File("").getAbsolutePath()+"/arquivos/pratica2-ex2.txt";
		principal = new BufferedWriter(new FileWriter(caminho));
		principal.write("Questão 2 da pratica 2 - Teoria dos Grafos: " + caminho + "\n");
		
		hz = new HierholzerEulerianCycle<>();
		Graph<Object, RelationshipEdge> grafo = ImportGraphGML.importaGrafo();
		
		if(hz.isEulerian(grafo)) {
			achaCicloEuler(grafo, "C");
		} else {
			String res = "Grafo não possui um ciclo de Euler.";
			principal.write(res);
		}
		principal.close();
	}
	
	/**
	 * Função que acha o ciclo Euler de um grafo saindo de um determinado ponto.
	 * @param grafo Grafo na qual você quer achar o ciclo.
	 * @param vertice O vertice inicial.
	 * @throws IOException Caso aconteça alguma exceção na escrita no meu arquivo de texto("pratica2-ex2.txt")
	 */
	public static void achaCicloEuler(Graph<Object, RelationshipEdge> grafo, String vertice) throws IOException {
		
		// Acho o vertice.
		Object vInicio = null;
		for(Object a : grafo.vertexSet()) {
			if(a.toString().equals(vertice)) {
				vInicio = a;
				break;
			}
		}
		
		// Acho o caminho de vertices do meu ciclo de Euler.
		List<Object> listaVertices = hz.getEulerianCycle(grafo).getVertexList();
		List<Object> circuito = listaVertices;
		
		// Procuro pelo vertice que desejo iniciar.
		int indiceInicial = 0;
		for (int i = 0; i < circuito.size(); i++) {
			if (vInicio.equals(circuito.get(i))) {
				indiceInicial = i;
				break;
			}
		}
		
		// Faço o caminho do ciclo de Euler a partir do meu vertice inical.
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
		principal.write("\nCaminho: " + caminho.toString());
	}
}