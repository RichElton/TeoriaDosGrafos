package com.rick.pratica3;

import java.io.File;

public class Questao2 {

	public static void main(String[] args) {
		String c = new File("").getAbsolutePath()+"/src/com/rick/pratica3/teia.gml";
		MetricasDoGrafo metricas = new MetricasDoGrafo(c);
		
		/* imprimir um por vez
		// Metricas(Closseness, alpha e Betweeness)..
		metricas.metricasDosVertices();
		
		// Coeficiente de Clustering, diametro e distancia.
		metricas.metricasDoGrafo();
		
		// Cliques maximais do grafo.
		metricas.cliques();
		*/
		
		// OU Imprimir tudo de uma vez.
		metricas.verTudo();

	}

}
