package part2.bruteforce;

import part2.common.FastReader;

public class BOJ_14888 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        orders = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, orders;


    static int calculator() {
        int value = nums[1];
        for (int i = 1; i <= N - 1; i++) {
            if (orders[i] == 1) {
                value += nums[i + 1];
            } else if (orders[i] == 2) {
                value -= nums[i + 1];
            } else if (orders[i] == 3) {
                value *= nums[i + 1];
            } else if (orders[i] == 4) {
                value /= nums[i + 1];
            }
        }
        return value;
    }

    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void recFunc(int k) {
        if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
            // 정한 연산자 순서대로 계산해서 정답을 갱신하기
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        // k 번째 연산자는 무엇을 선택할 것인가?
        for (int cand = 1; cand <= 4; cand++) {
            // 4가지 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출하기기
            if (operators[cand] > 0) {
                operators[cand] -= 1;
                orders[k] = cand;
                recFunc(k + 1);
                operators[cand] += 1;
                orders[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(max);
        System.out.println(min);
    }
}
