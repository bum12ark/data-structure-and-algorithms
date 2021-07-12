package part2.twopointer;

import part2.common.FastReader;

import java.util.Arrays;

/**
 * 두 용액
 */
public class BOJ_2470 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N;
    static int[] A;

    static void input() {
        N = fastReader.nextInt();
        A = new int[N];
        for (int n = 0; n < N; n++) A[n] = fastReader.nextInt();
    }

    static void pro() {
        // 최소, 최대 값을 빠르게 찾기 위해 오름차순 정렬
        Arrays.sort(A);

        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, left = 0, right = N - 1;

        while (left < right) { // L == R 인 상황이면 용액이 한개 뿐인 것이므로, L < R 일 때 까지만 반복한다.
            int leftVal = A[left];
            int rightVal = A[right];
            int sum = Math.abs(leftVal + rightVal);

            if (sum < bestSum) {
                bestSum = sum;
                v1 = leftVal;
                v2 = rightVal;
            }

            if (leftVal + rightVal < 0) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        sb.append(v1).append(" ").append(v2);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
