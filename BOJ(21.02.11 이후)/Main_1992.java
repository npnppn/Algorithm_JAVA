package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_1992 {

	private static int n, m;
	private static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int[] num = new int[n]; // 첫줄의 문자열 담을 배열
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				num[j] = str.charAt(j);
				map[i][j] = num[j] - '0'; //숫자형으로 변환
			}
		}
		divide(0, 0, n);
	}

	// 배열안에 배열이 가지고 있는 요소가 같은지 체크
	private static boolean check(int row, int col, int n) {
		int comp = map[row][col];
		//현재 조각 크기 만큼만 for문 돌아야함 (row+n, col+n)
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (map[i][j] != comp) {
					return false;
				}
			}
		}
	
		return true;
	}

	// 2*2로 나누고 그안에 원소들이 같은지 체크, 다르면 하나씩 출력!! 왼쪽위->오른쪽위->왼쪽아래->오른쪽아래
	private static void divide(int row, int col, int n) {
		//n*n개 모두 같은 수로 이루어져 있으면
		if (check(row, col, n)) {
			System.out.print(map[row][col]); //그 수 출력
		}
		//아니라면 괄호 열고 4등분해서 각각 등분들의 첫 좌표들을 통해 다시 같은 수로 이루어졌는지 확인
		else {
			//왼쪽 위에 대한 일치성 탐색을 하기전에 ( 출력해야함
			System.out.print("(");
			
			int s = n / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(row + (s * i), col + (s * j), s);
				}
			}
			//오른쪽 아래에 대한 일치성 탐색 마치면 ) 출력
			System.out.print(")");
		}
	}

}