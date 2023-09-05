package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_16953 {
    static int A, B;
    static long ans = -1;

    static void bfs(int A) {
        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[] { A, 0 });

        while (!q.isEmpty()) {
            long[] now = q.poll();

            if (B == now[0]) {
                ans = now[1] + 1;
                return;
            }

            long op = now[0] * 2;
            if (op <= B) {
                q.add(new long[] { op, now[1] + 1 });
            }

            op = Long.parseLong(String.valueOf(now[0]) + 1);
            if (op <= B) {
                q.add(new long[] { op, now[1] + 1 });
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());

        bfs(A);

        System.out.println(ans);
    }
}
