package part2.twopointer;

import part2.common.FastReader;

import java.util.Arrays;

public class BOJ_16472 {
    static FastReader fastReader = new FastReader();

    static void input() {
        N = fastReader.nextInt();
        A = fastReader.nextLine();
        cnt = new int[26];
    }

    static int N, kind;
    static int[] cnt;
    static String A;

    static void add(char x) { // x 라는 알파벳 추가
        int cntIdx = x - 'a';
        if (cnt[cntIdx] == 0) {
            kind += 1;
        }
        cnt[cntIdx] += 1;
    }

    static void erase(char x) { // x 라는 알파벳 제거
        int cntIdx = x - 'a';
        cnt[cntIdx] -= 1;
        if (cnt[cntIdx] == 0) {
            kind -= 1;
        }
    }

    static int getKind(int rightIdx) { // 입력하기 전의 kind 숫자를 가져오는 메서드
        int cntIdx = A.charAt(rightIdx) - 'a';
        if (cnt[cntIdx] == 0) {
            return kind + 1;
        }
        return kind;
    }

    static void pro() {
        int right = -1, max = Integer.MIN_VALUE, len = A.length();
        for (int left = 0; left < len; left++) {
            while (right + 1 < len && getKind(right + 1) <= N) {
                right += 1;
                add(A.charAt(right));
            }

            max = Math.max(max, right - left + 1);

            erase(A.charAt(left));
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
