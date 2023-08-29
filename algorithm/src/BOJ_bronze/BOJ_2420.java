package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2420 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        System.out.println(Math.abs(Long.parseLong(token.nextToken()) - Long.parseLong(token.nextToken())));
    }
}
