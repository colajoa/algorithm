package algo_1012;
import java.io.*;
import java.util.*;
public class swea_2112 {
	static int D, W, K,ans;
	static int[][] film;
	static int[] selected;
	static boolean isPass() {
		int totalCnt = 0;
		for(int c=0; c<W; c++) {
			int type = film[0][c];
			int cnt = 1;
			boolean flag = false;
			for(int r=1; r<D; r++) {
				if(type == film[r][c]) {
					cnt += 1;
				}
				else {
					type = film[r][c];
					cnt = 1;
				}		
				if(cnt == K) {
					flag = true;
					break;
				}
				
			}
			if(!flag)
				return false;
		}
		return true;
	}
	
	static void change(int depth, int cnt) {
		if(isPass()) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(cnt > ans) return;
		
		if(depth == D) return;
		
		int[] copy = new int[W];
		
		for(int i=0; i<W; i++)
			copy[i] = film[depth][i];
		
		change(depth+1, cnt);
		
		for(int i=0; i<W; i++)
			film[depth][i] = 0;
		
		change(depth+1, cnt+1);
		
		for(int i=0; i<W; i++)
			film[depth][i] = 1;
		
		change(depth+1, cnt+1);
		
		for(int i=0; i<W; i++)
			film[depth][i] = copy[i];
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			 token = new StringTokenizer(br.readLine());
			 D = Integer.parseInt(token.nextToken());
			 W = Integer.parseInt(token.nextToken());
			 K = Integer.parseInt(token.nextToken());
			 
			 film = new int[D][W];
			 //copy = new int[D][W];
			 ans = Integer.MAX_VALUE;
			 
			 for(int r=0; r<D; r++) {
				 token = new StringTokenizer(br.readLine());
				 for(int c=0; c<W; c++) {
					 film[r][c] = Integer.parseInt(token.nextToken());
				 }
			 }
			 change(0,0);
			 sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
