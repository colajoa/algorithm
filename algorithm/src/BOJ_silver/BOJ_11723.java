package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int a = 0;
        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            String command = token.nextToken();
            int num = 0;
            switch (command) {
                case "add":
                    num = Integer.parseInt(token.nextToken());
                    a |= (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(token.nextToken());
                    a &= ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(token.nextToken());
                    if ((a & (1 << num)) == 1 << num) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(token.nextToken());
                    a ^= (1 << num);
                    break;
                case "all":
                    a = (1 << 21) - 1;
                    break;
                case "empty":
                    a = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
