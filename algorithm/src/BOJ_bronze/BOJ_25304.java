package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_25304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            sum += Integer.parseInt(token.nextToken()) * Integer.parseInt(token.nextToken());
        }

        System.out.println(sum == X ? "Yes" : "No");
    }
}
