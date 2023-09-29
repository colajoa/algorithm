package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_14562 {
    static int C, S, T;
    static StringBuilder sb = new StringBuilder();
    static Queue<Point> q;

    static class Point {
        int A, B, cnt;

        public Point(int A, int B, int cnt) {
            this.A = A;
            this.B = B;
            this.cnt = cnt;
        }
    }

    static void bfs() {

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.A == now.B) {
                sb.append(now.cnt).append("\n");
                return;
            }

            if (now.A > now.B)
                continue;

            q.add(new Point(now.A * 2, now.B + 3, now.cnt + 1));
            q.add(new Point(now.A + 1, now.B, now.cnt + 1));

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        C = Integer.parseInt(br.readLine());

        for (int c = 0; c < C; c++) {
            token = new StringTokenizer(br.readLine());

            S = Integer.parseInt(token.nextToken());
            T = Integer.parseInt(token.nextToken());

            q = new ArrayDeque<>();
            q.add(new Point(S, T, 0));
            bfs();

        }
        System.out.println(sb);
    }
}
