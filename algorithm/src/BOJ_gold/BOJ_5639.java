package BOJ_gold;

import java.io.*;

public class BOJ_5639 {
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;

    static class Node {
        int left, right;

        public Node() {
        }

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static void setTree(int num, int root) {

        if (root > num) {
            if (tree[root].left == -1) {
                tree[root].left = num;
                return;
            }
            setTree(num, tree[root].left);
        } else {
            if (tree[root].right == -1) {
                tree[root].right = num;
                return;
            }
            setTree(num, tree[root].right);
        }

    }

    static void postorder(int node) {
        if (node != -1) {
            postorder(tree[node].left);
            postorder(tree[node].right);
            sb.append(node).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        tree = new Node[1000001];

        int num = 0;
        int root = Integer.parseInt(br.readLine());
        tree[root] = new Node(-1, -1);

        while (true) {
            str = br.readLine();
            if (str == null || str.equals(""))
                break;
            num = Integer.parseInt(str);
            tree[num] = new Node(-1, -1);
            setTree(num, root);
        }

        postorder(root);
        System.out.println(sb);
    }
}
