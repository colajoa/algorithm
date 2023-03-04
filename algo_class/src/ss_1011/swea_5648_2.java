package ss_1011;

import java.io.*;
import java.util.*;

public class swea_5648_2 {
	// 0 상 1 하 2 좌 3 우
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map = new int[4001][4001];
	static int N, ans;
	static List<Atom> atom;
	static void print() {
		for(int i=0; i<atom.size(); i++) {
			System.out.println("R : "+atom.get(i).r+ " C : "+atom.get(i).c+" "+atom.get(i).eng);
		}
		System.out.println();
	}
	static class Atom {
		int r, c, dir, eng;

		public Atom(int r, int c, int dir, int eng) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.eng = eng;
		}
	}

	static void move() {
		ans = 0;
		print();
		while (!atom.isEmpty()) {
			for (int i = 0; i < atom.size(); i++) {
				Atom now = atom.get(i);
				// 움직이기 전에 map을 0으로 초기화
				map[now.r][now.c] = 0;
				now.r += dr[now.dir];
				now.c += dc[now.dir];

				if (now.r < 0 || now.r > 4000 || now.c < 0 || now.c > 4000) {
					atom.remove(i);
					i--;
					continue;
				}
				map[now.r][now.c] += now.eng;
				System.out.println(map[now.r][now.c]);
				print();
			}

			for (int i = 0; i < atom.size(); i++) {
				Atom now = atom.get(i);
				if(map[now.r][now.c] != now.eng) {
					System.out.println(map[now.r][now.c]);
					ans += map[now.r][now.c];
					map[now.r][now.c] = 0;
					atom.remove(i);
					i--;
				}
			}

			System.out.println("@"+ans);
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			atom = new ArrayList<>();

			for (int n = 0; n < N; n++) {
				token = new StringTokenizer(br.readLine());
				// x = c
				int x = (Integer.parseInt(token.nextToken())+1000) *2;
				// y = r
				int y = (Integer.parseInt(token.nextToken())+1000) *2;
				int dir = Integer.parseInt(token.nextToken());
				int eng = Integer.parseInt(token.nextToken());
				
				map[y][x] = eng;
				atom.add(new Atom(y, x, dir, eng));
				
			}
			move();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
