package mockexam.ryu.set3;

import part2.common.FastReader;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* 정보 상인 호석 */
public class BOJ_22252 {
    static FastReader fastReader = new FastReader();

    static int Q; // 쿼리의 수
    static Map<String, PriorityQueue<Integer>> infoMap = new HashMap<>();

    static void input() {
        Q = fastReader.nextInt();
    }

    static PriorityQueue<Integer> getInfoMap(String key) {
        if (!infoMap.containsKey(key)) {
            PriorityQueue<Integer> ret = new PriorityQueue<>(Comparator.reverseOrder());
            infoMap.put(key, ret);
            return ret;
        }
        return infoMap.get(key);
    }

    static void process() {
        long ans = 0;
        while (Q-- > 0) {
            int command = fastReader.nextInt();
            String name = fastReader.next();
            PriorityQueue<Integer> maxHeap = getInfoMap(name);
            int cnt = fastReader.nextInt();
            if (command == 1) {
                while (cnt-- > 0) {
                    maxHeap.add(fastReader.nextInt());
                }
            } else if (command == 2) {
                while (cnt-- > 0 && !maxHeap.isEmpty()) {
                    ans += maxHeap.poll();
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
