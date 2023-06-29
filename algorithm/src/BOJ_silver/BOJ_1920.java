package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1920 {
    static int[] nums;
    static int N;

    static boolean binarySearch(int num) {

        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == num) {
                return true;
            } else if (nums[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());

        nums = new int[N];

        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(nums);
        int M = Integer.parseInt(br.readLine());

        token = new StringTokenizer(br.readLine());

        for (int m = 0; m < M; m++) {

            if (binarySearch(Integer.parseInt(token.nextToken()))) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
