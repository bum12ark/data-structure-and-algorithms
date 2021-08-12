package mockexam.ryu.set1;

import part2.common.FastReader;

import java.util.*;

/* 골목 대장 호석 */
public class BOJ_20182 {
    static class Edge implements Comparable<Edge> {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(to: " + to + ", weight: " + weight + ")";
        }


        @Override
        public int compareTo(Edge o) {
            return Long.compare(weight, o.weight);
        }
    }

    static FastReader fastReader = new FastReader();

    static int N, M, A, B; // 교차로 개수, 골목 개수, 시작 교차로 번호, 도착 교차로 번호
    static long C; // 가진 돈
    static long[] distance;
    static Map<Integer, List<Edge>> graph = new HashMap<>();

    static void input() {
        N = fastReader.nextInt(); M = fastReader.nextInt(); A = fastReader.nextInt(); B = fastReader.nextInt(); C = fastReader.nextLong();
        distance = new long[N + 1];
        for (int i = 1; i <= N; i++) graph.put(i, new ArrayList<>());
        for (int i = 1; i <= M; i++) {
            int nodeA = fastReader.nextInt();
            int nodeB = fastReader.nextInt();
            long weight = fastReader.nextLong();
            graph.get(nodeA).add(new Edge(nodeB, weight));
            graph.get(nodeB).add(new Edge(nodeA, weight));
        }
    }

    static boolean dijkstra(long maxAmount) {
        // x 라는 정답에 대해서 다익스트라 알고리즘을 수행하고, 가지고 있는 동과 비교하는 함수
        for (int i = 1; i <= N; i++) distance[i] = Long.MAX_VALUE;

        // 최소힙 생성
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(distance)에 갱신해준다.
        priorityQueue.add(new Edge(A, 0));
        distance[A] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!priorityQueue.isEmpty()) {
            Edge pollEdge = priorityQueue.poll();

            // 꺼낸 정보가 distance 배열의 값보다 크다면, 이미 가본 거리에서 더 증가되는 부분이므로 무시한다.
            if (distance[pollEdge.to] < pollEdge.weight) continue;

            // 연결된 모든 정점을 돌며 distance 값을 갱신한다.
            for (Edge adj : graph.get(pollEdge.to)) {
                if (adj.weight > maxAmount) continue;
                // adj.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 기록한다.
                if (distance[adj.to] > distance[pollEdge.to] + adj.weight) {
                    distance[adj.to] = distance[pollEdge.to] + adj.weight;
                    priorityQueue.add(new Edge(adj.to, distance[adj.to]));
                }
            }
        }
        return false;
    }

    static void process() {
        // 변수 초기화
        long left = 1, right = 1_000_000_001;

        // 정답에 대한 이분 탐색 시작

        // 정답 출력
    }

    public static void main(String[] args) {
        input();
        process();
        dijkstra(5);
        System.out.println(Arrays.toString(distance));
    }
}
