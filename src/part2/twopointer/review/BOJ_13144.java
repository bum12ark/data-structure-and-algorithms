package part2.twopointer.review;

import part2.common.FastReader;

/**
 * List of Unique Numbers
 */
public class BOJ_13144 {
    static FastReader fastReader = new FastReader();

    static int N;
    static int[] A;
    static int[] cnt;

    static void input() {
        N = fastReader.nextInt();
        A = new int[N + 1];
        for (int a = 1; a <= N; a++) A[a] = fastReader.nextInt();
        cnt = new int[N + 1];
    }

    static void pro() {
        long ans = 0;
        int right = 0;
        for (int left = 1; left <= N; left++) {
            // 이동할 수 있는 위치 만큼 right 를 이동 시킨다.
            while (right < N && cnt[A[right + 1]] < 1) {
                right++;
                cnt[A[right]] += 1;
            }

            // 정답 갱신
            ans += right - left + 1;

            // left 값 이동에 따른 cnt 값 변경
            cnt[A[left]] -= 1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
