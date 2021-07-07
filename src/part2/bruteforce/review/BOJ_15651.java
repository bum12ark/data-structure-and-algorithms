package part2.bruteforce.review;

import part2.common.FastReader;

public class BOJ_15651 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    /**
     * N 개 중 중복을 허용해서 M 개를 순서있게 나열
     * @param numberDigit: 자리수
     */
    static void recFunc(int numberDigit) {
        // RecurrenceFunction (재귀 함수)
        // 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것!
        // 아직 M 개를 고르지 않음 => numberDigit 번째부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
        if (numberDigit == M + 1) {
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int cand = 1; cand <= N; cand++) {
            selected[numberDigit] = cand;
            // numberDigit + 1 번 ~ M 번을 모두 탐색하는 일을 해야 하는 상황
            recFunc(numberDigit + 1);
            // numberDigit 번째 원소에 대한 값을 재초기화
            selected[numberDigit] = 0;
        }

    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
}
