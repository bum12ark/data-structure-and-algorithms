package algorithm.graph;

import java.util.*;

public class Dijkstra {
    static class Edge implements Comparable<Edge> {
        public String vertex;
        public int distance;

        public Edge(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            // 거리로 오름차순 정렬
            return this.distance - o.distance;
        }

        @Override
        public String toString() {
            return "[vertex: " + this.vertex + ", distance: " + this.distance +"]";
        }
    }

    public Map<String, Integer> dijkstraSearch(Map<String, List<Edge>> graph, String startEdge) {
        // 초기화
        Map<String, Integer> distances = new HashMap<>();
        for (Map.Entry<String, List<Edge>> entry : graph.entrySet()) {
            String key = entry.getKey();
            distances.put(key, Integer.MAX_VALUE);
        }

        distances.put(startEdge, 0);
        // PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.distance, o2.distance));
        priorityQueue.add(new Edge(startEdge, 0));

        // 알고리즘 작성성
        while (!priorityQueue.isEmpty()) {
            Edge edgeNode = priorityQueue.poll();
            int currentDistance = edgeNode.distance;
            String currentVertex = edgeNode.vertex;

            // 여태까지 찾은 최단거리보다 현재 노드의 최단거리가 더 크다면 진행할 필요 없음음
           if (distances.get(currentVertex) < currentDistance) {
                continue;
            }

            List<Edge> edges = graph.get(currentVertex);
            for (Edge adjacentNode : edges) {
                String adjacent = adjacentNode.vertex;
                int weight = adjacentNode.distance;

                if (weight < distances.get(adjacent)) {
                    int distance = currentDistance + weight;
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(adjacent, distance));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<>(Arrays.asList(new Edge("A", 5))));

        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.dijkstraSearch(graph, "A"));
    }
}
