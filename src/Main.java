import java.io.*;
import java.util.*;

public class Main {
    static FastReader fastReader = new FastReader();
    // TODO code start!
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    /**
     * N 개 중 중복없이 M 개를 고르기
     * @param numberDigit: 자리수
     */
    static void recFunc(int numberDigit) {
        if (numberDigit == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int cand = selected[numberDigit - 1] + 1; cand <= N; cand++) {
            selected[numberDigit] = cand;
            recFunc(numberDigit + 1);
            selected[numberDigit] = 0;
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
    // TODO code end!

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
