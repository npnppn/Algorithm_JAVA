package baekjoon;

import java.util.*;
import java.io.*;

public class Main_2503 {
	static boolean check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 질문횟수
		String[] number = new String[N]; // 민혁이가 질문한 세자리수
		int[][] strikeball = new int[N][2]; // 스트라이크와 볼 입력받는거

		for (int i = 0; i < N; i++) {
			number[i] = sc.next();
			strikeball[i][0] = sc.nextInt(); // 스트라이크
			strikeball[i][1] = sc.nextInt(); // 볼
		}

		int cnt = 0; // 가능한 갯수
		// 서로다른 숫자 3개니까 자리수가 같지 않을 조건을 추가해주고 완탐 돌려야함
		for (int i = 1; i <= 9; i++) {// 첫째자리
			for (int j = 1; j <= 9; j++) { // 둘째자리
				if (i != j) { //첫째랑 둘째자리 달라야해서
					for (int k = 1; k <= 9; k++) { // 셋째자리
						if (k != j && k != i) { //셋째랑 첫째 혹은 셋째랑 둘째가 달라야해서
							check = true;
							for (int x = 0; x < N; x++) {
								int strike = 0;
								int ball = 0;
								String str = number[x];
								if (str.charAt(0) - '0' == i) // 첫째자리랑 물어본 숫자 첫째자리가 같을때 1스트라이크
									strike++;
								if (str.charAt(1) - '0' == j) // 둘째자리랑 물어본 숫자 둘째자리가 같을때 1스트라이크
									strike++;
								if (str.charAt(2) - '0' == k) // 셋째자리랑 물어본 숫자 셋째자리가 같을때 1스트라이크
									strike++;

								if (str.charAt(0) - '0' == j || str.charAt(0) - '0' == k) // 첫째자리랑 물어본 숫자둘째자리나 셋째자리랑 같을때
																							// 1볼
									ball++;
								if (str.charAt(1) - '0' == i || str.charAt(1) - '0' == k) // 둘째자리
									ball++;
								if (str.charAt(2) - '0' == i || str.charAt(2) - '0' == j) // 셋째자리
									ball++;

								if (strikeball[x][0] != strike || strikeball[x][1] != ball) { 
									check = false;
									break;
								}

							}
							if (check)

								cnt++;

						}

					}
				}

			}

		}
		System.out.println(cnt);
	}

}
