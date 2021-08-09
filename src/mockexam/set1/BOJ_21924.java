package mockexam.set1;

import part2.common.FastReader;

import java.util.*;

/* 도시 건설 */
public class BOJ_21924 {
    static class Edge {
        long weight;
        int nodeA;
        int nodeB;

        public Edge(long weight, int nodeA, int nodeB) {
            this.weight = weight;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
    }

    static class UnionFind {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();

        public UnionFind(List<Integer> nodes) {
            for (Integer node : nodes) {
                parent.put(node, node);
                rank.put(node, 0);
            }
        }

        public Integer find(Integer node) {
            if (!parent.get(node).equals(node)) {
                parent.put(node, find(parent.get(node)));
            }
            return parent.get(node);
        }

        public void union(Integer nodeA, Integer nodeB) {
            Integer rootA = find(nodeA);
            Integer rootB = find(nodeB);

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

    static FastReader fastReader = new FastReader();

    static int N, M; // 건물의 개수, 도로의 개수
    static long allConnectedValue; // 모든 건물이 연결되었을 때의 최대 값
    static List<Edge> edgeList = new ArrayList<>();
    static List<Integer> vertices = new ArrayList<>();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        for (int i = 1; i <= N; i++) vertices.add(i);
        for (int i = 0; i < M; i++) {
            int nodeA = fastReader.nextInt();
            int nodeB = fastReader.nextInt();
            long weight = fastReader.nextInt();
            edgeList.add(new Edge(weight, nodeA, nodeB));
            allConnectedValue += weight;
        }
    }

    static void process() {
        // 초기화
        List<Edge> mst = new ArrayList<>();
        UnionFind unionFind = new UnionFind(vertices);

        // 간선 weight 기반 sorting
        edgeList.sort((o1, o2) -> Long.compare(o1.weight, o2.weight));
        for (Edge edge : edgeList) {
            Integer nodeA = edge.nodeA;
            Integer nodeB = edge.nodeB;
            if (!unionFind.find(nodeA).equals(unionFind.find(nodeB))) {
                unionFind.union(nodeA, nodeB);
                mst.add(edge);
            }
        }

        long minConnectedValue = 0;
        for (Edge edge : mst) {
            minConnectedValue += edge.weight;
        }

        if (mst.size() != N - 1) System.out.println(-1);
        else System.out.println(allConnectedValue -  minConnectedValue);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
