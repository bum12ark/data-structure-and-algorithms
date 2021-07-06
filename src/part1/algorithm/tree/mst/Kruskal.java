package part1.algorithm.tree.mst;

import java.util.*;

public class Kruskal  {
    static class Edge implements Comparable<Edge> {
        public int weight;
        public String nodeV;
        public String nodeU;

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        @Override
        public String toString() {
            return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
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

        /**
         * 루트 노드를 리턴
         */
        public String find(String node) {
            // path compression 기법
            String parentNode = parent.get(node);
            if (!node.equals(parentNode)) {
                // 부모 노드를 루트 노드로 설정한다.
                parent.put(node, this.find(parentNode));
            }
            return parent.get(node);
        }

        /**
         * 두 노드를 연결하는 메서드
         */
        public void union(String nodeV, String nodeU) {
            String rootNodeV = this.find(nodeV);
            String rootNodeU = this.find(nodeU);

            // union-by-rank 기법
            if (rank.get(rootNodeV) > rank.get(rootNodeU)) {
                parent.put(rootNodeU, rootNodeV);
            } else {
                parent.put(rootNodeV, rootNodeU);
                if (rank.get(rootNodeV).equals(rank.get(rootNodeU))) {
                    rank.put(rootNodeU, rank.get(rootNodeU) + 1);
                }
            }
        }
    }

    public List<Edge> kruskalPath(List<String> vetices, List<Edge> edges) {
        List<Edge> mst = new ArrayList<>();

        // 1. 초기화
        UnionFind unionFind = new UnionFind(vetices);

        // 간선 weight 기반 sorting
        edges.sort((o1, o2) -> Integer.compare(o1.weight, o2.weight));

        for (Edge currentNode : edges) {
            String nodeVRoot = unionFind.find(currentNode.nodeV);
            String nodeURoot = unionFind.find(currentNode.nodeU);

            // 사이클이 없다면
            if (!nodeVRoot.equals(nodeURoot)) {
                // 두 노드를 연결
                unionFind.union(currentNode.nodeV, currentNode.nodeU);
                mst.add(currentNode);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        List<String> veties = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        Kruskal kruskal = new Kruskal();
        System.out.println(kruskal.kruskalPath(veties, edges));
    }
}
