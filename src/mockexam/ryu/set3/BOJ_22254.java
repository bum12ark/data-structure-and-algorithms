package mockexam.ryu.set3;

import part2.common.FastReader;

import java.util.PriorityQueue;

/* 공정 컨설턴트 호석 */
public class BOJ_22254 {
    static FastReader fastReader = new FastReader();

    static int N, X; // 선물 주문의 개수, 완료까지 남은 시간
    static int[] processTime; // 공정 시간

    static void input() {
        N = fastReader.nextInt();
        X = fastReader.nextInt();
        processTime = new int[N];
        for (int i = 0; i < N; i++) processTime[i] = fastReader.nextInt();
    }

    static boolean determination(int lineNum) {
        PriorityQueue<Integer> processLine = new PriorityQueue<>();
        for (int i = 0; i < lineNum; i++) processLine.add(0);

        for (int time : processTime) {
            int lineTime = processLine.poll();
            int nextLineTime = lineTime + time;
            if (nextLineTime > X) return false;
            processLine.add(nextLineTime);
        }

        return true;
    }

    static void process() {
        int left = 1, right = N;
        long ans = N;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (determination(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
