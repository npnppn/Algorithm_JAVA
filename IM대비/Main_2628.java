package im;

import java.io.*;
import java.util.*;

public class Main_2628 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[n][m];
		int t = sc.nextInt();

		ArrayList<Integer> width = new ArrayList<Integer>();
		ArrayList<Integer> height = new ArrayList<Integer>();

		for (int tc = 0; tc < t; tc++) {
			int how = sc.nextInt();
			int value = sc.nextInt();

			if (how == 0) {
				height.add(value); // 2 3
			} else {
				width.add(value); // 4
			}

		}

		Collections.sort(height);
		Collections.sort(width);
		// System.out.println(height.get(height.size()-1));
		// System.out.println(width);
		
		int w = 0;
		int start = 0;
		for (int i = 0; i < width.size(); i++) {
			if (width.get(i) - start > w) {
				w = width.get(i) - start;
			}
			start = width.get(i);
		}
		
		if (m - start > w) {
			w = m - start;
		}
		int h = 0;
		start = 0;
		for (int i = 0; i < height.size(); i++) {
			if (height.get(i) - start > h) {
				h = height.get(i) - start;
			}
			start = height.get(i);
		}
		if (n - start > h) {
			h = n - start;
		}
		System.out.println(h * w);
	}

}