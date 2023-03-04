package algo_1012;

import java.io.*;
import java.util.*;

// 구간을 생각해서 범위 계산
// 부분집합으로 최대 이득을 계산
// 선택 후 선택
public class swea_2115 {

	static int N, M, C, ans;
	static int[][] map;
	static int[][] selected;
	
	// 구간마다의 이득 계산
	static void honey() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<=N-M; c++) {
				sub(r, c, 0, 0, 0);
			}
		}
	}
	
	static void sub(int r, int c, int cnt, int sum, int money) {
		// 최대로 채취할 수 있는 양을 넘어가면 return
		if(sum > C) return;
		
		// 선택이 다되면 기존 칸에 있는 값과 money를 비교 최대 값 갱신
		if(cnt == M) {
			selected[r][c-M] = Math.max(selected[r][c-M], money);
			return;
		}
		// 선택
		sub(r, c+1, cnt+1, sum+map[r][c], money+map[r][c]*map[r][c]);
		
		// 비선택 
		sub(r, c+1, cnt+1, sum, money);
	}
	static void choose() {
		// 첫번째 벌통 선택
		for (int r = 0; r < N; r++) {
			for (int c = 0; c <= N - M; c++) {
				comb(r, c+M, 1, selected[r][c]);
			}
			
		}
	}
	
	// 두번째 벌통 선택
	static void comb(int r, int c, int cnt, int sum) {
		if(cnt==2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		// 열의 범위를 넘어가면 다음 행으로 가서 선택되도록 범위를 지정
		// 겹쳐서 선택을 할수 없기 때문에 이전 선택의 다음 열 좌표를 넘겨준다.
		for(int nr=r; nr<N; nr++) {
			for(int nc=c; nc<=N-M; nc++) {
				comb(nr, nc, cnt+1, sum+selected[nr][nc]);
			}
			// 다음 행 선택을 위해 열 번호 초기화
			c = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());

			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			C = Integer.parseInt(token.nextToken());
			ans = Integer.MIN_VALUE;
			map = new int[N][N];
			selected = new int[N][N-M+1];
			

			for (int r = 0; r < N; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
				}
			}
			honey();
			choose();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
