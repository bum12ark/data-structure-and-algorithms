package part2.twopointer.practice;


import part2.common.FastReader;

public class BOJ_2559 {
    static FastReader fastReader = new FastReader();

    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        nums = new int[N];
        for (int n = 0; n < N; n++) nums[n] = fastReader.nextInt();
    }

    static int N, K;
    static int[] nums;

    static int pro() {
        int right = -1, maxSum = Integer.MIN_VALUE, sum = 0;

        for (int left = 0; left <= N - K; left++) {
            // right 값을 연속적인 날짜의 수 까지 더해준다.
            while (right < left + K - 1) {
                sum += nums[++right];
            }

            // 연속적인 K일의 온도의 합이 최대가 되는 값으로 초기화
            maxSum = Math.max(maxSum, sum);

            // left 포인터 증가에 따른 sum 값 갱신 (left 을 구간에서 제외)
            sum -= nums[left];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        input();
        int answer = pro();
        System.out.println(answer);
    }
}
