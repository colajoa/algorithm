package softeer.Level2;

import java.io.*;
import java.util.*;

public class _8단변속기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] gear = new int[8];
        for (int i = 0; i < 8; i++) {
            gear[i] = Integer.parseInt(token.nextToken());
        }
        String str = "";
        if (gear[0] == 1) {
            str = "ascending";
            for (int i = 1; i < 8; i++) {
                if (gear[i - 1] > gear[i]) {
                    str = "mixed";
                    break;
                }
            }
        } else if (gear[0] == 8) {
            str = "descending";
            for (int i = 1; i < 8; i++) {
                if (gear[i - 1] < gear[i]) {
                    str = "mixed";
                    break;
                }
            }
        }
        System.out.println(str);
    }
}