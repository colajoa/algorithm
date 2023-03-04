package algo_1007;

import java.util.*;
import java.io.*;

public class Baekjoon_17472 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static List<Island>[] island;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	static class Island {
		int r, c;
		public Island(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void island() {
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		island = new ArrayList<>();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			token = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(token.nextToken());
				if(map[n][m] == 1 && !visited[n][m])
					island();
			}
		}
	}
}
