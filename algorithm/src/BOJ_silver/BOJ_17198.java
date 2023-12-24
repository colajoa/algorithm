package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_17198 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sr = 0, sc = 0;
        char[][] map = new char[10][10];
        boolean[][] visited = new boolean[10][10];

        for (int r = 0; r < 10; r++) {
            String str = br.readLine();
            for (int c = 0; c < 10; c++) {
                map[r][c] = str.charAt(c);

                if (map[r][c] == 'B') {
                    sr = r;
                    sc = c;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { sr, sc, 0 });
        visited[sr][sc] = false;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] == 'L') {
                System.out.println(now[2] - 1);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < 10 && nc >= 0 && nc < 10 && !visited[nr][nc] && map[nr][nc] != 'R') {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc, now[2] + 1 });
                }
            }
        }
    }
}
