package mockexam.fastcampus.set2;

import part2.common.FastReader;

import java.util.*;

public class BOJ_21939_Advanced {
    static class Question {
        int num;
        int difficulty;

        public Question(int num, int difficulty) {
            this.num = num;
            this.difficulty = difficulty;
        }

        @Override
        public String toString() {
            return "[" + this.num + ", " + this.difficulty + "]";
        }

    }

    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 문제의 개수, 명령문의 개수
    static PriorityQueue<Question> maxHeap = new PriorityQueue<>((o1, o2) -> {
        if (o1.difficulty != o2.difficulty) {
            return Integer.compare(o2.difficulty, o1.difficulty);
        }
        return Integer.compare(o2.num, o1.num);
    });
    static PriorityQueue<Question> minHeap = new PriorityQueue<>((o1, o2) -> {
        if (o1.difficulty != o2.difficulty) {
            return Integer.compare(o1.difficulty, o2.difficulty);
        }
        return Integer.compare(o1.num, o2.num);
    });
    static Map<Integer, Question> map = new HashMap<>(); // 문제의 번호와 난이도를 기록하는 map

    static void input() {
        N = fastReader.nextInt();
        for (int i = 0; i < N; i++) {
            int P = fastReader.nextInt();
            int L = fastReader.nextInt();
            Question question = new Question(P, L);
            maxHeap.add(question);
            minHeap.add(question);
            map.put(P, question);
        }
        M = fastReader.nextInt();
    }

    static void add(int num, int difficulty) {
        Question question = new Question(num, difficulty);
        maxHeap.add(question);
        minHeap.add(question);
        map.put(num, question);
    }

    static int recommend(int x) {
        if (x == 1) {
            Question question = Objects.requireNonNull(maxHeap.peek());
            return question.num;
        }
        if (x == -1) {
            Question question = Objects.requireNonNull(minHeap.peek());
            return question.num;
        }
        return -1;
    }

    static void solved(int num) {
        Question question = map.get(num);
        map.remove(num);
        maxHeap.remove(question);
        minHeap.remove(question);
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
