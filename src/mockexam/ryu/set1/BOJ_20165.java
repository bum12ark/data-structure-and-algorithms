package mockexam.ryu.set1;

import part2.common.FastReader;

import java.util.*;

/* 인내의 도미노 장인 호석 */
public class BOJ_20165 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, R, ans; // 행 개수, 열 개수, 라운드 횟수
    static int[][] gameBoard;
    static int[][] backup;
    static Map<Character, int[]> dirMap = new HashMap<>();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        R = fastReader.nextInt();

        gameBoard = new int[N + 1][M + 1];
        backup = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                gameBoard[i][j] = fastReader.nextInt();
                backup[i][j] = gameBoard[i][j];
            }
        }

        // direction 초기화
        dirMap.put('N', new int[] {-1, 0});
        dirMap.put('S', new int[] {1, 0});
        dirMap.put('W', new int[] {0, -1});
        dirMap.put('E', new int[] {0, 1});
    }

    static void attack(int x, int y, char dir) {
        if (gameBoard[x][y] == 0) return;
        int count = gameBoard[x][y]; // 앞으로 이동해야할 횟수

        int dx = dirMap.get(dir)[0];
        int dy = dirMap.get(dir)[1];
        // 이동 가능한 위치 안이면서 count - 1 만큼 이동 가능하다면
        while (x >= 1 && y >= 1 && x <= N && y <= M
                && count >= 1) {
            // 점수 갱신
            if (gameBoard[x][y] > 0) ans += 1;

            // 이번에 넘어진 도미노에 의해서, 넘어져야 하는 거리가 더 길어지는 경우를 확인!
            count = Math.max(count - 1, gameBoard[x][y] - 1);

            // 도미노를 넘어뜨림
            gameBoard[x][y] = 0;

            // 다음 방향으로 이동
            x += dx;
            y += dy;
        }
    }

    static void defence(int x, int y) {
        gameBoard[x][y] = backup[x][y];
    }

    static void process() {
        for (int round = 0; round < R; round++) {
            // 공격자 턴
            int attackX = fastReader.nextInt();
            int attackY = fastReader.nextInt();
            char dir = fastReader.next().charAt(0);
            attack(attackX, attackY, dir);

            // 수비자 턴
            int defenceX = fastReader.nextInt();
            int defenceY = fastReader.nextInt();
            defence(defenceX, defenceY);
        }

        sb.append(ans).append("\n");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (gameBoard[i][j] > 0) sb.append("S").append(" ");
                else sb.append("F").append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
