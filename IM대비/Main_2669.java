import java.util.*;
import java.io.*;

public class Main_2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int cnt = 0;

		for (int tc = 1; tc <= 4; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = 1;
				}
			}

		}

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
