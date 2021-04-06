package permu_combi2;

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

	public static void permu(int toselect, int[] selected, boolean[] visited) {
		if (toselect == m) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true; // 방문 체크
				selected[toselect] = i; // 뽑기
				permu(toselect + 1, selected, visited); // 그 다음 값 뽑기위해 재귀호출
				visited[i] = false; // 뽑은 뒤 미방문 처리
			}
		}

	}

}
