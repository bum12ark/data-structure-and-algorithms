package part1.algorithm.graph.review;

import java.util.*;

public class BFS {

    public List<String> bsfSearch(Map<String, List<String>> graph, String startVertex) {
        Queue<String> needVisit = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        List<String> visitList = new ArrayList<>();

        needVisit.add(startVertex);
        while (!needVisit.isEmpty()) {
            String vertex = needVisit.poll();
            if (!visited.getOrDefault(vertex, false)) {
                visited.put(vertex, true);
                needVisit.addAll(graph.get(vertex));
                visitList.add(vertex);
            }
        }
        return visitList;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));

        part1.algorithm.graph.BFS bfs = new part1.algorithm.graph.BFS();
        System.out.println(bfs.bfsSearch(graph, "A"));
    }
}
