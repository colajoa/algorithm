package algorithm;

import java.util.*;
import java.io.*;

public class PCSTest {
	static int N, R, input[], numbers[];
	static boolean[] isSelected;
	static void perm(int depth, int flag) {
		if(depth==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if((flag & (1<<i)) != 0) continue;
			
			numbers[depth] = input[i];
			perm(depth+1, flag | (1<<i));
		}
	}
	
	static void comb(int depth, int start) {
		if(depth == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[depth] = input[i];
			comb(depth+1, i+1);
		}
	}
	
	static void subSet(int depth) {
		if(depth == N) {
			
			for(int i=0; i<N; i++) {
				System.out.print((isSelected[i] ? input[i] : "X" )+ " ");
			}
			System.out.println();
			return;
		}
		
			isSelected[depth] = true;
			subSet(depth+1);
			isSelected[depth] = false;
			subSet(depth+1);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		System.out.println("==========순열==========");
		perm(0,0);
		
		System.out.println("==========조합==========");
		comb(0,0);
		
		System.out.println("==========부분집합==========");
		subSet(0);
	}
}
