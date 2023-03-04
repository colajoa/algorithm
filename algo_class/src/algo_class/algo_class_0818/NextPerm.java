package algo_class_0818;

import java.util.Arrays;

public class NextPerm {
	static  int N = 4, C=0;
	static int[] a= {3,1,4,2};
	
	static boolean np() {
		
		int i = N-1;
		int j = N-1;
		int k = N-1;
		while(i > 0 && a[i-1] >= a[i]) i--; 
		
		if(i==0) return false; 
		
		while(a[i-1] >= a[j]) j--; 
		swap(i-1, j); 
		
		while(i<k) swap(i++, k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int T = a[i];
		a[i] = a[j];
		a[j] = T;
	}
	public static void main(String[] args) {
		Arrays.sort(a);
		
		do {
			C++;
			System.out.println(Arrays.toString(a));
		}while(np());
		System.out.println(C);
	}
}
