package algorithm.graph.review;

import java.util.*;

public class DijkstraReview {
    static class Edge {
        String vertex;
        int distance; // 가중치

        public Edge(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public Map<String, Integer> dijkstraSearch(Map<String, List<Edge>> graph, String startEdge) {
        // 초기화
        Map<String, Integer> distances = new HashMap<>();
        for (Map.Entry<String, List<Edge>> entry : graph.entrySet()) {
            distances.put(entry.getKey(), Integer.MAX_VALUE);
        }
        distances.put(startEdge, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.distance, o2.distance));
        priorityQueue.add(new Edge(startEdge, 0));

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            String currentVertex = edge.vertex;
            int currentDistance = edge.distance;

            // 여태까지 찾은 최단거리보다 현재 노드의 최단거리가 더 크다면 진행할 필요 없음
            if (currentDistance < distances.get(currentVertex)) {
                continue;
            }

            List<Edge> adjacentEdges = graph.get(currentVertex);
            for (Edge adjacent : adjacentEdges) {
                String adjacentVertex = adjacent.vertex;
                int adjacentDistance = adjacent.distance;

                if (adjacentDistance < distances.get(adjacentVertex)) {
                    int distance = currentDistance + adjacentDistance;
                    distances.put(adjacentVertex, distance);
                    priorityQueue.add(new Edge(adjacentVertex, distance));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        DijkstraReview dijkstra = new DijkstraReview();

        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge("A", 5))));

        System.out.println(dijkstra.dijkstraSearch(graph, "A"));
    }
}
