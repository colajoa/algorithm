package a0818.add;

import java.io.*;
import java.util.*;

public class Solution_d9_2117_홈방범서비스_지역_반_홍길동 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_2117.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int K=N;//+서비스영역반지름
			int[][] map=new int[N][N];
			for(int i=0; i<N; i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//for(int[] a:map) System.out.println(Arrays.toString(a));
			
			int max=0;
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					for(int k=0; k<=K; k++){
						int cnt=0;
						for(int r=i-k; r<=i+k; r++){
							if(r<0||N<=r) continue;
							for(int c=j-k; c<=j+k; c++){
								if(c<0||N<=c) continue;
								if(Math.abs(r-i)+Math.abs(c-j)>k) continue;
								//if(map[r][c]==1) cnt++;
								cnt+=map[r][c];
							}
						}
						if(cnt*M-((k*k)+(k+1)*(k+1))>=0) max=Math.max(max,cnt);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}










