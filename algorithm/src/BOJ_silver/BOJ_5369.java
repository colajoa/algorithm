package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_5369 {
    static int M;
    static char[][] map;
    static int[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<int[]> q = new ArrayDeque<>();

    static int bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] == 'd') {
                return visited[now[0]][now[1]] - 1;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < M && nc >= 0 && nc < M && visited[nr][nc] == 0 && map[nr][nc] != '*') {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            M = Integer.parseInt(br.readLine());

            map = new char[M][M];
            visited = new int[M][M];
            int sr = 0;
            int sc = 0;
            for (int r = 0; r < M; r++) {
                String str = br.readLine();
                for (int c = 0; c < M; c++) {
                    map[r][c] = str.charAt(c);
                    if (map[r][c] == 's') {
                        sr = r;
                        sc = c;
                    }
                }
            }

            visited[sr][sc] = 1;
            q.add(new int[] { sr, sc });

            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);
    }
}
