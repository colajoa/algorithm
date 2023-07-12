package BOJ_bronze;

import java.io.*;

public class BOJ_9506 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sbb = null;
        int num = 0;
        while ((num = Integer.parseInt(br.readLine())) != -1) {
            int sum = 0;
            sbb = new StringBuilder();
            for (int n = 1; n < num; n++) {
                if (num % n == 0) {
                    sum += n;
                    sbb.append(n).append(" + ");
                }
            }
            sbb.delete(sbb.length() - 3, sbb.length());
            sb.append(num);
            if (sum == num) {
                sb.append(" = ").append(sbb).append("\n");
            } else {
                sb.append(" is NOT perfect.").append("\n");
            }
        }

        System.out.println(sb);
    }
}
