package class2;

import java.io.*;
import java.util.*;

//2중 배열로 아파트 다 채워넣으면 간단.
public class Main_2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int apt[][] = new int[15][15];

			for (int i = 0; i < 15; i++) {
				apt[i][1] = 1; // i층 1호는 모두 1
				apt[0][i] = i; // 0층 호수에 맞게 사람들 숫자
			}

			for (int i = 1; i < 15; i++) { // 1층부터 14층까지
				for (int j = 2; j < 15; j++) { // 2호부터 14호까지 채워넣어
					apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
				}
			}
			System.out.println(apt[k][n]);
		}

	}

}
