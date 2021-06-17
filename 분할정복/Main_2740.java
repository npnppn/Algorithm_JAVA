package a0617;

import java.io.*;
import java.util.*;
//분할정복 기본문제! 문제를 분할할수 있는지 확인하고 -> 풀고 -> 다시 합치기
public class Main_2740 {

	// 색상 카운트 할 변수 및 색종이(board)
	public static int white = 0;
	public static int blue = 0;
	public static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt(); //입력받고
			}
		}

		partition(0, 0, N); //문제를 분할해서 풀거임

		System.out.println(white);
		System.out.println(blue);

	}

	public static void partition(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			if (board[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}

		int newSize = size / 2; // 절반 사이즈
		
		partition(row, col, newSize); // 2사분면
		partition(row, col + newSize, newSize); // 1사분면
		partition(row + newSize, col, newSize); // 3사분면
		partition(row + newSize, col + newSize, newSize); // 4사분면
	}

	// 현재 파티션의 컬러가 같은지 체크
	public static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col]; // 첫 번째 원소를 기준으로 검사
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				// 색상이 같이 않다면 false를 리턴
				if (board[i][j] != color) {
					return false;
				}
			}
		}
		// 검사가 모두 통과했다는 의미이므로 true 리턴
		return true;
	}
}
