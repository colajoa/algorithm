package softeer.Level2;

import java.io.*;
import java.util.*;

public class _8단변속기 {
    static char[][] arr = {
            { '1', '2', '3', '4', '5', '6', '7', '8' },
            { '8', '7', '6', '5', '4', '3', '2', '1' }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        token = new StringTokenizer(br.readLine(), " ");

        char[] ch = new char[8];
        for (int i = 0; i < 8; i++) {
            ch[i] = token.nextToken().charAt(0);
        }

        System.out.println(ch.equals(arr[0]));
        System.out.println(ch.equals(arr[1]));

        if (ch.equals(arr[0])) {
            System.out.println("ascending");
        } else if (ch.equals(arr[1])) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}