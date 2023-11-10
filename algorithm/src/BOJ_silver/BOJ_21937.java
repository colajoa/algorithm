package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_21937 {
    static int N, M, X, ans = 0;
    static List<Integer>[] edge;
    static boolean[] visited;

    static void dfs(int now) {
        visited[now] = true;

        for (int next : edge[now]) {
            if (!visited[next]) {
                visited[next] = true;
                ans += 1;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        edge = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int n = 1; n < N + 1; n++) {
            edge[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            edge[to].add(from);
        }

        X = Integer.parseInt(br.readLine());
        dfs(X);
        System.out.println(ans);
    }
}
