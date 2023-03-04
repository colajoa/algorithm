package algo_0930;

import java.io.*;
import java.util.*;

public class swea_1249 {
	static int[][] map;
	static int[][] weight;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int N;
	
	static class Point implements Comparable<Point>{
		int r,c,w;

		public Point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	
	static void bfs(int r, int c) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		q.add(new Point(r, c, 0));
		weight[r][c] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int pr = p.r;
			int pc = p.c;
			
			for(int i=0; i<4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || weight[nr][nc] != 987654321) continue;
				if(weight[nr][nc] > weight[pr][pc] + map[nr][nc]) {
					weight[nr][nc] = weight[pr][pc] + map[nr][nc];
					q.add(new Point(nr, nc, weight[nr][nc]));
				}
					
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			weight = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c) - '0';
					weight[r][c] = 987654321;
				}
			}
//			for(int r=0; r<N; r++) {
//				System.out.println(Arrays.toString(weight[r]));
//			}
			bfs(0,0);
//			for(int r=0; r<N; r++) {
//				System.out.println(Arrays.toString(weight[r]));
//			}
			sb.append("#").append(t).append(" ").append(weight[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
