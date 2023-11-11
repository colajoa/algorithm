package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_24484 {
    static int N, M, R, cnt = 1;
    static List<Integer>[] list;
    static long[] visited;
    static long[] order;

    static void dfs(int now, int depth) {
        visited[now] = depth;
        order[now] = cnt++;

        for (int next : list[now]) {
            if (visited[next] == 0) {
                dfs(next, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        list = new ArrayList[N + 1];
        visited = new long[N + 1];
        order = new long[N + 1];
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
            Collections.sort(list[n], Collections.reverseOrder());
        }

        dfs(R, 1);

        long ans = 0;
        for (int n = 1; n < N + 1; n++) {
            ans += (visited[n] - 1) * order[n];
        }

        System.out.println(ans);
    }
}
