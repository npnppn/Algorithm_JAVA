package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // 받는 문자열
		int N = s.length(); // 문자열의 길이
		int r = 0;
		int c = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i * j == N && i <= j) {
					r = i; //가장 큰게 r값
					c = j;
				}
			}
		} // r, c 정하기 끝
		
		// System.out.println(r + "," +c);
		int index = 0;
		char map[][] = new char[c][r];
		//열 0, 행 1 2 3 4
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				map[i][j] = s.charAt(index);
				index++;
			}
		}
		//행 0, 열 1 2 3 4
		for (int j = 0; j < r; j++) {
			for (int i = 0; i < c; i++) {
				System.out.print(map[i][j]);
			}
		}

	}
}