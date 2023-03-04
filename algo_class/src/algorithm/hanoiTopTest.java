package algorithm;

import java.util.Scanner;

public class hanoiTopTest {
	static int cnt = 1;
	static void hanoi(int N, int from, int to, int rest) {
		if (N == 1) {
			System.out.println(from + " " + to);
			System.out.println("! " + cnt++);
		} else {
			hanoi(N - 1, from, rest, to);
			System.out.println(from + " " + to);
			System.out.println("^ " + cnt++);
			hanoi(N - 1, rest, to, from);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		System.out.println((int)Math.pow(2, N)-1);
		hanoi(N, 1, 3, 2);
		
	}
}
