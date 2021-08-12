package mockexam.ryu.set1;

import part2.common.FastReader;

/* 꿈틀꿈틀 호석 애벌레 */
public class BOJ_20181_bruteforce {
    static FastReader fastReader = new FastReader();

    static int N, K, ans; // 먹이 개수, 최소만족도
    static int[] foods; // 먹이의 만족도

    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        foods = new int[N + 1];
        for (int i = 1; i <= N; i++) foods[i] = fastReader.nextInt();
    }

    static void dfs(int index, int energy) {
        if (index == N + 1) {
            ans = Math.max(ans, energy);
            return;
        }

        int sum = 0;
        for (int right = index; right <= N; right++) {
            sum += foods[right];
            // 먹이 이상이 될 경우 다음 인덱스부터 탐색
            if (sum >= K) {
                dfs(right + 1, energy + (sum - K));
                break;
            }
        }

        // 나를 선택하지 않는 경우
        dfs(index + 1, energy);
    }

    static void process() {
        dfs(1, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
