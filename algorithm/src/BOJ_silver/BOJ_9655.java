package BOJ_silver;

import java.io.*;

public class BOJ_9655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (Integer.parseInt(br.readLine()) % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
