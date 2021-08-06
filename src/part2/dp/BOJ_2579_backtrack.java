package part2.dp;

import part2.common.FastReader;

import java.util.Stack;

public class BOJ_2579_backtrack {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }
    }
    
    static FastReader fastReader = new FastReader();

    static int N, ans;
    static int[] stairs;
    static int[][] dp;
    // backtrack
    static Pos[][] come;
    
    static void input() {
        N = fastReader.nextInt();
        dp = new int[N + 1][2];
        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = fastReader.nextInt();
        }
        // backtrack
        come = new Pos[N + 1][2];
    }

    static void process() {
        dp[1][0] = 0;
        dp[1][1] = stairs[1];

        // backtrack
        come[1][0] = new Pos(0, 0);
        come[1][1] = new Pos(0, 0);

        if (N >= 2) {
            dp[2][0] = stairs[2];
            dp[2][1] = stairs[1] + stairs[2];

            // backtrack
            come[2][0] = new Pos(0, 1);
            come[2][1] = new Pos(1, 0);
        }

        for (int index = 3; index <= N; index++) {
            dp[index][0] = Math.max(dp[index - 2][0], dp[index - 2][1]) + stairs[index];
            dp[index][1] = dp[index - 1][0] + stairs[index];

            // backtrack
            come[index][0] = dp[index - 2][0] > dp[index - 2][1] ? new Pos(index - 2, 0) : new Pos(index - 2, 1);
            come[index][1] = new Pos(index - 1, 0);
        }
        ans = Math.max(dp[N][0], dp[N][1]);
        System.out.println(ans);
    }

    static void backtrack() {
        // backtrack
        StringBuilder sb = new StringBuilder();
        Stack<Pos> stack = new Stack<>();

        Pos backtrack = dp[N][0] > dp[N][1] ? new Pos(N, 0) : new Pos(N, 1);
        while (backtrack != null) {
            stack.add(backtrack);
            backtrack = come[backtrack.x][backtrack.y];
        }

        while (!stack.isEmpty()) sb.append(stack.pop().x).append("->");

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        System.out.println("## answer ##");
        process();
        System.out.println("## backtrack result ##");
        backtrack();
    }
}
