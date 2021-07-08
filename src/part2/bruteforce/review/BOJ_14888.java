package part2.bruteforce.review;

import part2.common.FastReader;

public class BOJ_14888 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N, max, min;
    static int[] nums, operators;

    static void input() {
        N = fastReader.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = fastReader.nextInt();
        operators = new int[4];
        for (int i = 0; i < 4; i++) operators[i] = fastReader.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 0) {
            return operand1 + operand2;
        }
        if (operator == 1) {
            return operand1 - operand2;
        }
        if (operator == 2) {
            return operand1 * operand2;
        }
        if (operator == 3) {
            return operand1 / operand2;
        }
        return 0;
    }

    static void recFunc(int k, int value) {
        if (k == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int cand = 0; cand < 4; cand++) {
            if (operators[cand] <= 0) {
                continue;
            }
            operators[cand] -= 1;
            int newValue = calculator(value, cand, nums[k + 1]);
            recFunc(k + 1, newValue);
            operators[cand] += 1;
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(0, nums[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }
}
