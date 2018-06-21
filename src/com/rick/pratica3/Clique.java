package com.rick.pratica3;

import java.util.Iterator;
import java.util.Set;
 
import org.jgrapht.Graph;
import org.jgrapht.alg.clique.DegeneracyBronKerboschCliqueFinder;
import org.jgrapht.alg.clique.PivotBronKerboschCliqueFinder;

import com.rick.classesimportantes.*;
 
public class Clique {
	
	private Graph<DefaultVertex, RelationshipEdge> grafo;
	
	public Clique (Graph<DefaultVertex, RelationshipEdge> grafo) {
		this.grafo = grafo;
	}
    
	public void cliques() {
		DegeneracyBronKerboschCliqueFinder <DefaultVertex,RelationshipEdge> cf2 = 
                new DegeneracyBronKerboschCliqueFinder <> (this.grafo); 
        Iterator  <Set <DefaultVertex>> it2 = cf2.iterator();
        System.out.print("DegenearyBronKerboschCliqueFinder cliques: \n");
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }

        PivotBronKerboschCliqueFinder <DefaultVertex,RelationshipEdge> cf3 = 
                new PivotBronKerboschCliqueFinder <> (this.grafo); 
        Iterator  <Set <DefaultVertex>> it3 = cf3.iterator();
        System.out.print("\n\nPivotBronKerboschCliqueFinder cliques: \n");
        while (it3.hasNext()) {
            System.out.print(it3.next() + " ");
        }
	} 
}