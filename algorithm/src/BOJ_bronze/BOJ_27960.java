package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_27960 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        System.out.println(A ^ B);
    }
}
