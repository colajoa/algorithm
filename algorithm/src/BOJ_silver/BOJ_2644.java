package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2644 {
    static int N, M;
    static int A, B;
    static int ans = -1;

    static List<Integer>[] fam;
    static boolean[] visited;

    static void search() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[A] = true;
        q.add(new int[] { A, 0 });
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == B) {
                ans = now[1];
                return;
            }

            for (int f : fam[now[0]]) {
                if (!visited[f]) {
                    visited[f] = true;
                    q.add(new int[] { f, now[1] + 1 });
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        fam = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int n = 1; n < N + 1; n++) {
            fam[n] = new ArrayList<>();
        }

        token = new StringTokenizer(br.readLine());

        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(br.readLine());

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            fam[from].add(to);
            fam[to].add(from);
        }

        search();
        System.out.println(ans);
    }
}