package algo_0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1149 {
	static int N;
	static int[][] cost;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		// 집 갯수
		 N = Integer.parseInt(br.readLine());
		 
		 // 집 마다 RGB 칠하는 비용
		 cost = new int[N+1][3];
		 
		 // 입력
		 for(int i=1; i<=N; i++) {
			 token = new StringTokenizer(br.readLine());
			 cost[i][0] = Integer.parseInt(token.nextToken());
			 cost[i][1] = Integer.parseInt(token.nextToken());
			 cost[i][2] = Integer.parseInt(token.nextToken());
			 			
		 }
		 
		 // 서로 다른 색상 중 최솟값을 누적한다.
		 for(int i=2; i<=N; i++) {
//			 System.out.println("before");
//			 System.out.println("i-1 "+(i-1)+" : "+cost[i-1][0]+" "+cost[i-1][1]+" "+cost[i-1][2]);
//			 System.out.println("i "+i+" : "+cost[i][0]+" "+cost[i][1]+" "+cost[i][2]);
			 cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			 cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			 cost[i][2] += Math.min(cost[i-1][1], cost[i-1][0]);
//			 System.out.println("after");
//			 System.out.println("i-1 "+(i-1)+" : "+cost[i-1][0]+" "+cost[i-1][1]+" "+cost[i-1][2]);
//			 System.out.println("i "+i+" : "+cost[i][0]+" "+cost[i][1]+" "+cost[i][2]);
//			 System.out.println();
		 }
		 
		 System.out.println(Math.min(Math.min(cost[N][0], cost[N][1]),cost[N][2]));
	}
}
