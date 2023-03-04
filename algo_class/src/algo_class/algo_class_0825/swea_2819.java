package algo_class_0825;

import java.io.*;
import java.util.*;

public class swea_2819 {
	static int[] di = {0,0,1,-1}; // 동서남북
	static int[] dj = {-1,1,0,0}; // 좌우하상
	static int[][] a;
	static Set<Integer> set;
	
	static void dfs(int i, int j, int cnt, int n) {
		if(cnt==7) {
			set.add(n);
			return;
		}
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(0<=ni && ni < 4 && 0<= nj && nj < 4) {
				dfs(ni,nj,cnt+1, n*10 + a[ni][nj]);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_2819.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++){
			// 중복을 체크해준다. 동적인 것은 Collections을 사용한다.
			set = new HashSet<>();
			a = new int[4][4];

			for(int i=0; i<4; i++){
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<4; j++){
					a[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//for(int[] a:map) System.out.println(Arrays.toString(a));
			
			for(int i =0;i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i,j, 1, a[i][j]);
				}
			}
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}











