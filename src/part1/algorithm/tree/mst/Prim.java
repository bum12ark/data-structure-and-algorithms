package part1.algorithm.tree.mst;

import java.util.*;

public class Prim {
    static class Edge implements Comparable<Edge> {
        public int weight;
        public String nodeA;
        public String nodeB;

        public Edge(int weight, String nodeA, String nodeB) {
            this.weight = weight;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public String toString() {
            return "(" + this.weight + ", " + this.nodeA + ", " + this.nodeB + ")";
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public List<Edge> primPath(List<Edge> edges, String startNode) {
        List<String> connectedNodes = new ArrayList<>();
        Map<String, List<Edge>> adjacentEdges = new HashMap<>();
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            List<Edge> edgesA = adjacentEdges.getOrDefault(edge.nodeA, new ArrayList<>());
            edgesA.add(new Edge(edge.weight, edge.nodeA, edge.nodeB));
            adjacentEdges.put(edge.nodeA, edgesA);

            List<Edge> edgesB = adjacentEdges.getOrDefault(edge.nodeB, new ArrayList<>());
            edgesB.add(new Edge(edge.weight, edge.nodeB, edge.nodeA));
            adjacentEdges.put(edge.nodeB, edgesB);
        }
        System.out.println(adjacentEdges);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        priorityQueue.addAll(adjacentEdges.get(startNode));

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!connectedNodes.contains(edge.nodeB)) {
                connectedNodes.add(edge.nodeB);
                mst.add(edge);

                List<Edge> adjacentEdgeNodes = adjacentEdges.get(edge.nodeB);
                for (Edge adjacentEdgeNode : adjacentEdgeNodes) {
                    if (!connectedNodes.contains(adjacentEdgeNode.nodeB)) {
                       priorityQueue.add(adjacentEdgeNode);
                    }
                }

            }
        }
        return mst;
    }

    static class Node {
        public String node;
        public int weight;

        public Node(String node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + this.weight + ", " + this.node + ")";
        }
    }

    static class Path {
        public String nodeA;
        public String nodeB;
        public int weight;

        public Path(String nodeA, String nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + this.nodeA + ", " + this.nodeB + ")";
        }
    }
    public List<Node> primPathAdvanced(List<Edge> edgeList, String startNode) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> edgeMap = new HashMap<>();

        for (Edge edge : edgeList) {
            Map<String, Integer> map = graph.getOrDefault(edge.nodeA, new HashMap<>());
            map.put(edge.nodeB, edge.weight);
            graph.put(edge.nodeA, map);
        }

        System.out.println(graph);
        return null;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(11, "F", "G"));

        Prim prim = new Prim();
        System.out.println(prim.primPath(edges, "A"));

        System.out.println("====================2===================");
        System.out.println(prim.primPathAdvanced(edges, "A"));
    }
}
