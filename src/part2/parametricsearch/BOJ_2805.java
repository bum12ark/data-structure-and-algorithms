package part2.parametricsearch;

import part2.common.FastReader;

public class BOJ_2805 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 나무의 수, 가져가려는 나무의 길이
    static int[] trees;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        trees = new int[N];
        for (int i = 0; i < N; i++) trees[i] = fastReader.nextInt();
    }

    static boolean determination(int cut) {
        // cut 높이로 나무들을 잘랐을 때, M 만큼 얻을 수 있으면 true, 없으면 false 를 리턴하는 함수
        long sum = 0;
        for (int height : trees) {
            if (height > cut) {
                sum += height - cut;
            }
        }
        return sum >= M;
    }

    static void process() {
        int left = 0, right = 1_000_000_000;
        long ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (determination(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
