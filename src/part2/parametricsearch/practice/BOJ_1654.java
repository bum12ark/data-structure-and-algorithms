package part2.parametricsearch.practice;


import part2.common.FastReader;

/* 랜선 자르기 */
public class BOJ_1654 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N; // 이미 가지고 있는 랜선의 개수, 필요한 랜선의 개수
    static int[] lengths; // 랜선의 길이

    static void input() {
        K = fastReader.nextInt();
        N = fastReader.nextInt();
        lengths = new int[K];
        for (int i = 0; i < K; i++) lengths[i] = fastReader.nextInt();
    }

    static boolean determination(long cut) {
        long sum = 0;
        for (int length : lengths) {
            sum += length / cut;
        }
        return sum >= N;
    }

    static void process() {
        long left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
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
