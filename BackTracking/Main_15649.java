package backt;

import java.io.*;
import java.util.*;

public class Main_15649 {
	static int n, m;
	static boolean[] visited;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		selected = new int[m];
		visited = new boolean[n + 1];
		permu(0, selected, visited);
		
		System.out.println(sb);
	}

	static void permu(int toselect, int[] selected, boolean[] visited) {
		if (toselect == m) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toselect] = i; // 惶扁
				permu(toselect + 1, selected, visited);
				visited[i] = false; // 惶篮 第 固规巩 贸府
			}
		}

	}

}
