package mockexam.ryu.set1;

import part2.common.FastReader;

/* 홀수 홀릭 호석 */
public class BOJ_20164 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N; // 호석이가 가진 수
    static int maxAns = Integer.MIN_VALUE, minAns = Integer.MAX_VALUE;

    static void input() {
        N = fastReader.nextInt();
    }

    // 홀수의 개수를 리턴하는 함수
    static int getOddCnt(int x) {
        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            if (digit % 2 == 1) res++;
            x /= 10;
        }
        return res;
    }

    static void dfs(int x, int totalOddCnt) {
        if (x <= 9) { // x가 한자리 수 일 경우
            maxAns = Math.max(maxAns, totalOddCnt);
            minAns = Math.min(minAns, totalOddCnt);
            return;
        }

        if (x <= 99) { // x가 두자리 수 일 경우
            int nextX = (x / 10) + (x % 10);
            dfs(nextX, getOddCnt(nextX) + totalOddCnt);
            return;
        }

        // x가 3자리 이상일 경우 가능한 모든 경우의 수 완전 탐색
        String s = String.valueOf(x);
        for (int i = 0; i <= s.length() - 3; i++) {
            for (int j = i + 1; j <= s.length() - 2; j++) {
                String firstSub = s.substring(0, i + 1);
                String secondSub = s.substring(i + 1, j + 1);
                String thirdSub = s.substring(j + 1, s.length());

                int nextX = Integer.parseInt(firstSub) + Integer.parseInt(secondSub) + Integer.parseInt(thirdSub);
                dfs(nextX, getOddCnt(nextX) + totalOddCnt);
            }
        }
    }

    static void process() {
        // 완전 탐색 시작
        dfs(N, getOddCnt(N));

        // 정답 출력
        sb.append(minAns).append(" ").append(maxAns);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
