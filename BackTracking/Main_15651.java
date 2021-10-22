package backt;

import java.io.*;
import java.util.*;

//print만 하면 시간초과뜸..
public class Main_15651 {
	static int n, m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		selected = new int[m];

		dfs(0);
		System.out.println(sb);

	}

	static void dfs(int select) {
		if (select == m) {
			for (int i : selected) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			selected[select] = i;
			dfs(select + 1);
		}
	}

}
