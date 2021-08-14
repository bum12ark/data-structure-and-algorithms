package mockexam.ryu.set2;

import part2.common.FastReader;

import java.util.*;

/* 폰 호석만 */
public class BOJ_21275 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String A, B;
    // 각 진법마다의 나올 수 있는 최대 수를 기록하는 map, 해당 char 값에 대한 10진법 수를 기록
    static Map<Character, Integer> limit = new HashMap<>();

    static void input() {
        A = fastReader.next();
        B = fastReader.next();
    }

    static int conversion(char x) {
        return limit.get(x);
    }

    // base 진법의 str 수를 10진법으로 변환하는 함수
    static long possible(String str, int base) {
        // 진법 계산
        long ans = 0;
        for (char c : str.toCharArray()) {
            if (conversion(c) >= base) return -1;
            ans = ans * base + conversion(c);
        }
        return ans;
    }

    static void process() {
        for (int i = 0; i < 10; i++) {
            limit.put((char) ('0' + i), i);
        }
        for (int i = 0; i < 26; i++) {
            limit.put((char) ('a' + i), i+ 10);
        }

        int ans = 0;
        long ansBaseA = 0, ansBaseB = 0, ansNum = 0;
        for (int base = 2; base <= 36; base++) {
            long possible = possible(A, base);
            for (int base2 = 2; base2 <= 36; base2++) {
                long possible2 = possible(B, base2);
                // 진법 변환보다 큰 수 일 경우 무시한다.
                if (possible == -1 || possible2 == -1) continue;
                if (possible == possible2 && base != base2) {
                    ans++;
                    ansBaseA = base;
                    ansBaseB = base2;
                    ansNum = possible;
                }
            }
        }

        if (ans == 1) {
            System.out.println(ansNum + " " + ansBaseA + " " + ansBaseB);
        } else if (ans > 1) {
            System.out.println("Multiple");
        } else {
            System.out.println("Impossible");
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
