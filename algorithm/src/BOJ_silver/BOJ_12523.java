package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_12523 {
    static int N;
    static int ans;
    static List<Integer>[] monks;
    static boolean[] visited;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs(int n) {
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int monk : monks[now]) {
                if (!visited[monk]) {
                    visited[monk] = true;
                    q.add(monk);
                    ans += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            sb.append("Case #").append(t).append(":\n");
            N = Integer.parseInt(br.readLine());

            monks = new ArrayList[N + 1];

            token = new StringTokenizer(br.readLine());

            for (int n = 1; n < N + 1; n++) {
                monks[n] = new ArrayList<>();
            }

            for (int n = 1; n < N + 1; n++) {
                monks[Integer.parseInt(token.nextToken())].add(n);
            }
            for (int n = 1; n < N + 1; n++) {
                ans = 1;

                visited = new boolean[N + 1];
                visited[n] = true;
                q.add(n);

                bfs(n);

                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
}
