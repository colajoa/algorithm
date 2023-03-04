package algo_class_0818;

import java.util.*;
import java.io.*;

// nPr, nCr, 2^n
public class PermCombSub {
	static int N = 4, R = 3, C = 0;
	static int[] a = {1,2,3,4}, b = new int[R];
	static boolean[] v = new boolean[N];
	static void perm(int depth) {
		if(depth == R) {
			C+=1;
			//System.out.println(Arrays.toString(b));
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue; 	// 주석 처리 중복 순열 -> 방문처리를 하지 않기 때문에 계속 사용됨.
			v[i] = true;		//
			b[depth] = a[i];
			perm(depth+1);
			v[i] = false;		//
		}
	}
	
	static void comb(int depth, int start) {
		if(depth == R) {
			C+=1;
			System.out.println(Arrays.toString(b));
			return;
		}
		
		for(int i=start; i<N; i++) {
			b[depth] = a[i];
			comb(depth+1, i+1); 
			comb(depth+1, i); 	// i를 그대로 사용하면 중복 조합
		}
	}
	
	static void sub(int depth) {
		if(depth == N) {
			C += 1;
			for(int i=0; i<N; i++) {
				System.out.print(v[i]? a[i]+" " : "X ");
			}
			System.out.println();
			return;
		}
		
		v[depth] = true;
		sub(depth+1);
		v[depth] = false;
		sub(depth+1);
	}
	public static void main(String[] args) throws Exception{
		//perm(0); // 순열 4P3 = 4*3*2
		//comb(0,0);
		sub(0);
		System.out.println(C);
	}
}
