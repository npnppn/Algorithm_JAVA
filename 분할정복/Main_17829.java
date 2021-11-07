package recursion;

import java.io.*;
import java.util.*;

public class Main_17829 {
	static int n;
	static int[][] map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		recursion(n);
		System.out.println(map[0][0]);
	}

	static void recursion(int num) {
		if (num == 1)
			return;

		//2*2로 확인해서 집어넣어
		for (int i = 0; i < n; i += 2) {
			for (int j = 0; j < n; j += 2) {
				int[] tmp = { map[i][j], map[i][j + 1], map[i + 1][j], map[i + 1][j + 1] };
				Arrays.sort(tmp);
				map[i / 2][j / 2] = tmp[2];
			}
		}

		recursion(num / 2);

	}

}
