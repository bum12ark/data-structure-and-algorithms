package part2.dp;

import part2.common.FastReader;

import java.util.Arrays;

/* 파일 합치기 */
public class BOJ_11066 {
    static FastReader fastReader = new FastReader();

    static int T, K; // 테스트 데이터의 개수, 소슬을 구성하는 장의 수
    static int[] fileSizes; // 파일의 크기들
    static int[][] sum, dp; // i ~ j 까지의  파일을 합치는데 드는 비용

    static void input() {
        K = fastReader.nextInt();
        fileSizes = new int[K + 1];
        sum = new int[K + 1][K + 1];
        for (int k = 1; k <= K; k++) {
            fileSizes[k] = fastReader.nextInt();
        }
    }

    static void preprocess() {
        for (int i = 1; i <= K; i++) {
            for (int j = i; j <= K; j++) {
                sum[i][j] = sum[i][j - 1] + fileSizes[j];
            }
        }
        for (int i = 1; i <= K; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }
    }

    static void proecess() {
        preprocess();
        dp = new int[K + 1][K + 1];

        for (int len = 2; len <= K; len ++) {
            for (int i = 1; i <= K - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)  {
                    System.out.println("dp[i][j]: " + i + ", " + j);
                    System.out.println("dp[i][k]: " + i + ", " + k);
                    System.out.println("dp[k + 1][j]: " + (k + 1) + ", " + j);
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[i][j]);

                    for (int x = 1; x <= K; x++) {
                        System.out.println(Arrays.toString(dp[x]));
                    }
                    System.out.println("================");
                }
            }
        }
    }

    public static void main(String[] args) {
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            proecess();
        }
    }
}

/*
1
4
40 30 30 50
 */
