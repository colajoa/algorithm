package BOJ_gold;

import java.io.*;
import java.util.*;

// 비트마스킹으로 풀어보기
public class BOJ_10472 {
    static boolean[] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q;

    static class Point {
        int num, cnt;

        public Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.num == 0) {
                return now.cnt;
            }

            for (int n = 0; n < 9; n++) {
                int next = now.num ^ (1 << n);
                for (int d = 0; d < 4; d++) {
                    int nr = (n / 3) + dr[d];
                    int nc = (n % 3) + dc[d];

                    if (nr >= 0 && nr < 3 && nc >= 0 && nc < 3) {
                        int xor = (nr * 3) + nc;
                        next ^= (1 << xor);
                    }
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Point(next, now.cnt + 1));

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int num = 0;
            int two = 1;

            q = new ArrayDeque<>();
            visited = new boolean[512];
            for (int r = 0; r < 3; r++) {
                String str = br.readLine();
                for (int c = 0; c < 3; c++) {
                    if (str.charAt(c) == '*') {
                        num += two;
                    }
                    two *= 2;
                }
            }
            visited[num] = true;
            q.add(new Point(num, 0));
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }
}
