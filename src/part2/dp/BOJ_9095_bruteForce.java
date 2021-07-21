package part2.dp;

import java.util.ArrayList;
import java.util.List;

public class BOJ_9095_bruteForce {
    public List<Integer> selected = new ArrayList<>();

    public int dfs(int sum, int target) {
        if (sum == target) { // 가능 시 1 반환
            // System.out.println(selected);
            return 1;
        }

        if (sum > target) return 0; // 불가능한 경우 0 반환

        int count = 0;
        for (int i = 1; i <= 3; i++) {
            selected.add(i);
            count += dfs(sum + i, target);
            selected.remove(selected.size() - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        BOJ_9095_bruteForce main = new BOJ_9095_bruteForce();
        int answer = main.dfs(0, 4);
        System.out.println(answer);
    }
}
