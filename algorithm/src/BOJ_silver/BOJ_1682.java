package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1682 {
    static int[] cube = new int[8];
    static Map<String, String> map = new HashMap<>();

    static class Cube {
        int[] cube;
        int cnt;

        public Cube(int[] cube, int cnt) {
            this.cube = cube;
            this.cnt = cnt;
        }
    }

    static void A(int[] org) {
        int head = 0;
        int tail = 7;
        for (int n = 0; n < 4; n++) {
            int flag = org[head];
            org[head] = org[tail];
            org[tail] = flag;

            head++;
            tail--;
        }
    }

    static void B(int[] org) {
        int uHead = org[3];
        int dHead = org[4];

        int tail = 4;
        for (int n = 3; n > 0; n--) {
            org[n] = org[n - 1];
            org[tail] = org[tail + 1];

            tail++;
        }

        org[0] = uHead;
        org[7] = dHead;
    }

    static void C(int[] org) {
        int flag = org[1];

        org[1] = org[2];
        org[2] = org[5];
        org[5] = org[6];
        org[6] = flag;
    }

    static void D(int[] org) {
        int flag = org[0];
        org[0] = org[4];
        org[4] = flag;
    }

    static boolean answer(int[] org) {
        for (int n = 0; n < 8; n++) {
            if (org[n] != cube[n]) {
                return false;
            }
        }
        return true;
    }

    static void visit(int[] arr) {
        String str = "";
        for (int n = 0; n < 8; n++) {
            str += arr[n];
        }

        map.put(str, str);
    }

    static boolean isVisited(int[] arr) {
        String str = "";
        for (int n = 0; n < 8; n++) {
            str += arr[n];
        }

        if (map.containsKey(str)) {
            return true;
        }
        return false;
    }

    static int bfs() {
        Queue<Cube> q = new ArrayDeque<>();

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        visit(arr);
        q.add(new Cube(arr, 0));

        while (!q.isEmpty()) {
            Cube now = q.poll();
            if (answer(now.cube)) {
                return now.cnt;
            }

            int[] org = Arrays.copyOf(now.cube, 8);
            A(org);
            if (!isVisited(org)) {
                visit(org);
                q.add(new Cube(org, now.cnt + 1));
            }

            org = Arrays.copyOf(now.cube, 8);
            B(org);
            if (!isVisited(org)) {
                visit(org);
                q.add(new Cube(org, now.cnt + 1));
            }

            org = Arrays.copyOf(now.cube, 8);
            C(org);
            if (!isVisited(org)) {
                visit(org);
                q.add(new Cube(org, now.cnt + 1));
            }

            org = Arrays.copyOf(now.cube, 8);
            D(org);
            if (!isVisited(org)) {
                visit(org);
                q.add(new Cube(org, now.cnt + 1));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int n = 0; n < 8; n++) {
            cube[n] = Integer.parseInt(token.nextToken());
        }

        System.out.println(bfs());
    }
}
