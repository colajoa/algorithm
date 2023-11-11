package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_24481 {
    static int N, M, R;
    static List<Integer>[] list;
    static int[] visited;

    static void dfs(int now, int depth) {
        visited[now] = depth;

        for (int next : list[now]) {
            if (visited[next] == 0) {
                dfs(next, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        list = new ArrayList[N + 1];
        visited = new int[N + 1];
        for (int n = 1; n < N + 1; n++) {
            list[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            list[to].add(from);
            list[from].add(to);
        }

        for (int n = 1; n < N + 1; n++) {
            Collections.sort(list[n]);
        }

        dfs(R, 1);

        for (int n = 1; n < N + 1; n++) {
            sb.append(visited[n] - 1).append("\n");
        }

        System.out.println(sb);
    }
}
