package part1.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public void dfs(int N, int currentRow, List<Integer> currentCandidate) {
        if (N == currentRow) { // 탈출문
            System.out.println(currentCandidate);
            return;
        }

        for (int index = 0; index < N; index++) {
            if (isAvailable(currentCandidate, index)) {
                currentCandidate.add(index);
                this.dfs(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    private boolean isAvailable(List<Integer> candidate, int currentCol) {
        int currentRow = candidate.size();
        for (int index = 0; index < currentRow; index++) {
            if ((candidate.get(index) == currentCol)
                    || Math.abs(candidate.get(index) - currentCol) == currentRow - index) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.dfs(4, 0, new ArrayList<>());
    }
}
