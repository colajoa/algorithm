package algo_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17070 {
	static int N, ans;
	static int[][] map;

	static void move(int r, int c, int rot) {
		if (r == N - 1 && c == N - 1 && map[r][c] != 1) {
			ans += 1;
			return;
		}

		if (rot == 0) {
			if (r >= 0 && r < N && c+1 >= 0 && c+1 < N && map[r][c+1] != 1)
				move(r, c+1, 0);
			if (r + 1 >= 0 && r + 1 < N && c + 1 >= 0 && c + 1 < N && map[r+1][c+1] != 1 && map[r+1][c] != 1 && map[r][c+1] != 1)
				move(r + 1, c + 1, 2);
		} else if (rot == 1) {
			if (r+1 >= 0 && r+1 < N && c >= 0 && c < N && map[r+1][c] != 1)
				move(r+1, c, 1);
			if (r + 1 >= 0 && r + 1 < N && c + 1 >= 0 && c + 1 < N && map[r+1][c+1] != 1 && map[r+1][c] != 1 && map[r][c+1] != 1)
				move(r + 1, c + 1, 2);

		} else if (rot == 2) {
			if (r >= 0 && r < N && c+1 >= 0 && c+1 < N && map[r][c+1] != 1)
				move(r, c+1, 0);
			if (r+1 >= 0 && r+1 < N && c >= 0 && c < N && map[r+1][c] != 1)
				move(r+1, c, 1);
			if (r + 1 >= 0 && r + 1 < N && c + 1 >= 0 && c + 1 < N && map[r+1][c+1] != 1 && map[r+1][c] != 1 && map[r][c+1] != 1)
				move(r + 1, c + 1, 2);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = 0;
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		move(0, 1, 0);
		System.out.println(ans);
	}
}
