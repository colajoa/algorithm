package algo_1004;

import java.io.*;
import java.util.*;

public class Baekjoon_14502 {
	static int N, M, ans, count;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static class Virus{
		int r, c;
		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static void makeWall(int depth) {
		if(depth==3) {
			bfs();
			
			return;
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					makeWall(depth+1);
					map[r][c] = 0;
				}
			}
		}
	}
	static void bfs() {
		Queue<Virus> q = new ArrayDeque<>();
		int[][] copy = new int[N][M];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 2) 
					q.add(new Virus(r, c));
			}
		}
		
		for(int i=0; i<N; i++) {
			copy[i] = map[i].clone();
		}
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			int r = virus.r;
			int c = virus.c;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(copy[nr][nc] == 0) {
						copy[nr][nc] = 2;
						q.add(new Virus(nr, nc));
					}			
				}
			}
		}
		int count = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(copy[r][c] == 0)
					count += 1;
			}
		}
		ans = Math.max(ans, count);
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		ans = Integer.MIN_VALUE;
		map = new int[N][M];

		for(int r=0; r<N; r++) {
			token = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());	
			}
		}
		
		makeWall(0);
		System.out.println(ans);
	}
}
