package baekjoon;

import java.util.*;
import java.io.*;

public class Main_11725 {
	static int n;
	static ArrayList<Integer>[] list;
	static int[] parents;
	static boolean[] visited;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1]; // 연결 정보
		parents = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) { //초기화해주고
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < n; i++) { //연결해줘
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
			}

		}
		for (int i = 2; i <= n; i++) {
			System.out.println(parents[i]);
		}

	}

	//루트값이 1이니까 1부터 dfs돌리면됨
	static void dfs(int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;
		for (int i : list[v]) {
			if (!visited[i]) {
				parents[i] = v;
				dfs(i);
			}
		}
	}

}
