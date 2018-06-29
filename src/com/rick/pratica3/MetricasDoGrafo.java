package com.rick.pratica3;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.PatonCycleBase;
import org.jgrapht.alg.scoring.*;
import org.jgrapht.alg.scoring.ClosenessCentrality;
import org.jgrapht.alg.scoring.HarmonicCentrality;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.GmlImporter;
import org.jgrapht.io.ImportException;
import org.jgrapht.io.VertexProvider;
import org.jgrapht.traverse.BreadthFirstIterator;

import com.rick.classesimportantes.*;

/**
 * Classe responsavel por acha metricas de um determinado grafo.
 * 
 * @author Rich Ramalho
 *
 */
public class MetricasDoGrafo {
	
	private Graph<DefaultVertex, RelationshipEdge> grafoGml;
	
	/**
	 * Construtor.
	 * 
	 * @param caminhoGrafo Caminho para o grafo(.gml)
	 */
	public MetricasDoGrafo(String caminhoGrafo) {
		// Importando  grafo.
    	grafoGml = importarGrafo(caminhoGrafo);
	}
	
	public void verTudo() {
		// Metricas(Closseness, alpha e Betweeness)..
		this.metricasDosVertices();
		
		// Coeficiente de Clustering, diametro e distancia.
		this.metricasDoGrafo();
		
		// Cliques.
		this.cliques();
	}
    
	/**
	 * Metodo que imprime os cliques maximais do meu grafo.
	 * 
	 */
    public void cliques() {
        System.out.println("\nCliques: ");
        Clique clique = new Clique(grafoGml);
        clique.cliques();
    }
    
    /**
     * Metodo que imprime as metricas de cada vertice do meu grafo(Closseness, alpha e Betweeness).
     * 
     */
    public void metricasDosVertices() {
		// Metrica - Closeness Centrality.
    	System.out.println("-CLOSENESS CENTRALITY- ");
        ClosenessCentrality <DefaultVertex, RelationshipEdge> cc = new ClosenessCentrality <> (grafoGml);
        printOrderedDouble(cc.getScores());
        
        // Metrica - ALPHA CENTRALITY.
        System.out.println("\n\n-ALPHA CENTRALITY- ");
        AlphaCentrality <DefaultVertex, RelationshipEdge> ac = new AlphaCentrality <> (grafoGml,0.1);
        printOrderedDouble (ac.getScores());
        
        // Metrica - BETWEENESS CENTRALITY.
        System.out.println("\n\n-BETWEENESS CENTRALITY- ");
        BetweennessCentrality <DefaultVertex, RelationshipEdge> bc = new BetweennessCentrality <> (grafoGml,true);
        printOrderedDouble (bc.getScores());
	}
    
    /**
     * Metodo que imprime as metricas para o meu grafo.
     */
    public void metricasDoGrafo() {
    	
    	// Coeficiente de Clustering global.
        double triplets = get_NTriplets(grafoGml);
        double triangles = get_NTriangles(grafoGml);
        double coefCluster = (3*triangles)/triplets;
        System.out.println("\n\nCoeficiente de CLUSTERING: " + new Double(coefCluster));
        
    	// Diametro e Distancia.
        int diameter = 0;
        ArrayList <Integer> a = get_allpathLenghts(grafoGml);
            int sum = 0;
        for(int i=0; i < a.size() ; i++) {
              sum = sum + a.get(i);
             if (diameter<a.get(i)) {
                 diameter = a.get(i);
             }
        }
        double average = sum / a.size();
        System.out.println("\nDISTANCE: " + average);
        System.out.println("\nDIAMETER: " + diameter);
    }
    
