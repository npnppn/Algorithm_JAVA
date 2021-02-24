package ssafy_algo;

import java.io.*;

public class Main_Jungol_1037 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int index = 0;
			for (int j = 0; j < N; j++) {
				if (str.charAt(index) == '0') {
					map[i][j] = false;
				} else {
					map[i][j] = true;
				}
				index += 2;
			}
		}

		boolean flagCheck = false;
		if (rowSumCheck(map) && colSumCheck(map)) {
			System.out.println("OK");
			flagCheck = true;
		} else {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = !map[i][j];
					if (rowSumCheck(map) && colSumCheck(map)) {
						System.out.println("Change bit (" + (i + 1) + "," + (j + 1) + ")");
						flagCheck = true;
					}
					map[i][j] = !map[i][j];
				}
			}
		}
		if (flagCheck == false) {
			System.out.println("Corrupt");
		}

	}

	public static boolean rowSumCheck(boolean[][] map) {
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == true) {
					sum++;
				}
			}
			if (sum % 2 == 0)
				flag = true;
			else
				return false;
			sum = 0;
		}
		return flag;
	}

	public static boolean colSumCheck(boolean[][] map) {
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[j][i] == true) {
					sum++;
				}
			}
			if (sum % 2 == 0)
				flag = true;
			else
				return false;
			sum = 0;
		}
		return flag;
	}

}
