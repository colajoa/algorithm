package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2161 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        for (int n = 1; n < N + 1; n++) {
            q.add(n);
        }

        while (!q.isEmpty()) {
            sb.append(q.poll()).append(" ");

            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }

        System.out.println(sb);
    }
}
