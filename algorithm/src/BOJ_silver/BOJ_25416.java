package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_25416 {
    static int[][] map;
    static int sr, sc;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        map[sr][sc] = -1;
        q.add(new int[] { sr, sc, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && map[nr][nc] != -1) {
                    if (map[nr][nc] == 1) {
                        return now[2] + 1;
                    }
                    map[nr][nc] = -1;
                    q.add(new int[] { nr, nc, now[2] + 1 });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        map = new int[5][5];

        for (int r = 0; r < 5; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(token.nextToken());
        sc = Integer.parseInt(token.nextToken());

        System.out.println(bfs());
    }
}
