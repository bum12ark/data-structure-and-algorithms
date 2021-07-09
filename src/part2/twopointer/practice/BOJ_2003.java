package part2.twopointer.practice;

import part2.common.FastReader;

public class BOJ_2003 {
    static FastReader fastReader = new FastReader();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = fastReader.nextInt();
    }

    static int N, M;
    static int[] nums;

    static int pro() {
        int right = -1, sum = 0, ans = 0;
        for (int left = 0; left < N; left++) {
            // right 를 옮길 수 있을 때 까지 옮기기
            while (right < N - 1 && sum < M) {
                sum += nums[++right];
            }

            // [left ... right] 의 합, 즉 sum 이 조건을 만족하면 정답 갱신하기
            if (sum == M) {
                ans++;
            }

            // left 을 구간에서 제외하기
            sum -= nums[left];
        }
        return ans;
    }

    public static void main(String[] args) {
        input();
        int answer = pro();
        System.out.println(answer);
    }
}
