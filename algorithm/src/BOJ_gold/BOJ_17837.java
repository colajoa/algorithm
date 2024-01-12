package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_17837 {
    static int N, K;
    static int[][] map;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { 1, -1, 0, 0 };
    static List<int[]>[][] pieces;
    static int[][] positions;

    static boolean move() {
        for (int k = 1; k < K + 1; k++) {
            int[] now = positions[k];

            int nr = now[0] + dr[now[2]];
            int nc = now[1] + dc[now[2]];
            int br = now[0];
            int bc = now[1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
                if (now[2] > 1) {
                    now[2] = ((now[2] + 1) % 2) + 2;
                } else {
                    now[2] = (now[2] + 1) % 2;
                }

                nr = now[0] + dr[now[2]];
                nc = now[1] + dc[now[2]];
                positions[k][2] = now[2];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
                    continue;
                }
            }

            if (actBoard(now[3], nr, nc, br, bc)) {
                return true;
            }
        }

        return false;
    }

    static boolean actBoard(int pos, int nr, int nc, int br, int bc) {
        int size = pieces[br][bc].size();
        int nextSize = pieces[nr][nc].size();
        if (map[nr][nc] == 0) {
            for (int i = pos; i < size; i++) {
                int[] piece = pieces[br][bc].remove(pos);
                piece[1] = nextSize + (i - pos);
                pieces[nr][nc].add(piece);
                positions[piece[0]][0] = nr;
                positions[piece[0]][1] = nc;
                positions[piece[0]][3] = piece[1];
            }
        } else if (map[nr][nc] == 1) {
            for (int i = size; i > pos; i--) {
                int[] piece = pieces[br][bc].remove(pieces[br][bc].size() - 1);
                piece[1] = nextSize + (size - i);
                pieces[nr][nc].add(piece);
                positions[piece[0]][0] = nr;
                positions[piece[0]][1] = nc;
                positions[piece[0]][3] = piece[1];
            }
        }

        if (pieces[nr][nc].size() >= 4) {
            return true;
        }
        return false;
    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(" [ ");
                for (int[] p : pieces[r][c]) {
                    System.out.print(" " + p[0] + " " + p[1] + " ");
                }
                System.out.print(" ] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        pieces = new ArrayList[N][N];
        positions = new int[K + 1][];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
                pieces[r][c] = new ArrayList<>();
            }
        }

        for (int k = 1; k < K + 1; k++) {
            token = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;
            int dir = Integer.parseInt(token.nextToken()) - 1;

            pieces[r][c].add(new int[] { k, 0 });
            positions[k] = new int[] { r, c, dir, 0 };
        }

        int ans = 1;

        while (ans != 1001) {
            if (move()) {
                break;
            }
            ans += 1;
        }

        if (ans > 1000) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
