package part2.bruteforce;

import part2.common.FastReader;

import java.util.Arrays;

public class BOJ_1182 {
    static FastReader fastReader = new FastReader();

    static void input() {
        N = fastReader.nextInt();
        S = fastReader.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = fastReader.nextInt();

    }

    static int N, S;
    static int[] nums;

    public static void main(String[] args) {
        input();
        System.out.println(N + " " + S);
        System.out.println(Arrays.toString(nums));
    }
}
