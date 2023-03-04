package ss_1114;

import java.io.*;
import java.util.*;

public class Baekjoon_16936 {
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = null;
        LinkedList<Long> list = new LinkedList<>();
        List<Long> nums = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        visited = new boolean[10001];
        token = new StringTokenizer(br.readLine());
        long max = Long.MIN_VALUE;
        for (int n = 0; n < N; n++) {
            long num = Long.parseLong(token.nextToken());
            nums.add(num);
            if (num > max)
                max = num;
        }

        list.add(max);
        // System.out.println(nums.remove(max));
        nums.remove(max);
        while (list.size() != N) {
            // System.out.println(list);
            // System.out.println(nums);
            // System.out.println();
            long first = list.get(0);
            long last = list.get(list.size() - 1);

            long first3 = first * 3;
            long first2 = first % 2;

            long last3 = last % 3;
            long last2 = last * 2;

            // System.out.println(first + " " + last + " " + first3 + " " + first2 + " " +
            // last3 + " " + last2);
            if (first3 < max) {
                if (nums.contains(first3)) {
                    // int idx = nums.indexOf(first3);
                    nums.remove(first3);
                    list.addFirst(first3);
                }
            }

            else if (first2 == 0) {
                if (nums.contains(first / 2)) {
                    // int idx = nums.indexOf((first / 2));
                    nums.remove((first / 2));
                    list.addFirst((first / 2));
                }
            }

            else if (last2 < max) {
                if (nums.contains(last2)) {
                    // int idx = nums.indexOf(last2);
                    nums.remove(last2);
                    list.addLast(last2);
                }
            }

            else if (last3 == 0) {
                if (nums.contains(last / 3)) {
                    // int idx = nums.indexOf((last / 3));
                    nums.remove((last / 3));
                    list.addLast((last / 3));
                }
            }
        }

        for (int n = 0; n < N; n++) {
            sb.append(list.get(n)).append(" ");
        }
        System.out.println(sb);
    }
}