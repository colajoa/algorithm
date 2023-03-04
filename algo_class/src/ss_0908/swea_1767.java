package ss_0908;

import java.io.*;
import java.util.*;

public class swea_1767 {


	static class Core {
		int x;
		int y;

		Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	// 맵 크기, 최소값, 코어 갯수 최대값 이미 연결된 코어, 연결해야될 코어, 전체 코어수
	static int N, min, coreMax, coreCnt;
	static int map[][];
	
	// 4방 탐색 우하좌상
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	static List<Core> core;
	
	static void perm(int depth, int cnt) {
		if(depth==coreCnt) {
			int sum = 0;
			if(coreMax > cnt) return;
			coreMax = Math.max(cnt, coreMax);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 2) sum += 1;
				}
			}
			
			min = Math.min(sum, min);
			return;
		}
		
		
		
		int[][] copyMap = new int[N][N];
		
		for(int i=0; i<coreCnt; i++) {
			
			copyMap(copyMap, map);
			for(int j=0; j<4; j++) {
				
				if(!isNoPath(core.get(i).x, core.get(i).y, j)) {
					cable(core.get(i).x, core.get(i).y, j);
					perm(depth+1, cnt+1);
				}
				else
				{
					perm(depth+1, cnt);
				}
				copyMap(map, copyMap);
			}
			
		}
	}
	
	// 맵 복사
	static void copyMap(int[][] cp, int[][] org) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cp[i][j] = org[i][j];
			}
		}
	}
	
	// 케이블을 놓을 수 있는 지 검사
	static boolean isNoPath(int x, int y, int dir) {

		while (true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) 
				return false;
			if (map[nx][ny] != 0)
				return true;
			
			x = nx;
			y = ny;
		}

	}

	
	// 케이블 놓기
	static void cable(int x, int y, int dir) {
		
			while (true) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < 0 || nx > N-1 || ny < 0 || ny > N-1) return;
					
				map[nx][ny] = 2;
				x = nx;
				y = ny;
			}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			core = new ArrayList<>();
			coreCnt = 0;
			min = Integer.MAX_VALUE;
			coreMax = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) 
							continue;
						core.add(new Core(i, j));
						coreCnt += 1;
					}
				}
			}

			perm(0,0);
			sb.append("#").append(t).append(" ").append(min).append("\n");

		}
		System.out.println(sb);
	}
}