package mockexam.set1;

import part2.common.FastReader;

/* 전구 */
public class BOJ_21918 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 전구의 개수, 명령어의 개수
    static int[] bulb;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        bulb = new int[N + 1];
        for (int i = 1; i <= N; i++) bulb[i] = fastReader.nextInt();
    }

    static void commandOne(int i, int x) {
        bulb[i] = x;
    }

    static void commandOthers(int a, int l, int r) {
        if (a == 2) {
            for (int index = l; index <= r; index++) {
                if (bulb[index] == 0) {
                    bulb[index] = 1;
                } else {
                    bulb[index] = 0;
                }
            }
            return;
        }

        if (a == 3) {
            for (int index = l; index <= r; index++) {
                bulb[index] = 0;
            }
            return;
        }

        if (a == 4) {
            for (int index = l; index <= r; index++) {
                bulb[index] = 1;
            }
            return;
        }
    }

    static void process() {
        for (int m = 0; m < M; m++) {
            int a = fastReader.nextInt();
            if (a == 1) {
                int i = fastReader.nextInt();
                int x = fastReader.nextInt();
                commandOne(i, x);
            } else {
                int l = fastReader.nextInt();
                int r = fastReader.nextInt();
                commandOthers(a, l, r);
            }
        }

        for (int i = 1; i <= N; i++) sb.append(bulb[i]).append(" ");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
