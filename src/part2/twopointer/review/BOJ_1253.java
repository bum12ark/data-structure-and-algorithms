package part2.twopointer.review;

import part2.common.FastReader;

import java.util.Arrays;

/**
 * 좋다 - 이분탐색
 */
public class BOJ_1253 {
    static FastReader fastReader = new FastReader();

    static int N;
    static int[] A;

    static void input() {
        N = fastReader.nextInt();
        A = new int[N];
        for (int n = 0; n < N; n++) A[n] = fastReader.nextInt();
    }

    // targetIdx 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
    static boolean possible(int targetIdx) {
        int left = 0, right = N - 1;
        int target = A[targetIdx];
        while (left < right) {
            if (left == targetIdx) left++;
            else if (right == targetIdx) right--;
            else {
                if (A[left] + A[right] < target) {
                    left++;
                } else if (A[left] + A[right] > target) {
                    right--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    static void pro() {
        // 최소, 최대를 빠르게 알기 위한 정렬
        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            // i 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
            if (possible(i)) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
