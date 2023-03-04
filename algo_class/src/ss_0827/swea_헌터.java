package ss_0827;
import java.util.*;
import java.io.*;

public class swea_헌터 {
	static int N, min;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[] monster;
	static boolean[] client;
	static int problem;
	static int[][] map;
	static boolean[][] visited;
	static void dfs(int x, int y, int time, int problem) {
		if(map[x][y] > 0) {
			monster[map[x][y]-1] = true; 
		}
		
		if(map[x][y] < 0 && monster[Math.abs(map[x][y])-1]) {
			client[Math.abs(map[x][y])-1] = true;
			problem -= 1;
		}
		
		if(problem == 0) {
			min = time < min ? time : min;
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
				
				if(map[nx][ny] < 0 && !monster[Math.abs(map[nx][ny])-1])
					continue;
					
					visited[nx][ny] = true;
					dfs(x+dx[i], y+dy[i],time+1, problem);
					visited[nx][ny] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			visited = new boolean [N][N];
			problem = 0;
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
					if(map[i][j] < 0) problem += 1;
				}
			}
			
			client = new boolean[problem];
			monster = new boolean[problem];
			visited[0][0] = true;
			dfs(0,0,0,problem);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
