package part2.topological_sort.practice;

import part2.common.FastReader;

import java.util.*;

public class BOJ_9470 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Pair {
        int strahler; // 들어온 노드의 strahler 값
        int count; // 해당 노드가 들어온 횟수

        public Pair() {}

        public Pair(int strahler) {
            this.strahler = strahler;
        }

        public Pair(int strahler, int count) {
            this.strahler = strahler;
            this.count = count;
        }

        @Override
        public String toString() {
            return "[" + strahler + ", " + count + "]";
        }
    }

    static int T, K, M, P; // 테스트 케이스의 수, 테스트 케이스 번호, 노드의 수, 간선의 수
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] indeg;
    static Map<Integer, Pair> pair = new HashMap<>();

    static void input() {
        K = fastReader.nextInt(); M = fastReader.nextInt(); P = fastReader.nextInt();
        indeg = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            graph.put(i, new ArrayList<>());
            pair.put(i, new Pair());
        }
        for (int p = 1; p <= P; p++) {
            int in = fastReader.nextInt();
            int out = fastReader.nextInt();
            graph.get(in).add(out);
            indeg[out]++;
        }
    }

    static void process() {
        Deque<Integer> deque = new LinkedList<>();
        // 들어오는 간선이 0 개인 정점들을 찾아 큐에 삽입
        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                deque.add(i); 
                // 처음 시작되는 pair 값은 (1, 1) 이다.
                pair.get(i).strahler = 1;
                pair.get(i).count = 1;
            }
        }

        while (!deque.isEmpty()) {
            Integer px = deque.poll();
            for (int adj : graph.get(px)) {
                // 정점 X 제거 하기
                indeg[adj]--;

                Pair currentPair = pair.get(adj); // 여태까지 계산된 간선 (즉, 가장 큰 strahler 값을 가지고 있다!!!)
                Pair inPair = pair.get(px); // 새롭게 들어오는 간선

                // 새롭게 들어오는 간선의 strahler 값이 더 크다면 업데이트
                if (currentPair.strahler < inPair.strahler) {
                    currentPair.strahler = inPair.strahler;
                    currentPair.count = 1;
                } else if (currentPair.strahler == inPair.strahler) {
                    currentPair.count += 1;
                }

                if (indeg[adj] == 0) { // 모든 간선의 정보가 업데이트 되었을 경우
                    if (currentPair.count > 1) { // 중복된 strahler 값이 1 크다면 값 업데이트
                        currentPair.strahler += 1;
                        currentPair.count = 1;
                    }
                    deque.add(adj);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            sb.append(K).append(" ");
            process();
            sb.append(pair.get(M).strahler).append("\n");
        }
        System.out.println(sb);
    }
}
