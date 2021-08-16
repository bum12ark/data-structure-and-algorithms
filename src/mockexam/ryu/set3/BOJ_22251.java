package mockexam.ryu.set3;

import part2.common.FastReader;

/* 빌런 호석 */
public class BOJ_22251 {
    static FastReader fastReader = new FastReader();

    static int N, K, P, X; // 층의 개수, 디스플레이의 자리수, 반전시킬 LED 개수, 멈춰있는 층
    static int[][] numflag = new int[10][7];

    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        P = fastReader.nextInt();
        X = fastReader.nextInt();
    }

    static void init() {
        numflag[0] = new int[] {1, 1, 1, 0, 1, 1, 1};
        numflag[1] = new int[] {0, 0, 1, 0, 0, 1, 0};
        numflag[2] = new int[] {1, 0, 1, 1, 1, 0, 1};
        numflag[3] = new int[] {1, 0, 1, 1, 0, 1, 1};
        numflag[4] = new int[] {0, 1, 1, 1, 0, 1, 0};
        numflag[5] = new int[] {1, 1, 0, 1, 0, 1, 1};
        numflag[6] = new int[] {1, 1, 0, 1, 1, 1, 1};
        numflag[7] = new int[] {1, 0, 1, 0, 0, 1, 0};
        numflag[8] = new int[] {1, 1, 1, 1, 1, 1, 1};
        numflag[9] = new int[] {1, 1, 1, 1, 0, 1, 1};
    }

    // 숫자 x 를 y 로 바꾸는 횟수
    static int changeLed(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if (numflag[x][i] != numflag[y][i]) {
                cnt++;
            }
        }
        return cnt;
    }

    // 수 x와 수 y의 LED 차이 개수
   static int changeNumber(int x, int y) {
        int res = 0;
        for (int rep = 1; rep <= K; rep++) { // 자리수 만큼 돌린다.
            res += changeLed(x % 10, y % 10);
            x /= 10;
            y /= 10;
        }
        return res;
    }

    static void process() {
        int ans = 0;
        for (int i = 0; i <= N; i++) {
            if (i == X) continue;
            if (changeNumber(i, X) <= P) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        init();
        input();
        process();
    }
}
