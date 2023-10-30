package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_21608 {
    static int N, Len;
    static boolean[][] likes;
    static int[] order;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] map;
    static PriorityQueue<Point> pq;
    static List<Point> list;

    static class Point implements Comparable<Point> {
        int r, c, like, blank;

        public Point(int r, int c, int like, int blank) {
            this.r = r;
            this.c = c;
            this.like = like;
            this.blank = blank;
        }

        @Override
        public int compareTo(Point o) {
            if (this.like == o.like) {
                if (this.blank == o.blank) {
                    if (this.r == o.r) {
                        return this.c - o.c;
                    }
                    return this.r - o.r;
                }
                return o.blank - this.blank;
            }
            return o.like - this.like;
        }
    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static long setting() {

        for (int n = 0; n < Len; n++) {
            int student = order[n];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 0) {
                        Point friends = new Point(r, c, 0, 0);
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (map[nr][nc] == 0) {
                                    friends.blank += 1;
                                } else if (likes[student][map[nr][nc]]) {
                                    friends.like += 1;
                                }
                            }
                        }
                        // list.add(friends);
                        pq.add(friends);
                    }
                }
            }
            // System.out.println("student : " + student);
            // for (Point p : pq) {
            // System.out.println("R : " + p.r + " C : " + p.c + " Like : " + p.like + "
            // Blank : " + p.blank);
            // }
            // System.out.println();

            // Collections.sort(list);
            // System.out.println("student : " + student);
            // for (Point p : list) {
            // System.out.println("R : " + p.r + " C : " + p.c + " Like : " + p.like + "
            // Blank : " + p.blank);
            // }
            // System.out.println();

            Point point = pq.poll();
            // Point point = list.get(0);
            map[point.r][point.c] = student;
            // print();
            pq.clear();
            // list.clear();
        }

        long sum = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int student = map[r][c];
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && likes[student][map[nr][nc]]) {
                        cnt += 1;
                    }
                }
                if (cnt == 0)
                    continue;
                else {
                    int ten = 1;
                    for (int i = 1; i < cnt; i++) {
                        ten *= 10;
                    }
                    sum += ten;
                }
            }

        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        Len = N * N;
        likes = new boolean[Len + 1][Len + 1];
        order = new int[N * N];
        map = new int[N][N];

        list = new ArrayList<>();
        pq = new PriorityQueue<>();

        for (int n = 0; n < Len; n++) {
            token = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(token.nextToken());
            order[n] = student;
            for (int m = 0; m < 4; m++) {
                likes[student][Integer.parseInt(token.nextToken())] = true;
            }
        }
        System.out.println(setting());

    }
}
