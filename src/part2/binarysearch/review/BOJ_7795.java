package part2.binarysearch.review;

import part2.common.FastReader;

import java.util.Arrays;

public class BOJ_7795 {
    static FastReader fastReader = new FastReader();

    static int T, N, M;
    static int[] A, B;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        A = new int[N];
        B = new int[M];
        for (int n = 0; n < N; n++) A[n] = fastReader.nextInt();
        for (int m = 0; m < M; m++) B[m] = fastReader.nextInt();
    }

    static int lowerBound(int[] array, int target, int left, int right) {
        // A[L...R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
        // 그런게 없다면 L - 1 을 리턴한다

        int res = left - 1; // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    static int process() {
        Arrays.sort(B);
        int ans = 0;

        for (int a : A) {
            // A[i] 를 선택했을 때, B 에서는 A[i] 보다 작은 게 몇 개나 있는지 count 하기
            ans += lowerBound(B, a, 0, M - 1) + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            System.out.println(process());
        }
    }
}
