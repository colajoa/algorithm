package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2751_1 {

    // 합치는 과정에서 정렬하여 원소를 담을 임시 배열
    static int[] sorted;

    static void mergesort(int[] a) {
        sorted = new int[a.length];
        mergesort(a, 0, a.length - 1);
        sorted = null;
    }

    // Top-Down
    static void mergesort(int[] a, int left, int right) {

        /*
         * left == right, 부분 리스트가 원소를 1개만 가지고 있는 경우
         * 더이상 쪼갤 수 없으므로 return
         */

        if (left == right)
            return;
        int mid = (left + right) / 2; // 절반 위치

        mergesort(a, left, mid); // 절반 중 왼쪽
        mergesort(a, mid + 1, right); // 절반 중 오른쪽

        merge(a, left, mid, right); // 병합
    }

    /**
     * 합칠 부분리스트는 a 배열의 left ~ right까지
     * 
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    static void merge(int[] a, int left, int mid, int right) {
        int l = left; // 왼쪽부분 시작점
        int r = mid + 1; // 오른쪽부분 시작점
        int index = left; // 채워 넣을 배열의 인덱스

        while (l <= mid && r <= right) {
            /*
             * 왼쪽부분 리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             * 왼쪽의 l번째 원소를 새 배열에 넣고 l과 index를 1증가 시킨다
             */
            if (a[l] <= a[r]) {
                sorted[index] = a[l];
                index += 1;
                l += 1;
            }

            /*
             * 오른쪽부분 리스트 r번째 원소가 왼쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             * 오른쪽의 r번째 원소를 새 배열에 넣고 r과 index를 1증가 시킨다.
             */
            else {
                sorted[index] = a[r];
                index += 1;
                r += 1;
            }
        }
        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if (l > mid) {
            while (r <= right) {
                sorted[index] = a[r];
                index += 1;
                r += 1;
            }
        }

        /*
         * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else {
            while (l <= mid) {
                sorted[index] = a[l];
                index += 1;
                l += 1;
            }
        }

        /*
         * 정렬된 새 배열을 기존의 베열에 복사하여 옮겨준다.
         */
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(br.readLine());
        }

        mergesort(nums);

        for (int n = 0; n < N; n++) {
            sb.append(nums[n]).append("\n");
        }
        System.out.println(sb);
    }
}