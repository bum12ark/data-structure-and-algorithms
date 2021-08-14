package mockexam.ryu.set2;

import part2.common.FastReader;

import java.util.*;

/* 계보 복원가 호석 */
public class BOJ_21276 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 살고 있는 사람의 수, 기억하는 정보의 개수
    static Map<String, List<String>> adjacents = new HashMap<>();
    static Map<String, Integer> indeg = new HashMap<>();
    // 복원한 그래프
    static TreeMap<String, List<String>> treeMap = new TreeMap<>();
    static List<String> roots = new ArrayList<>();

    static void input() {
        N = fastReader.nextInt();
        for (int i = 0; i < N; i++) {
            String father = fastReader.next();
            adjacents.put(father, new ArrayList<>());
            indeg.put(father, 0);
            treeMap.put(father, new ArrayList<>());
        }
        M = fastReader.nextInt();
        for (int i = 0; i < M; i++) {
            String descendants = fastReader.next(); // 자손
            String ancestor = fastReader.next(); // 조상
            adjacents.get(ancestor).add(descendants);
            indeg.put(descendants, indeg.get(descendants) + 1);
        }
    }

    static void process() {
        // 위상 정렬을 진행하며 원래 그래프 형태로 복원
        Deque<String> deque = new LinkedList<>();
        // 들어오는 간선이 없는 정점 찾기
        for (Map.Entry<String, Integer> entries : indeg.entrySet()) {
            if (entries.getValue() == 0) {
                deque.add(entries.getKey());
                roots.add(entries.getKey());
            }
        }

        while (!deque.isEmpty()) {
            String nextX = deque.poll();
            for (String adj : adjacents.get(nextX)) {
                indeg.put(adj, indeg.get(adj) - 1);
                if (indeg.get(adj) == 0) {
                    deque.add(adj);
                    treeMap.get(nextX).add(adj);
                }
            }
        }
    }

    static void print() {
        // 정답 출력
        Collections.sort(roots);
        sb.append(roots.size()).append("\n");
        for (String r : roots) {
            sb.append(r).append(" ");
        }
        sb.append("\n");
        for (Map.Entry<String, List<String>> entires : treeMap.entrySet()) {
            String key = entires.getKey();
            List<String> value = entires.getValue();
            Collections.sort(value);

            sb.append(key).append(" ")
                    .append(value.size()).append(" ");
            for (String child : value) {
                sb.append(child).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
        print();
    }

}
