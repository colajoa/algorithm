package ss_0827;

import java.util.*;
import java.io.*;

public class swea_헌터2 {
	static int N, all, min;
	static int cnt;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	// 몬스터 4 고객 4
	static int[] selected;
	static boolean[] isSelected;
	static int[][] map;
	static int[][] monsterPoint;
	static int[][] clientPoint;
	static int[][] points;
	static void perm(int depth) {
		if(depth == all+1) {
			int ans = 0;
			for(int i=1; i<=all; i++) {
				int from = selected[i-1];
				int to = selected[i];
				ans += Math.abs(points[from][0] - points[to][0]) + Math.abs(points[from][1] - points[to][1]);
			}
			min = Math.min(ans, min);
			return;
		}
		
		for(int i=1; i<all+1; i++) {
			
			
			if(isSelected[i]) continue;
			if(i > all/2 && !isSelected[i-all/2]) continue;
			
			isSelected[i] = true;
			selected[depth] = i;
			perm(depth+1);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			monsterPoint = new int[5][2];
			clientPoint = new int[5][2];
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
					if(map[i][j] > 0 ) {
						monsterPoint[map[i][j]] = new int[] {i,j}; 
						all += 1;
						}
					if(map[i][j] < 0 ) {
						clientPoint[Math.abs(map[i][j])] = new int[] {i,j};
						all += 1;
					}
				}
			}
			selected = new int[all+1];
			isSelected = new boolean[all+1];
			points = new int[all+1][2];
			points[0] = new int[] {0,0};
			for(int i = 1; i<all/2+1; i++) {
				points[i] = Arrays.copyOf(monsterPoint[i], 2);
			}
			
			for(int i=all/2+1; i<all+1; i++) {
				points[i] = Arrays.copyOf(clientPoint[i-all/2], 2);
			}
			
			perm(1);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
