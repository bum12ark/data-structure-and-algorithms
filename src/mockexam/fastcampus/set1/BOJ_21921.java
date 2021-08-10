package mockexam.fastcampus.set1;

import part2.common.FastReader;

/* 블로그 */
public class BOJ_21921 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, X; // 블로그를 시작한 일 수, 방문일자 기간
    static int[] visitors;

    static void input() {
        N = fastReader.nextInt();
        X = fastReader.nextInt();
        visitors = new int[N];
        for (int i = 0; i < N; i++) visitors[i] = fastReader.nextInt();
    }


    static void process() {
        int end = 0, sum = 0, max = 0, cnt = 0;
        for (int start = 0; start <= N - X; start++) {
            while (end - start < X) {
                sum += visitors[end++];
            }

            if (max < sum) {
                max = sum;
                cnt = 1;
            } else if (max == sum) cnt += 1;

            // 슬라이딩 윈도우 제일 왼쪽 값 삭제
            sum -= visitors[start];
        }

        if (max == 0) sb.append("SAD");
        else sb.append(max).append(" ").append(cnt);

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
