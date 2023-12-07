package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_27959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        if (Integer.parseInt(token.nextToken()) * 100 >= Integer.parseInt(token.nextToken())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
