package algo_1004;

import java.io.*;
import java.util.*;

public class Baekjoon_2239 {
	static int[][] map;
	static List<Zero> zero;
	static class Zero {
		int r, c;
		public Zero(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static void dfs(int depth) {
		if(zero.size() == depth) {
			for(int r=0; r<9; r++) {
				for(int c=0; c<9; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}
		int r = zero.get(depth).r;
		int c = zero.get(depth).c;
		
		for(int num=1; num<10; num++) {
			
			if(rowAndCol(r, c, num) && square(r, c, num)) {
				map[r][c] = num;
				dfs(depth+1);
				map[r][c] = 0;
			}
		}
	}
	
	static boolean rowAndCol(int r, int c, int num) {
		for(int i=0; i<9; i++) {
			if(num == map[r][i] || num == map[i][c]) 
				return false;
		}
		return true;
	}
	
	static boolean square(int r, int c, int num) {
		int tr = (r/3) * 3;
		int tc = (c/3) * 3;
		for(int i=tr; i<tr+3; i++) {
			for(int j=tc; j<tc+3; j++) {
				if(num==map[i][j])
					return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		zero = new ArrayList<>();
		for(int r=0; r<9; r++) {
			String str = br.readLine();
			for(int c=0; c<9; c++) {
				map[r][c] = str.charAt(c) - '0';
				if(map[r][c] == 0) zero.add(new Zero(r, c));
					
			}
		}
		
		dfs(0);
		
	} 
	
}
