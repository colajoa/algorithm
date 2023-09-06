package BOJ_silver;

import java.util.*;
import java.io.*;

// 자료형 확인하고 풀기
// int형 넘어가면 값이 변경됨
public class BOJ_1629 {
    static int A, B, C;

    static long divide(int B) {
        long num = 1;
        if (B == 1) {
            return A % C;
        } else if (B % 2 == 0) {
            num = divide(B / 2);
            return (num * num) % C;
        } else {
            num = divide((B - 1) / 2);
            return (num * num) % C * A % C;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        System.out.println(divide(B));
    }
}
