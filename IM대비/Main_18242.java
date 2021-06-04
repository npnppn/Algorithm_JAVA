package im;

import java.io.*;
import java.util.*;

public class Main_18242 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		int firstX = 0;
		int firstY = 0;
		int endX = 0;
		int endY = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '#') {
					firstX = i;
					firstY = j;

					i = n;
					j = m;
				}
			}
		}

		for (int i = n - 1; i > 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (map[i][j] == '#') {
					endX = i;
					endY = j;

					i = 0;
					j = 0;
				}
			}
		}

		// System.out.println(firstX + " " + firstY + " " + endX + " " + endY + " ");

		int length = endX - firstX + 1;
		int middle = length / 2;

		if (map[endX - middle][endY] == '.') {
			System.out.println("RIGHT");
		}

		else if (map[endX][endY - middle] == '.') {
			System.out.println("DOWN");
		}

		else if (map[firstX + middle][firstY] == '.') {
			System.out.println("LEFT");
		}

		else if (map[firstX][firstY + middle] == '.') {
			System.out.println("UP");
		}

	}

}
