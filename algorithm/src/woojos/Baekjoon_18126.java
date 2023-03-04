package woojos;

import java.io.*;
import java.util.*;

public class Baekjoon_18126 {

    static int N, ans;
    static boolean[] visited;
    static List<Room>[] Rooms;

    static class Room {
        int to, dis;

        public Room(int to, int dis) {
            this.to = to;
            this.dis = dis;
        }
    }

    static void dfs(int now, int total) {
        if (ans < total) {
            ans = total;
        }
        for (Room room : Rooms[now]) {
            if (visited[room.to])
                continue;
            visited[room.to] = true;
            dfs(room.to, total + room.dis);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        Rooms = new ArrayList[N + 1];
        for (int n = 1; n < N + 1; n++) {
            Rooms[n] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for (int n = 0; n < N - 1; n++) {
            token = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            int C = Integer.parseInt(token.nextToken());

            Rooms[A].add(new Room(B, C));
            Rooms[B].add(new Room(A, C));
        }

        visited[1] = true;
        dfs(1, 0);
        System.out.println(ans);
    }
}
