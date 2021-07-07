package part2.binarysearch;

import part2.common.FastReader;

import java.util.Arrays;

public class BOJ_7795 {
    static FastReader fastReader = new FastReader();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        A = new int[N];
        B = new int[M];
        for (int i = 0; i < N; i++) A[i] = fastReader.nextInt();
        for (int i = 0; i < M; i++) B[i] = fastReader.nextInt();
    }

    static int N, M;
    static int[] A, B;

    static int lowerBound(int[] A, int x, int lo, int hi) {
        // 없을 때의 값을 잘 설정하는 것이 중요하다.
        int result = lo - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] < x) {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    static int solution() {
        // 탐색 대상 오름차순 정렬
        Arrays.sort(B);
        int answer = 0;

        for (int index = 0; index < N; index++) {
            answer += lowerBound(B, A[index], 0, M - 1) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int T;
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            System.out.println(solution());
        }
    }
}
