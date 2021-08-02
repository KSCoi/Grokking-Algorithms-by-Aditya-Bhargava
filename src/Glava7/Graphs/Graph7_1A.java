package Glava7.Graphs;

import java.util.*;

public class Graph7_1A {
    private static final Double infinity = Double.POSITIVE_INFINITY;
    private static List<String> processed = new ArrayList<>(); //map of processed nodes

    public static void main(String[] args) {
        Map<String, HashMap<String,Double>> graph = new HashMap<>(); //graph
        graph.put("start", new HashMap<>());
        graph.get("start").put("A",5.);
        graph.get("start").put("B",2.);
        graph.put("B",new HashMap<>());
        graph.put("A",new HashMap<>());
        graph.get("B").put("A",8.);
        graph.get("B").put("D",7.);
        graph.get("A").put("D",2.);
        graph.get("A").put("C",4.);
        graph.put("D",new HashMap<>());
        graph.put("C",new HashMap<>());
        graph.get("D").put("end",1.);
        graph.get("C").put("D",6.);
        graph.get("C").put("end",3.);

        Map <String ,Double> costs = new HashMap<>(); //map of weights/costs of nodes
        costs.put("A",5.);
        costs.put("B",2.);
        costs.put("C",infinity);
        costs.put("D",infinity);
        costs.put("end",infinity);

        Map<String,String> parents = new HashMap<>(); //map of parents of nodes
        parents.put("A","start");
        parents.put("B","start");
        parents.put("C",null);
        parents.put("D",null);
        parents.put("end",null);

        String lowestCostNode = findLowestCostNode(costs);
        findLowestWay(lowestCostNode,costs,parents,graph);

    }
    public static String findLowestCostNode  (Map <String ,Double> costs)    { //method for find node with lowest weight/cost
        Double minimalCost = infinity;
        String minimalNode = null;
        for(Map.Entry<String, Double> node : costs.entrySet())  {
            if(minimalCost>node.getValue() && !processed.contains(node.getKey())) {
                minimalCost = node.getValue();
                minimalNode = node.getKey();
            }
        }
        return minimalNode;
    }
    public static void findLowestWay(String lowestCostNode,Map <String ,Double> costs,Map<String,String> parents, Map<String, HashMap<String,Double>> graph )  {
        while (lowestCostNode!=null)   {
            System.out.print("CURRENT NODE IS: " + lowestCostNode);
            double cost = costs.get(lowestCostNode);
            System.out.println(" CURRENT COST IS: " + cost);
            Map<String,Double> neighbours = graph.get(lowestCostNode);
            if(neighbours ==null)
                break;
            System.out.println("CURRENT NEIGHBOURS IS: " + neighbours.toString());

            for(Map.Entry<String, Double> neighbour : neighbours.entrySet())    {
                double newCost = cost+neighbour.getValue();
                if(costs.get(neighbour.getKey())>newCost) {
                    costs.put(neighbour.getKey(),newCost);
                    parents.put(neighbour.getKey(),lowestCostNode);
                    System.out.println("NEIGHBOUR " + neighbour.getKey() + " IS GETTING NEW COST: " + newCost + " AND NEW PARENT: " + lowestCostNode);
                }
            }
            if(lowestCostNode!=null)
                processed.add(lowestCostNode);
            lowestCostNode = findLowestCostNode(costs);
        }
    }
}
