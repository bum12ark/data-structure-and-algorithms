
import java.io.*;
import java.util.*;

public class Main {
    static FastReader fastReader = new FastReader();
    // TODO code start!
    static StringBuffer sb = new StringBuffer();

    static int N;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int edge = fastReader.nextInt();
                if (edge == 1) graph.get(x).add(y);
            }
        }
    }

    static void dfs(int vertex) {
        // 나 자신에게도 갈 수 있는 지 판단하여야 하기 때문에
        // 방문 표시를 인접 그래프를 탐색하는 부분으로 이동
        for (Integer adj : graph.get(vertex)) {
            if (!visited[adj]) {
                visited[adj] = true;
                dfs(adj);
            }
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        // 나 자신에게도 갈 수 있는 지 판단하여야 하기 때문에
        // 방문 표시를 하지 않음

        while (!queue.isEmpty()) {
            Integer pollVertex = queue.poll();
            for (int adj : graph.get(pollVertex)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    static void solution() {
        for (int vertex = 0; vertex < N; vertex++) {
            visited = new boolean[N]; // 매번 visited 배열 초기화
            // dfs(vertex);
            bfs(vertex);
            for (int i = 0; i < N; i++) { // 갈 수 있는 정점 정답 갱신
                if (visited[i] == true) sb.append("1").append(" ");
                else sb.append("0").append(" ");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(sb);
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
