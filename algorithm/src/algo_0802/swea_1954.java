package algo_0802;

import java.util.Scanner;

public class swea_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] sn = new int[N][N];
			int num = 1;
			int x = 0;
			int y = 0;
			int move = N - 1;
			sn[x][y] = num;
			while (num != N * N) {
				if (num == 1) {
					for (int i = 0; i < move; i++)
						sn[x][++y] = ++num;
				}
				for (int i = 0; i < move; i++) {
					sn[++x][y] = ++num;
				}
				for (int i = 0; i < move; i++) {
					sn[x][--y] = ++num;
				}
				move--;
				for (int i = 0; i < move; i++) {
					sn[--x][y] = ++num;
				}
				for (int i = 0; i < move; i++) {
					sn[x][++y] = ++num;
				}
				move--;
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(sn[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}