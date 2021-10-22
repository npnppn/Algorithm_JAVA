package backt;

import java.io.*;
import java.util.*;

public class Main_15652 {
	static int n, m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		selected = new int[m];

		dfs(1, selected, 0);
		System.out.println(sb);

	}

	static void dfs(int start, int[] selected, int select) {
		if (select == m) {
			for (int i : selected) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n; i++) {
			selected[select] = i;
			dfs(i, selected, select + 1);
		}

	}

}
