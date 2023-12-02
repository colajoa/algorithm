package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6755 {
    static int N, M, P, Q, ans;
    static List<Integer>[] students;
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean[] visited;

    static boolean bfs(int start, int end) {
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == end) {
                return true;
            }
            for (int next : students[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        students = new ArrayList[N + 1];
        for (int n = 1; n < N + 1; n++) {
            students[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            students[x].add(y);
        }

        token = new StringTokenizer(br.readLine());

        P = Integer.parseInt(token.nextToken());
        Q = Integer.parseInt(token.nextToken());

        visited = new boolean[N + 1];
        if (bfs(P, Q)) {
            System.out.println("yes");
        } else {
            visited = new boolean[N + 1];
            if (bfs(Q, P)) {
                System.out.println("no");
            } else {
                System.out.println("unknown");
            }
        }
    }
}
