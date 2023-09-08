package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1991 {
    static int N;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static void preorder(int node) {
        if (node != -1) {
            sb.append((char) (node + 'A'));
            preorder(tree[node].left);
            preorder(tree[node].right);
        }
    }

    static void inorder(int node) {
        if (node != -1) {
            inorder(tree[node].left);
            sb.append((char) (node + 'A'));
            inorder(tree[node].right);
        }
    }

    static void postorder(int node) {
        if (node != -1) {
            postorder(tree[node].left);
            postorder(tree[node].right);
            sb.append((char) (node + 'A'));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            int root = token.nextToken().charAt(0) - 'A';
            char c = token.nextToken().charAt(0);
            int left = c - 'A';
            if (c == '.') {
                left = -1;
            }

            c = token.nextToken().charAt(0);
            int right = c - 'A';
            if (c == '.') {
                right = -1;
            }

            tree[root] = new Node(left, right);
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb);
    }
}
