package BOJ_bronze;

import java.io.*;

public class BOJ_1076 {
    static int value(String str) {
        switch (str) {
            case "brown":
                return 1;
            case "red":
                return 2;
            case "orange":
                return 3;
            case "yellow":
                return 4;
            case "green":
                return 5;
            case "blue":
                return 6;
            case "violet":
                return 7;
            case "grey":
                return 8;
            case "white":
                return 9;

            default:
                return 0;
        }
    }

    static int mul(String str) {
        switch (str) {
            case "brown":
                return 10;
            case "red":
                return 100;
            case "orange":
                return 1000;
            case "yellow":
                return 10000;
            case "green":
                return 100000;
            case "blue":
                return 1000000;
            case "violet":
                return 10000000;
            case "grey":
                return 100000000;
            case "white":
                return 1000000000;

            default:
                return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        long ans = 10;

        ans *= value(str);

        str = br.readLine();

        ans += value(str);

        str = br.readLine();

        ans *= mul(str);

        System.out.println(ans);
    }
}
