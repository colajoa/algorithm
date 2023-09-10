package BOJ_gold;

import java.io.*;

public class BOJ_5639 {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int data;
        Node left, right;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static void setTree(int num, Node node) {

        if (node.data > num) {
            if (node.left == null) {
                node.left = new Node(num, null, null);
                return;
            }
            setTree(num, node.left);
        } else {
            if (node.right == null) {
                node.right = new Node(num, null, null);
                return;
            }
            setTree(num, node.right);
        }

    }

    static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            sb.append(node.data).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        int num = 0;
        int root = Integer.parseInt(br.readLine());
        Node node = new Node(root, null, null);

        while (true) {
            str = br.readLine();
            if (str == null || str.equals(""))
                break;
            num = Integer.parseInt(str);
            setTree(num, node);
        }

        postorder(node);
        System.out.println(sb);
    }
}
