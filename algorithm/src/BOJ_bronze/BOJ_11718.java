package BOJ_bronze;

import java.io.*;

public class BOJ_11718 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}