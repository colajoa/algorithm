package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2210 {
    static char[][] map;
    static Set<String> set = new HashSet<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Word> q = new ArrayDeque<>();

    static class Word {
        int r, c, move;
        String word;

        public Word(int r, int c, int move, String word) {
            this.r = r;
            this.c = c;
            this.move = move;
            this.word = word;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Word now = q.poll();

            if (now.move == 6) {
                set.add(now.word);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                    q.add(new Word(nr, nc, now.move + 1, now.word + map[nr][nc]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        map = new char[5][5];

        for (int r = 0; r < 5; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                map[r][c] = token.nextToken().charAt(0);
            }
        }

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                String str = "";
                str += map[r][c];
                q.add(new Word(r, c, 1, str));
                bfs();
            }
        }

        System.out.println(set.size());
    }
}
