package algorithm;

import java.util.Scanner;

public class FactorialTest {
	static int factorial1(int n) {
		int res = 1;
		for(int i=n; i>=1; i--) {
			res *= i;
		}
		return res;
	}
	static int res = 1; //공유를 위한 스태틱 멤버변수
	static void factorial2(int i) {
		if(i <= 1) return;
		res *= i;
		factorial2(i-1);
	}
	
	static int factorial3(int i) {
		if(i<= 1) return 1;
		return i*factorial3(i-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial1(n));
		factorial2(n);
		System.out.println(res);
		System.out.println(factorial3(n));
	}
}
