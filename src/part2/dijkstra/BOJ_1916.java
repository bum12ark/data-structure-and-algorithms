package part2.dijkstra;

import part2.common.FastReader;

import java.util.*;

public class BOJ_1916 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to; // 도착 정점
        public int weight; // 가중치

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "[" + to + ", " + weight + "]";
        }
    }

    static class Info {
        public int index;
        public int distance;

        public Info() {}

        public Info(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    static int N, M, start, end;
    static int[] distance;
    static Map<Integer, List<Edge>> edges = new HashMap<>();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) edges.put(i, new ArrayList<>());
        for (int i = 1; i <= M; i++) {
            int from = fastReader.nextInt();
            int to = fastReader.nextInt();
            int weight = fastReader.nextInt();
            edges.get(from).add(new Edge(to, weight));
        }
        start = fastReader.nextInt();
        end = fastReader.nextInt();
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        // ※주의사항※
        // 문제의 정답으로 간으한 거리의 최대값보다 큰 값임을 보장해야 한다.
        for (int i = 1; i <= N; i++) distance[i] = Integer.MAX_VALUE;

        // 최소 힙 생성 (오름차순)
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.distance, o2.distance));

        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        priorityQueue.add(new Info(start, 0));
        distance[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!priorityQueue.isEmpty()) {
            Info info = priorityQueue.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다.
            if (distance[info.index] < info.distance) continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
            for (Edge edge : edges.get(info.index)) {
                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해준다.
                // if (distance[info.index] + edge.weight >= distance[edge.to]) continue;
                if (edge.weight >= distance[edge.to]) continue;
                distance[edge.to] = distance[info.index] + edge.weight;
                priorityQueue.add(new Info(edge.to, distance[edge.to]));
            }
        }
    }

    static void process() {
        dijkstra(start);
        System.out.println(distance[end]);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
