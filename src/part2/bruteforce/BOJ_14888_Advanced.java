package part2.bruteforce;

import part2.common.FastReader;

public class BOJ_14888_Advanced {
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

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        }
        if (operator == 2) {
            return operand1 - operand2;
        }
        if (operator == 3) {
            return operand1 * operand2;
        }
        if (operator == 4) {
            return operand1 / operand2;
        }
        return 0;
    }

    static void recFunc(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int cand = 1; cand <= 4; cand++) {
            if (operators[cand] > 0) {
                operators[cand] -= 1;
                int newValue = calculator(value, cand, nums[k + 1]);
                recFunc(k + 1, newValue);
                operators[cand] += 1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
    }
}
