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

    static int N, S, ans;
    static int[] nums;

    static void recFunc(int k, int value) {
        if (k == N) {
            if (value == S) ans++;
            return;
        }

        recFunc(k + 1, value + nums[k]);
        recFunc(k + 1, value);
    }

    public static void main(String[] args) {
        input();
        recFunc(0, 0);
        if (S == 0) {
            ans--;
        }
        System.out.println(ans);
    }
}
