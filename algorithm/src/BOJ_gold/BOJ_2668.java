package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2668 {
    static int N;

    static int[] nums;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    static void search(int n, int flag) {
        if (!visited[nums[n]]) {
            visited[nums[n]] = true;
            search(nums[n], flag);
            visited[nums[n]] = false;
        }
        if (nums[n] == flag)
            list.add(flag);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        nums = new int[N + 1];
        visited = new boolean[N + 1];

        for (int n = 1; n < N + 1; n++) {
            nums[n] = Integer.parseInt(br.readLine());
        }

        for (int n = 1; n < N + 1; n++) {
            visited[n] = true;
            search(n, n);
            visited[n] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());

        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
