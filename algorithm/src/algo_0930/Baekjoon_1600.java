package algo_0930;

import java.util.*;
import java.io.*;

// 범위를 벗어난 경우
public class Baekjoon_1600 {
	static int K;
	static int W, H;
	static int ans;
	static int[][] map;
	static boolean[][][] visited;
	
	// 상우하좌 
	static int[] dr = {-1,0,1,0,-2,-2,-1,-1,1,1,2,2};
	static int[] dc = {0,1,0,-1,-1,1,-2,2,-2,2,-1,1};
	static class Monkey {
		int r, c, move, cnt;
		
		public Monkey(int r, int c, int cnt, int move) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.move = move;
		}
		
	}
	
	static void bfs() {
		Queue<Monkey> q = new ArrayDeque<>();
		q.add(new Monkey(0,0, 0,0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Monkey m = q.poll();
			
			if(m.r == H-1 && m.c == W-1) {
				ans = m.cnt;
				break;
			}
			for(int i=0; i<12; i++) {
				int nr = m.r + dr[i];
				int nc = m.c + dc[i];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				if(map[nr][nc]==1) continue;
				if(i>=4 && m.move >= K) continue;
				if(i<4 && visited[nr][nc][m.move]) continue;
				if(i>=4 && visited[nr][nc][m.move+1]) continue;
				
				if(i<4) {
					visited[nr][nc][m.move] = true;
					q.add(new Monkey(nr, nc, m.cnt+1, m.move));
				}
				if(i>=4 && m.move < K) {
					visited[nr][nc][m.move+1] = true;
					q.add(new Monkey(nr, nc, m.cnt+1, m.move+1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		K = Integer.parseInt(br.readLine());
		
		token = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());
		ans = Integer.MAX_VALUE;
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int h=0; h<H; h++) {
			token = new StringTokenizer(br.readLine());
			for(int w=0; w<W; w++) {
				map[h][w]=Integer.parseInt(token.nextToken());
			}
		}
		bfs();
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}
	
}
