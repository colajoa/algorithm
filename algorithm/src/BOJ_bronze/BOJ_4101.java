package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_4101 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        while (A != 0) {
            System.out.println(A > B ? "Yes" : "No");
            token = new StringTokenizer(br.readLine());

            A = Integer.parseInt(token.nextToken());
            B = Integer.parseInt(token.nextToken());
        }

    }
}