package Glava7.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph7_1B {
    private static final Double infinity = Double.POSITIVE_INFINITY;
    private static List<String> processed = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, HashMap<String,Double>> graph = new HashMap<>();
        graph.put("start",new HashMap<>());
        graph.get("start").put("A",10.);
        graph.put("A",new HashMap<>());
        graph.get("A").put("B",20.);
        graph.put("B",new HashMap<>());
        graph.get("B").put("C",1.);
        graph.get("B").put("end",30.);
        graph.put("C",new HashMap<>());
        graph.get("C").put("A",1.);

        Map<String,Double> costs = new HashMap<>();
        costs.put("A",10.);
        costs.put("B",infinity);
        costs.put("C",infinity);
        costs.put("end",infinity);

        Map<String, String> parents = new HashMap<>();
        parents.put("A","start");
        parents.put("B",null);
        parents.put("C", null);
        parents.put("end",null);

        String lowestCostNode = Graph7_1A.findLowestCostNode(costs);
        Graph7_1A.findLowestWay(lowestCostNode,costs,parents,graph);
    }
}
