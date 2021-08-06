package part2.sort.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 단어정렬 */
public class BOJ_1181 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] words;

    static void input() {
        N = fastReader.nextInt();
        words = new String[N];
        for (int index = 0; index < N; index++) {
            words[index] = fastReader.next();
        }
    }

    static void process() {
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() != o2.length()) { // 길이가 짧은 순서대로 오름차순
                return Integer.compare(o1.length(), o2.length());
            }
            return o1.compareTo(o2); // 사전순으로 오름차순
        });

        // 중복되지 않은 단어만 고르기
        sb.append(words[0]).append("\n");
        for (int index = 1; index < N; index++) {
            if (!words[index].equals(words[index - 1])) {
                sb.append(words[index]).append("\n");
            }
        }

        // 정답출력
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
