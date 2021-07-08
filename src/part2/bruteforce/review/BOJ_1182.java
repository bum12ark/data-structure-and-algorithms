package part2.bruteforce.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1182 {

    static int N, S, ans;
    static int[] nums, selected;

    static void recFunc(int k) {
        if (k == N) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        selected[k] = nums[k];
        recFunc(k + 1);
        selected[k] = 0;
        recFunc(k + 1);
    }

    public static void main(String[] args) {
        N = 3;
        S = 0;
        nums = new int[] {1, 2, 3};
        selected = new int[N];
        recFunc(0);
        System.out.println("ans: " + ans);
    }
}
