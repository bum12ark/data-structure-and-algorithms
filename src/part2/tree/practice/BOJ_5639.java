package part2.tree.practice;

import part2.common.FastReader;

/* 이진 검색 트리 */
public class BOJ_5639 {
    static class TreeNode {
        int node;
        TreeNode left;
        TreeNode right;

        public TreeNode(int node) {
            this.node = node;
        }

        public void insert(int n) {
            if (n < this.node) {
                if (left == null) {
                    this.left = new TreeNode(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (right == null) {
                    this.right = new TreeNode(n);
                } else {
                    this.right.insert(n);
                }
            }
        }

        @Override
        public String toString() {
            return "[" + node + ", " + left + ", " + right + "]";
        }
    }

    static FastReader fastReader = new FastReader();
    static TreeNode root;

    static void input() {
        root = new TreeNode(fastReader.nextInt());

        while (true) {
            String n = fastReader.nextLine();
            if (n == null || n.equals("")) break;
            root.insert(Integer.parseInt(n));
        }
    }

    static void postOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.node);
    }

    static void solution() {
        postOrder(root);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
