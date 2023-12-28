package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15242 {
    static int sr, sc, er, ec;
    static int[] dr = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] dc = { -1, 1, -2, 2, -2, 2, -1, 1 };

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[8][8];
        visited[sr][sc] = true;
        q.add(new int[] { sr, sc, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == er && now[1] == ec) {
                return now[2];
            }

            for (int d = 0; d < 8; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc, now[2] + 1 });
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        sc = str.charAt(0) - 'a';
        sr = str.charAt(1) - '1';
        str = br.readLine();
        ec = str.charAt(0) - 'a';
        er = str.charAt(1) - '1';

        System.out.println(bfs());
    }
}
