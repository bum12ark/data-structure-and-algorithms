package part2.tree.practice;

import part2.common.FastReader;

/* 부동산 다툼 */
public class BOJ_20364 {
    static FastReader fastReader = new FastReader();

    static int N, Q;
    static int[] wantLand;
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        Q = fastReader.nextInt();
        visited = new boolean[N + 1];
        wantLand = new int[Q];
        for (int i = 0; i < Q; i++) wantLand[i] = fastReader.nextInt();
    }


    static void solution() {
        for (int land : wantLand) {
            int node = land; // 부모 노드들을 탐색하기 위한 변수
            int stop = 0; // 점유된 땅을 찾기 위한 변수
            while (node > 0) {
                if (visited[node]) {
                    stop = node;
                }
                node /= 2;
            }
            if (stop == 0) visited[land] = true;
            System.out.println(stop);
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
