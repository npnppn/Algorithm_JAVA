package permu_combi;

import java.util.*;
import java.io.*;

public class Main_15649 {

	private static int N;
	private static int M;
	private static boolean visited[];
	private static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		visited = new boolean[N + 1];
		permu(0, selected, visited);
		System.out.print(sb);
	}

	public static void permu(int toselect, int[] selected, boolean[] visited) {
		if (toselect == M) {
			for (int i : selected)
				sb.append(i + " ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true; // 방문 체크
				selected[toselect] = i; // 뽑기
				permu(toselect + 1, selected, visited); // 그 다음 값 뽑기위해 재귀호출
				visited[i] = false; // 뽑은 뒤 미방문 처리
			}
		}

	}

}
