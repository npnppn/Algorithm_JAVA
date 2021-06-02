import java.util.*;
import java.io.*;

public class Main_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[100][100];
		int cnt = 0;
		for (int k = 0; k < n; k++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			for (int i = x1; i < x1 + 10; i++) {
				for (int j = y1; j < y1 + 10; j++) {
					map[i][j] = 1;
				}
			}

		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);

	}

}
