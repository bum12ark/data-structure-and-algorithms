package part2.topological_sort.practice;

import part2.common.FastReader;

import java.util.*;

/* 음악 프로그램 */
public class BOJ_2623 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N, M; // 가수의 수, 보조 PD 수
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static int[] indegree;

    static void input() {
        N = fastReader.nextInt(); M = fastReader.nextInt();
        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) adjList.put(i, new ArrayList<>());

        for (int m = 0; m < M; m++) {
            int PD = fastReader.nextInt(); // 담당한 가수의 수
            int start = fastReader.nextInt();
            for (int p = 0; p < PD - 1; p++) {
                int end = fastReader.nextInt();
                adjList.get(start).add(end);
                indegree[end]++;
                // start 와 end 값을 바꿔서 다시 strat 와 end 간선을 만든다.
                start = end;
            }
        }
    }

    static void process() {
        Deque<Integer> deque = new LinkedList<>();
        for (int index = 1; index <= N; index++) {
            if (indegree[index] == 0) {
                deque.add(index);
            }
        }

        // 정렬될 수 있는 정점이 있다면?
        while (!deque.isEmpty()) {
            Integer px = deque.poll();
            // 1. 정렬 결과에 추가하기
            sb.append(px).append("\n");
            // 2. 정점과 연결된 간선 제거하기
            for (int adj : adjList.get(px)) {
                // 3. 새롭게 "정렬될 수 있는" 정점
                indegree[adj]--;
                if (indegree[adj] == 0) deque.add(adj);
            }
        }

        // 싸이클 유무 파악
        for (int i = 1; i <= N; i++) {
            if (indegree[i] != 0) {
                sb = new StringBuffer();
                sb.append(0);
            }
        }
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb);
    }
}
