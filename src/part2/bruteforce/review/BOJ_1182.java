package part2.bruteforce.review;

import java.util.*;

public class BOJ_1182 {

    static int N, S, ans;
    static int[] nums;

    static void recFunc(int k, int value) {
        if (k >= N) {
            if (value == S) {
                ans++;
            }
            return;
        }

        recFunc(k + 1, value + nums[k]);
        recFunc(k + 1, value);
    }

    public static void main(String[] args) {
        N = 5; S = 0;
        nums = new int[] {-7, -3, -2, 5, 8};
        recFunc(0, 0);
        System.out.println(ans);
    }
}
