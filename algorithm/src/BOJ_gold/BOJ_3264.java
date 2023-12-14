package BOJ_gold;

import java.io.*;
import java.util.*;

// 모든 노드 합 * 2 - 가장 긴 경로
public class BOJ_3264 {
    static int N, S, max = -1, sum = 0;
    static List<Point>[] road;
    static int[] distance;
    static boolean[] visited;

    static class Point {
        int to, fuel;

        public Point(int to, int fuel) {
            this.to = to;
            this.fuel = fuel;
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        max = Math.max(max, distance[now]);
        for (Point next : road[now]) {
            if (!visited[next.to]) {
                distance[next.to] += distance[now] + next.fuel;
                dfs(next.to);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());

        road = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for (int n = 1; n < N + 1; n++) {
            road[n] = new ArrayList<>();
        }

        for (int n = 0; n < N - 1; n++) {
            token = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            int C = Integer.parseInt(token.nextToken());

            road[A].add(new Point(B, C));
            road[B].add(new Point(A, C));

            sum += C * 2;
        }
        
        dfs(S);

        System.out.println(sum - max);
    }
}
