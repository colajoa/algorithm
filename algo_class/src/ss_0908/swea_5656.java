package ss_0908;

import java.io.*;
import java.util.*;

public class swea_5656 {
	static int N, w, h;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(token.nextToken());
			w = Integer.parseInt(token.nextToken());
			h = Integer.parseInt(token.nextToken());
			map = new int[h][w];
		}
	}
}
