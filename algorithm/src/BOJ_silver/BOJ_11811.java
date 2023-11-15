package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11811 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            int i = 0;
            for (int c = 0; c < N; c++) {
                int j = Integer.parseInt(token.nextToken());
                i |= j;
            }
            System.out.print(i + " ");
        }
    }
}
