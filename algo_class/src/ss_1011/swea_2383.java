package ss_1011;
import java.io.*;
import java.util.*;
public class swea_2383 {
	static int[][] map;
	static int N, ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
				}
			}
		}
		
	}
}
