package backt;

import java.io.*;
import java.util.*;

public class Main_15650 {
	static int n, m;
	static int[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		selected = new int[m];

		combi(1, 0);

	}

	static void combi(int start, int select) {
		if (select == m) {
			for (int i : selected) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= n; i++) {
			selected[select] = i;
			combi(i + 1, select + 1);

		}
	}

}
