package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_16928 {
    static int N, M, ans = Integer.MAX_VALUE;
    static int[] game;
    static boolean[] visited;
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int pos, cnt;

        public Point(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        q.add(new Point(1, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.pos == 100) {
                ans = Math.min(now.cnt, ans);
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int npos = now.pos + i;
                if (npos < 100 && !visited[npos]) {
                    if (game[npos] != 0) {
                        visited[npos] = true;
                        visited[game[npos]] = true;
                        q.add(new Point(game[npos], now.cnt + 1));
                    } else {
                        visited[npos] = true;
                        q.add(new Point(npos, now.cnt + 1));
                    }
                } else if (npos == 100) {
                    q.add(new Point(npos, now.cnt + 1));
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        game = new int[101];
        visited = new boolean[101];

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            game[from] = to;
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            game[Integer.parseInt(token.nextToken())] = Integer.parseInt(token.nextToken());
        }

        bfs();
        System.out.println(ans);
    }
}
