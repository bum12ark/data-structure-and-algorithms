package part2.binarysearch.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 숫자 카드 2 */
public class BOJ_10816 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B; // 상근이가 가지고 있는 숫자카드, 타겟 숫자 카드

    static void input() {
        N = fastReader.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = fastReader.nextInt();

        M = fastReader.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) B[i] = fastReader.nextInt();
    }

    // 찾고자 하는 값 이상이 처음으로 나오는 인덱스를 리턴
    // 찾고자 하는 값이 없을 경우 마지막 인덱스 + 1을 리턴
    static int lowerBound(int[] arr, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치
    // 찾고자 하는 값이 없을 경우 마지막 인덱스 + 1을 리턴
    static int upperBound(int[] arr, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static void process() {
        Arrays.sort(A);

        for (int num : B) {
            int lower = lowerBound(A, 0, N - 1, num);
            int upper = upperBound(A, 0, N - 1, num);
            sb.append(upper - lower).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
