package mockexam.fastcampus.set2;

import part2.common.FastReader;

import java.util.ArrayList;
import java.util.List;

/* 문제 추천 시스템 Version 1 */
public class BOJ_21939 {
    static class Question {
        int num;
        int difficulty;

        public Question(int num, int difficulty) {
            this.num = num;
            this.difficulty = difficulty;
        }
    }

    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 문제의 개수, 명령문의 개수
    static List<Question> questionList = new ArrayList<>();

    static void input() {
        N = fastReader.nextInt();
        for (int i = 0; i < N; i++) {
            int P = fastReader.nextInt();
            int L = fastReader.nextInt();
            questionList.add(new Question(P, L));
        }
        M = fastReader.nextInt();
    }

    static void add(int num, int difficulty) {
        questionList.add(new Question(num, difficulty));
    }

    static int recommend(int x) {
        if (x == 1) {
            questionList.sort((o1, o2) -> {
                if (o1.difficulty != o2.difficulty) {
                    return Integer.compare(o2.difficulty, o1.difficulty);
                }
                return Integer.compare(o2.num, o1.num);
            });
            return questionList.get(0).num;
        }
        if (x == -1) {
            questionList.sort((o1, o2) -> {
                if (o1.difficulty != o2.difficulty) {
                    return Integer.compare(o1.difficulty, o2.difficulty);
                }
                return Integer.compare(o1.num, o2.num);
            });
            return questionList.get(0).num;
        }
        return -1;
    }

    static void solved(int num) {
        questionList.removeIf(question -> num == question.num);
    }

    static void process() {
        for (int i = 0; i < M; i++) {
            String command = fastReader.next();
            if (command.equals("add")) {
                int num = fastReader.nextInt();
                int difficulty = fastReader.nextInt();
                add(num, difficulty);
            } else if (command.equals("recommend")) {
                int x = fastReader.nextInt();
                int res = recommend(x);
                sb.append(res).append("\n");
            } else if (command.equals("solved")) {
                int num = fastReader.nextInt();
                solved(num);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
