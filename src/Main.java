
import java.io.*;
import java.util.*;

public class Main {
    static FastReader fastReader = new FastReader();
    // TODO code start!
    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        nums = new int[N];
        for (int n = 0; n < N; n++) nums[n] = fastReader.nextInt();
    }

    static int N, K;
    static int[] nums;

    static int pro() {
        int right = -1, sum = 0, ans = N + 1;
        for (int left = 0; left < N; left++) {
            // right 값 이동 가능 한 곳 까지 이동
            while (right < N - 1 && sum < K) {
                if (nums[++right] == 1) {
                    sum++;
                }
            }

            // K 까지 찾았을 경우 길이 비교
            if (sum == K) {
                ans = Math.min(ans, right - left + 1);
            }

            // left 값 sum 에서 제거
            if (nums[left] == 1) {
                sum--;
            }
        }

        return ans == N + 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        input();
        int answer = pro();
        System.out.println(answer);
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
