package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_10953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine(), ",");
            System.out.println(Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken()));
        }
    }
}
