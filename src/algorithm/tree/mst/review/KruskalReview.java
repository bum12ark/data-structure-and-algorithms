package algorithm.tree.mst.review;

import algorithm.tree.mst.Kruskal;

import java.util.*;

public class KruskalReview {
    static class Edge {
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
            return "(weight: " + this.weight + ", nodeA: " + this.nodeA + ", nodeB: " + this.nodeB + ")";
        }
    }

    static class UnionFind {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();

        public UnionFind(List<String> nodes) {
            for (String node : nodes) {
                parent.put(node, node);
                rank.put(node, 0);
            }
        }

        // 각 node 의 rank 정보까지 업데이트할 필요 X
        // 루트 node 의 rank 정보만을 사용하기 때문
        public String find(String node) {
            if (!parent.get(node).equals(node)) {
                parent.put(node, find(parent.get(node)));
            }
            return parent.get(node);
        }

        public void union(String nodeA, String nodeB) {
            String rootA = find(nodeA);
            String rootB = find(nodeB);

            int rootARank = rank.get(rootA);
            int rootBRank = rank.get(rootB);
            if (rootARank > rootBRank) {
                parent.put(rootB, rootA);
            } else {
                parent.put(rootA, rootB);
                if (rootARank == rootBRank) {
                    rank.put(rootB, rootBRank + 1);
                }
            }
        }
    }

    public List<Edge> kruskalPath(List<String> vertices, List<Edge> edges) {
        // 1. 초기화
        List<Edge> mst = new ArrayList<>();
        UnionFind unionFind = new UnionFind(vertices);

        // 2. 간선 weight 기반 sorting
        edges.sort((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        for (Edge edge : edges) {
            String nodeA = edge.nodeA;
            String nodeB = edge.nodeB;
            if (!unionFind.find(nodeA).equals(unionFind.find(nodeB))) {
                unionFind.union(nodeA, nodeB);
                mst.add(edge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        KruskalReview kruskal = new KruskalReview();

        List<String> vertices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));

        System.out.println(kruskal.kruskalPath(vertices, edges));
    }
}
