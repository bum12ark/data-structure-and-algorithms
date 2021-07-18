package part2.tree.practice;

import part2.common.FastReader;

import java.util.Arrays;


/* 트리 순회 */
public class BOJ_1991 {
    static FastReader scan = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int n;
    static int[][] childs;

    static void input() {
        n = scan.nextInt();
        childs = new int[30][2];
        for (int i = 0; i < n; i++) {
            char curCh = scan.next().charAt(0);
            int cur = (int)(curCh - 'A');
            for (int k = 0; k < 2; k++) {
                char ch = scan.next().charAt(0);
                if (ch != '.') childs[cur][k] = (int)(ch - 'A');
                else childs[cur][k] = -1;
            }
        }
    }


    static void preOrder(int x) {
        if (x == -1) return;
        sb.append((char) (x + 'A'));
        preOrder(childs[x][0]);
        preOrder(childs[x][1]);
    }

    static void inOrder(int x) {
        if (x == -1) return;
        inOrder(childs[x][0]);
        sb.append((char) (x + 'A'));
        inOrder(childs[x][1]);
    }

    static void postOrder(int x) {
        if (x == -1) return;
        postOrder(childs[x][0]);
        postOrder(childs[x][1]);
        sb.append((char) (x + 'A'));
    }

    static void solution() {
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
