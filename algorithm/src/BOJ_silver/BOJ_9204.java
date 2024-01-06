package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_9204 {
    static int[] dr = { -1, -1, 1, 1 };
    static int[] dc = { -1, 1, -1, 1 };
    static int sr, sc, er, ec;
    static boolean[][] visited;
    static Queue<Bishop> q = new ArrayDeque<>();

    static class Bishop {
        int r, c, cnt;
        String path;

        public Bishop(int r, int c, int cnt, String path) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.path = path;
        }
    }

    static String bfs() {
        while (!q.isEmpty()) {
            Bishop now = q.poll();

            if (now.cnt == 4)
                continue;
            if (now.r == er && now.c == ec) {
                q.clear();
                return now.cnt + " " + now.path;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r;
                int nc = now.c;
                for (int i = 0; i < 4; i++) {
                    nr += dr[d];
                    nc += dc[d];

                    if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Bishop(nr, nc, now.cnt + 1,
                                now.path + " " + (char) (nc + 'A') + " " + (char) ('8' - nr)));
                    }
                }
            }
        }

        return "Impossible";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());

            visited = new boolean[8][8];

            sc = token.nextToken().charAt(0) - 'A';
            sr = '8' - token.nextToken().charAt(0);

            ec = token.nextToken().charAt(0) - 'A';
            er = '8' - token.nextToken().charAt(0);

            visited[sr][sc] = true;
            q.add(new Bishop(sr, sc, 0, (char) (sc + 'A') + " " + (char) ('8' - sr)));
            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);
    }
}
