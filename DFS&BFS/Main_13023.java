package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_13023 {
	static int n, m;
	static ArrayList<Integer>[] al;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		al = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			al[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			al[x].add(y);
			al[y].add(x);
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, 0);
		}
		System.out.println(0);
	}

	static void dfs(int a, int depth) {
		if (depth == 4) {
			System.out.println(1);
			System.exit(0);
		}

		visited[a] = true;
		for (int i = 0; i < al[a].size(); i++) {
			int value = al[a].get(i);
			if (!visited[value]) {
				visited[value] = true;
				dfs(value, depth + 1);
				visited[value] = false;
			}
		}
	}

}
