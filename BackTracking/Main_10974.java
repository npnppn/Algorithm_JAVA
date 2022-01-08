package backtracking;

import java.io.*;
import java.util.*;

public class Main_10974 {

	static int n;
	static int[] selected;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		selected = new int[n];
		visited = new boolean[n + 1];

		dfs(0);
	}

	static void dfs(int toselect) {
		if (toselect == n) {
			for (int i : selected) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toselect] = i;
				dfs(toselect + 1);
				visited[i] = false;
			}
		}
	}

}
