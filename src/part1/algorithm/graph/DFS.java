package part1.algorithm.graph;

import java.util.*;

public class DFS {

    public List<String> dfsSearch(Map<String, List<String>> graph, String start) {
        Stack<String> needVisit = new Stack<>();
        Map<String, Boolean> visited = new HashMap<>();
        List<String> visitedList = new ArrayList<>();

        needVisit.push(start);
        while (!needVisit.isEmpty()) {
            String vertex = needVisit.pop();
            if (!visited.getOrDefault(vertex, false)) {
                visited.put(vertex, true);
                visitedList.add(vertex);

                needVisit.addAll(graph.get(vertex));
            }
        }
        return visitedList;
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

        DFS dfs = new DFS();
        System.out.println(dfs.dfsSearch(graph, "A"));
    }
}
