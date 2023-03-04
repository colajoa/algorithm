package algo_1101;

import java.io.*;
import java.util.*;

public class Baekjoon_16235 {
    static int N, M, K;
    static int[][] map;
    static int[][] copy;
    static PriorityQueue<Integer>[][] trees;
    static int dr[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int dc[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

    static class Tree {
        int r, c;

        public Tree(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        int ans = 0;
        map = new int[N][N];
        copy = new int[N][N];
        trees = new PriorityQueue[N][N];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = 5;
                copy[r][c] = Integer.parseInt(token.nextToken());
                trees[r][c] = new PriorityQueue<>();
            }
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken()) - 1;
            int y = Integer.parseInt(token.nextToken()) - 1;
            int z = Integer.parseInt(token.nextToken());
            trees[x][y].add(z);
        }

        while (K-- > 0) {
            Queue<Tree> newTree = new ArrayDeque<>();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    PriorityQueue<Integer> getAge = new PriorityQueue<>();

                    while (!trees[r][c].isEmpty() && map[r][c] - trees[r][c].peek() >= 0) {
                        int now = trees[r][c].poll();

                        map[r][c] -= now;

                        getAge.add(now + 1);

                        if ((now + 1) % 5 == 0) {
                            newTree.add(new Tree(r, c));
                        }
                    }

                    while (!trees[r][c].isEmpty()) {
                        map[r][c] += trees[r][c].poll() / 2;
                    }

                    trees[r][c] = getAge;

                    map[r][c] += copy[r][c];
                }
            }
            while (!newTree.isEmpty()) {
                Tree t = newTree.poll();
                for (int i = 0; i < 8; i++) {
                    int nr = t.r + dr[i];
                    int nc = t.c + dc[i];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        trees[nr][nc].add(1);
                    }
                }
            }

        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                ans += trees[r][c].size();
            }
        }

        System.out.println(ans);
    }
}