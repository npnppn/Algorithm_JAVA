package sort;

import java.io.*;
import java.util.*;

public class Main_7795 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}

			int cnt = 0;
			Arrays.sort(a);
			Arrays.sort(b);
			for (int i : a) {
				for (int j : b) {
					if (i <= j)
						break;
					else
						cnt++;
				}
			}
			System.out.println(cnt);

		}
	}

}
