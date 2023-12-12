package BOJ_bronze;

import java.io.*;
import java.util.*;;

public class BOJ_14910 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        boolean flag = true;

        int n = Integer.parseInt(token.nextToken());

        while (token.hasMoreTokens()) {

            int next = Integer.parseInt(token.nextToken());

            if (n > next) {
                flag = false;
                break;
            }

            n = next;
        }
        if (flag) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
    }
}