    /**
     * Importa o grafo .gml
     * 
     * @param caminho Caminho na qual o grafo se encontra.
     * @return O grafo
     */
    private static Graph<DefaultVertex, RelationshipEdge> importarGrafo(String caminho){
    	// Importa o grafo GML
        Graph<DefaultVertex, RelationshipEdge> graphgml = new SimpleGraph<>(RelationshipEdge.class);
        
        VertexProvider <DefaultVertex> vp1 = (label,attributes) -> new DefaultVertex (label,attributes);
        EdgeProvider <DefaultVertex,RelationshipEdge> ep1 = (from,to,label,attributes) -> new RelationshipEdge(from,to,attributes);
        GmlImporter <DefaultVertex,RelationshipEdge> gmlImporter = new GmlImporter <> (vp1,ep1);
        try {
            gmlImporter.importGraph(graphgml, 
                    ImportGraph.readFile(caminho));
          } catch (ImportException e) {
            throw new RuntimeException(e);
        }
        return graphgml;
    }
 
    // Métodos Auxiliares
    private static int fact (int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }
     
    private static <V> void printOrderedDouble (Map <V,Double> M) {
        Set<Entry<V, Double>> set = M.entrySet();
        List<Entry<V, Double>> list = new ArrayList<Entry<V, Double>>(set);
        Collections.sort( list, new Comparator<Map.Entry<V, Double>>()
        {
            public int compare( Map.Entry<V, Double> o1, Map.Entry<V, Double> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        for(Map.Entry<V,Double> entry:list){
            System.out.print(entry.getKey()+": "+ String.format("%.2f",(entry.getValue()))+ "; ");
        }   
    }
     
    private static <V,E> double get_NTriplets (Graph <V, E> g) {
     
        double triplets = 0;
        BreadthFirstIterator <V,E> cfi = new BreadthFirstIterator <> (g);
        while (cfi.hasNext()) {
            V v = cfi.next();
            int n = (g.edgesOf(v)).size();
            if (n >=2) {
                triplets = triplets + fact(n) / (2*fact(n-2));
            }           
        }
        return triplets;
    }
     
    private static <V,E> double get_NTriangles (Graph <V,E> g) {
        double triangles = 0;
        PatonCycleBase <V,E> pc = new PatonCycleBase <> (g);
        Iterator <List<E>> it2 = ((pc.getCycleBasis()).getCycles()).iterator();
        while (it2.hasNext()) {
            List <E> s = it2.next();
            if ((s).size()==3) {
                triangles++;
            }
        }
        return triangles;
    }
     
    private static <V,E> double calculateAssortativityCoefficient (Graph <V, E> graph) {
        // from: https://github.com/Infeligo/jgrapht-metrics/blob/master/src/main/java/org/jgrapht/metrics/AssortativityCoefficientMetric.java
        double edgeCount = graph.edgeSet().size();
        double n1 = 0, n2 = 0, dn = 0;
 
        for (E e : graph.edgeSet()) {
            int d1 = graph.degreeOf(graph.getEdgeSource(e));
            int d2 = graph.degreeOf(graph.getEdgeTarget(e));
 
            n1 += d1 * d2;
            n2 += d1 + d2;
            dn += d1 * d1 + d2 * d2;
        }
        n1 /= edgeCount;
        n2 = (n2 / (2 * edgeCount)) * (n2 / (2 * edgeCount));
        dn /= (2 * edgeCount);
         
        return (n1 - n2) / (dn - n2);
    }
     
    private static <V,E> ArrayList <Integer> get_allpathLenghts (Graph <V,E> g) {
        DijkstraShortestPath <V,E>  p = new DijkstraShortestPath <> (g);
        ArrayList <Integer> a = new ArrayList <Integer> ();
        BreadthFirstIterator <V,E> pf = new BreadthFirstIterator <> (g);
        while (pf.hasNext()) {
            V v1 = pf.next();
            Iterator <V> vs = g.vertexSet().iterator();
            while (vs.hasNext()) {
                V v2 = vs.next();
                int dist = (p.getPath(v1, v2)).getLength();
                if (v1.equals(v2) == false) {
                    a.add(dist);
                }
            }           
        }
        return a;
    }
}
