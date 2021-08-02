package Glava7.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    This graph is incorrect for dijkstra algorithm because of cycle with negative weight/cost!!!
 */
public class Graph7_1C {
    private static final Double infinity = Double.POSITIVE_INFINITY;
    private static List<String> processed = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, HashMap<String,Double>> graph = new HashMap<>();
        graph.put("start",new HashMap<>());
        graph.get("start").put("A",2.);
        graph.get("start").put("B",2.);
        graph.put("B",new HashMap<>());
        graph.get("B").put("A",2.);
        graph.put("A",new HashMap<>());
        graph.get("A").put("C",2.);
        graph.get("A").put("end",2.);
        graph.put("C",new HashMap<>());
        graph.get("C").put("end",2.);
        graph.get("C").put("B",-1.);

        Map<String,Double> costs = new HashMap<>();
        costs.put("A",2.);
        costs.put("B",2.);
        costs.put("C",infinity);
        costs.put("end",infinity);

        Map<String, String> parents = new HashMap<>();
        parents.put("A","start");
        parents.put("B","start");
        parents.put("C", null);
        parents.put("end",null);

        String lowestCostNode = Graph7_1A.findLowestCostNode(costs);
        Graph7_1A.findLowestWay(lowestCostNode,costs,parents,graph);
    }
}
