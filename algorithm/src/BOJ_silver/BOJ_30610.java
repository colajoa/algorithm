package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_30610 {
    static int R, C, cnt, size;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c) {
        size += 1;
        map[r][c] = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 1) {
                    size = 0;
                    dfs(r, c);
                    list.add(size);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
