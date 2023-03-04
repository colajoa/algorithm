package algo_class_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_8382 {
	static int distance(int x1, int y1, int x2, int y2) {
		int dis = 0;
		
		int max = Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
		int nx = Math.abs(x1-x2);
		int ny = Math.abs(y1-y2);
		dis = (nx+ny)%2 == 0 ? max*2 : (max*2) - 1;
		return dis;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			
			sb.append("#").append(t).append(" ").append(distance(x1,y1,x2,y2)).append("\n");
		}
		System.out.println(sb);
	}
}
