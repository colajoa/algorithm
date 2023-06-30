package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int top = -1;

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            switch (token.nextToken()) {

                case "push":
                    stack[++top] = Integer.parseInt(token.nextToken());
                    break;
                case "pop":
                    int pop = -1;
                    if (top != -1) {
                        pop = stack[top];
                        stack[top--] = 0;
                    }
                    sb.append(pop).append("\n");
                    break;
                case "size":
                    sb.append(top + 1).append("\n");
                    break;
                case "empty":
                    sb.append(top == -1 ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(top == -1 ? -1 : stack[top]).append("\n");
                    break;
            }
        }
        bw.append(sb);
        bw.close();
    }
}
