package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_21609 {
    static int N, M, size, mr, mc, cnt, ans = 0, rainbow, rainbowMax = 0;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] map;
    static boolean[][][] visited;

    static Queue<Point> biggest = new ArrayDeque<>();
    static Queue<Point> temp = new ArrayDeque<>();
    static Queue<Point> q = new ArrayDeque<>();

    static class Block implements Comparable<Block> {
        int r, c, rainbow;

        public Block(int r, int c, int rainbow) {
            this.r = r;
            this.c = c;
            this.rainbow = rainbow;
        }

        @Override
        public int compareTo(Block o) {
            if (this.rainbow == o.rainbow) {
                if (this.r == o.r) {
                    return o.c - this.c;
                }
                return o.r - this.r;
            }

            return o.rainbow - this.rainbow;
        }

    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c, int color) {
        temp.clear();
        cnt += 1;
        visited[color][r][c] = true;
        q.add(new Point(r, c));
        temp.add(new Point(r, c));
        rainbow = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[color][nr][nc]
                        && (map[nr][nc] == 0 || map[nr][nc] == color)) {
                    if (map[nr][nc] == 0) {
                        rainbow += 1;
                    }
                    cnt += 1;
                    visited[color][nr][nc] = true;
                    q.add(new Point(nr, nc));
                    temp.add(new Point(nr, nc));
                }
            }
        }
    }

    static void remove() {
        ans += (int) Math.pow(biggest.size(), 2);
        while (!biggest.isEmpty()) {
            Point now = biggest.poll();
            map[now.r][now.c] = -2;
        }
    }

    static void down() {
        for (int c = 0; c < N; c++) {
            int r = N - 1;
            int br = r;
            while (r != -1) {
                if (map[r][c] == -2) {
                    r--;
                } else if (map[r][c] == -1 || map[r][c] > -1 && r == br) {
                    r--;
                    br = r;
                } else if (map[r][c] > -1) {
                    map[br][c] = map[r][c];
                    map[r][c] = -2;
                    r = br - 1;
                    br = r;
                }
            }
        }
    }

    static void antiClock() {
        int[][] temp = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                temp[N - 1 - c][r] = map[r][c];
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = temp[r][c];
            }
        }
    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == -2) {
                    System.out.print(" X ");
                } else if (map[r][c] >= 0) {
                    System.out.print("+" + map[r][c] + " ");
                } else {
                    System.out.print(map[r][c] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        while (true) {
            visited = new boolean[M + 1][N][N];
            size = 0;
            mr = -1;
            mc = -1;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] > 0 && !visited[map[r][c]][r][c]) {
                        cnt = 0;
                        bfs(r, c, map[r][c]);

                        if (cnt == 1)
                            continue;

                        if (mr == -1 && mc == -1) {
                            mr = r;
                            mc = c;
                            rainbowMax = rainbow;
                            size = cnt;
                            biggest.addAll(temp);
                        } else if (size < cnt) {
                            mr = r;
                            mc = c;
                            size = cnt;
                            rainbowMax = rainbow;
                            biggest.clear();
                            biggest.addAll(temp);
                        } else if (size == cnt) {
                            if (rainbow >= rainbowMax) {
                                mr = r;
                                mc = c;
                                rainbowMax = rainbow;
                                biggest.clear();
                                biggest.addAll(temp);
                            }
                        }
                    }
                }
            }

            if (size == 0) {
                break;
            } else {
                remove();
                down();
                antiClock();
                down();
            }
        }
        System.out.println(ans);
    }
}
