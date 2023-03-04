package algo_0824;

import java.io.*;
import java.util.*;

// |x1-x2|+|y1-y2|
public class Baekjoon_16236 {
	static int N, fish, ans;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int babySharkX;
	static int babySharkY;
	static int sharkSize = 2;

	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { x, y });
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 0 && map[nx][ny] <= sharkSize ) {
					
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
				if (map[r][c] == 9) {
					babySharkX = r;
					babySharkY = c;
					map[r][c] = 0;
				} else if (map[r][c] > 0)
					fish += 1;

			}
		}

	}
}
