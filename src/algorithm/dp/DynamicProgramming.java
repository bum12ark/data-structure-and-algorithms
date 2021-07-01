package algorithm.dp;

public class DynamicProgramming {
    public int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public int fibonacciDp(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < n + 1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.fibonacciRecursive(8));
        System.out.println(dp.fibonacciDp(8));
    }
}
