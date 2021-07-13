package part2.twopointer.review;

import part2.common.FastReader;

/* 고냥이 */
public class BOJ_16472 {
    static FastReader fastReader = new FastReader();

    static int N, kind;
    static String A;
    static int[] cnt;

    static void input() {
        N = fastReader.nextInt();
        A = fastReader.nextLine();
        cnt = new int[26];
        kind = 0;
    }

    static void add(char x) { // X 라는 알파벳 추가
        int index = x - 'a';
        if (cnt[index] == 0) {
            kind += 1;
        }
        cnt[index] += 1;
    }

    static void erase(char x) { // x 라는 알파벳 제거
        int index = x - 'a';
        cnt[index] -= 1;
        if (cnt[index] == 0) {
            kind -= 1;
        }
    }

    static void solution() {
        int len = A.length(), ans = Integer.MIN_VALUE;
        for (int right = 0, left = 0; right < len; right++) {
            // R 번째 문자를 오른쪽에 추가
            add(A.charAt(right));

            // 불가능하면, 가능할 때 까지 L을 이동
            while (kind > N) {
                erase(A.charAt(left++));
            }

            // 정답 갱신
            ans = Math.max(ans, right - left + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
