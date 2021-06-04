package im;

import java.util.*;
import java.io.*;

public class Main_2527 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			int x4 = sc.nextInt();
			int y4 = sc.nextInt();

			// 점일때
			if ((x2 == x3 && y2 == y3) || (x1 == x4 && y2 == y3) || (x2 == x3 && y1 == y4) || (x1 == x4 && y1 == y4)) {
				System.out.println("c");
			}

			// 안겹칠때
			else if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
				System.out.println("d");
			}

			// 선분 일때
			else if ((x2 == x3 && y2 != y3) || (x1 == x4 && y2 != y3) || (x2 != x3 && y1 == y4)
					|| (x1 != x4 && y1 == y4)) {
				System.out.println("b");
			}

			// 나머진 다 직사각형
			else {
				System.out.println("a");
			}
		}

	}
}