package Glava8.GreedyAlgorithms;

import java.util.*;

public class RadioStationsGreedyAlgorithm {

    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new HashMap<>();

        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        Set<String> finalStations = findFinalStations(statesNeeded,stations);
        finalStations.forEach(s -> System.out.println(s));
    }
    public static Set<String> findFinalStations(Set<String> statesNeeded, Map<String, Set<String>> stations) {
        Set<String> finalStations = new HashSet<>();
        while (!statesNeeded.isEmpty())  {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for(Map.Entry<String, Set<String>> station : stations.entrySet())   {
                Set<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(station.getValue());

                if(covered.size()>statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered=covered;
                }

                statesNeeded.removeIf(statesCovered::contains);

                if(bestStation!=null)
                finalStations.add(bestStation);
            }
        }
        return finalStations;
    }
}
