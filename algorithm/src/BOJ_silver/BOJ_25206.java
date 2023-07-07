package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_25206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        Map<String, Double> grades = new HashMap<>();
        grades.put("A+", 4.5);
        grades.put("A0", 4.0);
        grades.put("B+", 3.5);
        grades.put("B0", 3.0);
        grades.put("C+", 2.5);
        grades.put("C0", 2.0);
        grades.put("D+", 1.5);
        grades.put("D0", 1.0);
        grades.put("F", 0.0);

        double sum = 0;
        double score = 0;
        for (int n = 0; n < 20; n++) {
            token = new StringTokenizer(br.readLine());
            token.nextToken();
            double credit = Double.parseDouble(token.nextToken());
            String alpha = token.nextToken();
            if (alpha.equals("P"))
                continue;
            double grade = grades.get(alpha);

            score += credit * grade;
            sum += credit;
        }

        System.out.println(score / sum);
    }
}