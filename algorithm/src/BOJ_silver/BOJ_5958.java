package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_5958 {
    static int N;
    static char[][] map;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '*') {
                    map[nr][nc] = '.';
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        int ans = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == '*') {
                    ans += 1;
                    map[r][c] = '.';
                    q.add(new int[] { r, c });
                    bfs();
                }
            }
        }

        System.out.println(ans);
    }
}
