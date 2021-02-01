package ssafy_algo;

import java.io.*;
import java.util.*;

public class Solution_IM_Exercise {

	public static void main(String[] args) throws Exception {
		int[] di = { -1, 0, 1, 0 };// 상, 우, 하, 좌
		int[] dj = { 0, 1, 0, -1 };
		
		System.setIn(new FileInputStream("res/input_IM_Exercise.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// System.out.println("T=[" + T + "]");
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			// System.out.println("N=[" + N + "]");
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}
//			for (char[] c : map) System.out.println(Arrays.toString(c));
			
			//4방향 탐색 : 상, 하, 좌, 우
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 'A') {
						
						for (int k = 0; k < 4; k++) {
							int ni = i + di[k]; // 새로운 i 좌표
							int nj = j + dj[k]; // 새로운 j 좌표
							if(0<=ni && ni<map.length && 0<=nj && nj<map[0].length)
							System.out.print(map[ni][nj]);

						}
						System.out.println();
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H')
						cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}