package part2.topological_sort.review;

import part2.common.FastReader;

import java.util.*;

/* 줄 세우기 */
public class BOJ_2252 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N, M; // 학생의 수, 키를 비교한 회수
    static int[] indegree;
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    /* 단방향 그래프이면서 사이클이 존재하지 않기 때문에 visited 배열은 필요하지 않다. */

    static void input() {
        N = fastReader.nextInt(); M = fastReader.nextInt();
        indegree = new int[N + 1];

        // Adjacent List 생성 및 indegree 계산하기
        for (int i = 1; i <= N; i++) adjList.put(i, new ArrayList<>());
        for (int m = 0; m < M; m++) {
            int in = fastReader.nextInt();
            int out = fastReader.nextInt();
            adjList.get(in).add(out);
            indegree[out]++;
        }
    }

    static void process() {
        Deque<Integer> deque = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int index = 1; index <= N; index++) {
            if (indegree[index] == 0) {
                deque.add(index);
            }
        }

        // 정렬될 수 있는  정점이 있다면?
        while (!deque.isEmpty()) {
            // 1. 정렬 결과에 추가하기
            Integer nx = deque.poll();
            sb.append(nx).append(" ");
            for (int adj : adjList.get(nx)) {
                // 2. 정점과 연결된 간선 제거하기
                indegree[adj]--;
                // 3. 새롭게 "정렬될 수 있는" 정점 추가하기
                if (indegree[adj] == 0) deque.add(adj);
            }
        }
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb);
    }
}
