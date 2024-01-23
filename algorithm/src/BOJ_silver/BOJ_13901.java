package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_13901 {
    static int R, C, K, sr, sc;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> order = new ArrayList<>();
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            visited[r][c] = true;
        }

        token = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(token.nextToken());
        sc = Integer.parseInt(token.nextToken());
        visited[sr][sc] = true;

        token = new StringTokenizer(br.readLine());
        while (token.hasMoreTokens()) {
            order.add(Integer.parseInt(token.nextToken()) - 1);
        }

        int idx = 0;
        int cnt = 0;
        while (true) {
            int nr = sr + dr[order.get(idx)];
            int nc = sc + dc[order.get(idx)];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
                cnt = 0;
                visited[nr][nc] = true;
                sr = nr;
                sc = nc;
                continue;
            }

            cnt += 1;
            idx = (idx + 1) % 4;
            if (cnt == 4) {
                break;
            }
        }

        System.out.println(sr + " " + sc);
    }
}
