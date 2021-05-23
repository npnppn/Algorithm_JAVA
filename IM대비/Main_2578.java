package Im_ex;
import java.io.*;
import java.util.*;

public class Main_2578 {
	static int count;
	static int[][] arr1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr1 = new int[5][5];
		count = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}

		for (int a = 1; a <= 25; a++) {
			int n = sc.nextInt();

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr1[i][j] == n) {
						arr1[i][j] = 0;
					}
				}
			}

			rCheck();
			TCheck();
			llCheck();
			rrCheck();

			if (count >= 3) {
				System.out.println(a);
				break;
			}
			count = 0;

		}
	}

	// 가로 빙고
	public static void rCheck() {
		for (int i = 0; i < 5; i++) {
			int zeroCnt = 0;

			for (int j = 0; j < 5; j++) {
				if (arr1[i][j] == 0) {
					zeroCnt++;
				}
			}
			if (zeroCnt == 5)
				count++;
		}
	}

	// 세로 빙고
	public static void TCheck() {
		for (int i = 0; i < 5; i++) {
			int zeroCnt = 0;

			for (int j = 0; j < 5; j++) {
				if (arr1[j][i] == 0) {
					zeroCnt++;
				}
			}
			if (zeroCnt == 5)
				count++;
		}
	}

	// 왼쪽 대각선 빙고
	public static void llCheck() {
		int zeroCnt = 0;
		for (int i = 0; i < 5; i++) {
				if (arr1[i][i] == 0) {
					zeroCnt++;
			}
			if (zeroCnt == 5)
				count++;
		}
	}

	// 오른쪽 대각선 빙고
	public static void rrCheck() {
		int zeroCnt = 0;
		for (int i = 0; i < 5; i++) {
			
				if (arr1[i][4 - i] == 0) {
					zeroCnt++;
				}
			if (zeroCnt == 5)
				count++;
		}
	}

}
