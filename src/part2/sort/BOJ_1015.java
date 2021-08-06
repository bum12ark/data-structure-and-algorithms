package part2.sort;

import part2.common.FastReader;

import java.util.Arrays;

/* 수열 정렬 */
public class BOJ_1015 {
    static class Elem implements Comparable<Elem> {
        int num;
        int index;

        public Elem(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Elem others) {
            if (num != others.num) {
                return num - others.num;
            }
            return index - others.index;
        }
    }

    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Elem[] B;
    static int[] P;

    static void input() {
        N = fastReader.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int index = 0; index < N; index++) {
            int value = fastReader.nextInt();
            B[index] = new Elem(value, index);
        }
    }

    static void process() {
        // TODO: B 배열 정렬하기
        Arrays.sort(B);

        // TODO: B 배열의 값을 이용해서 P 배열 채우기
        for (int bIndex = 0; bIndex < N; bIndex++) {
            P[B[bIndex].index] = bIndex;
        }

        // TODO: P 배열 출력하기기
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
