package algo_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17070_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][][] dp = new int[N][N][3];
		
		for(int r=0; r<N; r++) {
			token = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		dp[0][1][0] = 1;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c<N; c++) {
				if(map[r][c] == 1) continue;
				dp[r][c][0] = dp[r][c-1][0] + dp[r][c-1][2];
				dp[r][c][1] = dp[r-1][c][1] + dp[r-1][c][2];
			}
		}
	}
}
