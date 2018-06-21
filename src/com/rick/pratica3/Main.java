package com.rick.pratica3;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String c = new File("").getAbsolutePath()+"/rede.gml";
		MetricasDoGrafo metricas = new MetricasDoGrafo(c);
		
		/*
		// Metricas(Closseness, alpha e Betweeness)..
		metricas.metricasDosVertices();
		
		// Coeficiente de Clustering, diametro e distancia.
		metricas.metricasDoGrafo();
		
		// Cliques maximais do grafo.
		metricas.cliques();
		*/
		
		// Imprimir tudo de uma vez.
		metricas.verTudo();

	}

}
