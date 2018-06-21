package com.rick.pratica2;

import java.io.File;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.io.GmlImporter;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.ImportException;
import org.jgrapht.io.VertexProvider;
 
import com.rick.classesusadas.*;

public class ImportGraphGML {
	public static Graph<Object, RelationshipEdge> importaGrafo() {
        VertexProvider <Object> vp1 = (label,attributes) -> new DefaultVertex(label,attributes);
        EdgeProvider <Object,RelationshipEdge> ep1 = (from,to,label,attributes) -> new RelationshipEdge(from,to,attributes);
        GmlImporter <Object,RelationshipEdge> gmlImporter = new GmlImporter <> (vp1,ep1);
        Graph<Object, RelationshipEdge> graphgml = new SimpleGraph<>(RelationshipEdge.class);
        try {
        	String caminho = new File("").getAbsolutePath()+"/rede.gml";
        	gmlImporter.importGraph(graphgml, ImportGraph.readFile(caminho));
        } catch (ImportException e) {
        	throw new RuntimeException(e);
        }
   	   	return graphgml;
    }
         
}