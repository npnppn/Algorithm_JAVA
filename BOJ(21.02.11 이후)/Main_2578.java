package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2578 {
	static int[][] arr1 = new int[5][5];
	static int[][] arr2 = new int[5][5];
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr1[i][j] = sc.nextInt(); // 처음에 적는 빙고
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr2[i][j] = sc.nextInt();// 사회자가 말하는 숫자들
				cnt++;

				for (int x = 0; x < 5; x++) {
					for (int y = 0; y < 5; y++) {
						// 사회자가 말하는 숫자랑 일치하는 빙고판 숫자를 0으로 만듬
						if (arr2[i][j] == arr1[x][y]) {
							arr1[x][y] = 0;

							if (check(x, y) >= 3) {
								System.out.println(cnt);
								return;
							}
						}
					}
				}

				
			}
		}
	}

	//대각선 체크하는 함수
	private static int check(int r, int c) {
		int cnt = 0;
		
		// 가로 방향
		for (int i = 0; i < 5; i++) {
			int rcnt = 0;
			for (int j = 0; j < 5; j++) {
				if (arr1[i][j] == 0)
					rcnt++;
			}
			if (rcnt == 5)
				cnt++;
		}

		// 세로 방향
		for (int i = 0; i < 5; i++) {
			int ccnt = 0;
			for (int j = 0; j < 5; j++) {
				if (arr1[j][i] == 0)
					ccnt++;
			}
			if (ccnt == 5)
				cnt++;
		}
		// 우상향 대각선
		int ccnt = 0;
		for (int i = 4; i >= 0; i--) {

			if (arr1[4 - i][i] == 0)
				ccnt++;
			if (ccnt == 5)
				cnt++;
		}

		// 우하향 대각선
		ccnt = 0;
		for (int i = 0; i < 5; i++) {
			if (arr1[i][i] == 0)
				ccnt++;
			if (ccnt == 5)
				cnt++;
		}
		return cnt;

	}

}
