package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2628 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(token.nextToken());
            int num = Integer.parseInt(token.nextToken());

            if (t == 0) {
                row.add(num);
            } else {
                col.add(num);
            }
        }

        row.add(0);
        row.add(R);
        col.add(0);
        col.add(C);
        Collections.sort(row);
        Collections.sort(col);

        int rSize = row.size();
        int cSize = col.size();

        int ans = 0;
        for (int r = 1; r < rSize; r++) {
            int w = row.get(r) - row.get(r - 1);
            for (int c = 1; c < cSize; c++) {
                int h = col.get(c) - col.get(c - 1);

                ans = Math.max(ans, w * h);
            }
        }

        System.out.println(ans);
    }
}
