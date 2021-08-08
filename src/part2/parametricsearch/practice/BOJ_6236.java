package part2.parametricsearch.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 용돈 관리 */
public class BOJ_6236 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 일자, 인출 횟수
    static int[] request; // 이용할 금액들

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        request = new int[N];
        for (int i = 0; i < N; i++) request[i] = fastReader.nextInt();
    }

    static boolean determination(int withdrawUnit) {
        int sum = 0, count = 1; // 처음 한번은 무조건 출금한 상태
        for (int index = 0; index < N; index++) {
            if (sum + request[index] <= withdrawUnit) {
                sum += request[index];
            } else {
                sum = request[index];
                count += 1;
            }
        }
        return count <= M;
    }

    static void process() {
        // 적어도 하루에 쓸 돈의 최댓값 만큼은 인출해야 한다!
        int left = Arrays.stream(request).max().getAsInt(), right = 1_000_000_000, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (determination(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
