package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int n : list) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }
}
