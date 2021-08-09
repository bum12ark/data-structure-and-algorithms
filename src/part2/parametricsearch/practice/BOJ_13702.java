package part2.parametricsearch.practice;

import part2.common.FastReader;

/* 이상한 술집 */
public class BOJ_13702 {
    static FastReader fastReader = new FastReader();
    
    static int N, K; // 주전자의 개수, 친구들의 수
    static int[] makgeolli;
    
    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        makgeolli = new int[N];
        for (int i = 0; i < N; i++) makgeolli[i] = fastReader.nextInt();
    }
    
    static boolean determination(int ml) {
        int sum = 0, cnt = 0;
        for (int volume : makgeolli) {
            cnt += volume / ml;
        }
        return cnt >= K;
    }
    
    static void process() {
        int left = 0, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (determination(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
