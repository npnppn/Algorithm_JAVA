package permu_combi2;

import java.io.*;
import java.util.*;

public class Main_15651 {
	static int n, m;
	static boolean[] visited;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n + 1];
		selected = new int[m];
		permu(0, selected, visited);
		System.out.print(sb);

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
		//	if (!visited[i]) {
		//		visited[i] = true;
				selected[toselect] = i;
				permu(toselect+1, selected, visited);
		//		visited[i] = false;

		//	}
//자신도 들어가야하니까 중복체크를 할필요가 없지
		}

	}

}
