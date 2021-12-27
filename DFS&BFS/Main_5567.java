package bfsdfs;

import java.io.*;
import java.util.*;

//생각한 로직 : 일단 친구인 관계인 애부터 찾고, 그 애에서 연결된애를 찾으면 걔가 바로 친구의 친구!
public class Main_5567 {

	static ArrayList<ArrayList<Integer>> map;
	static boolean[] visited;
	static int n, m, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new ArrayList<>();
		visited = new boolean[n + 1];
		cnt = 0;

		for (int i = 0; i < n + 1; i++) {
			map.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map.get(a).add(b);
			map.get(b).add(a);
		}

		dfs(1, 0);
		for (int i = 2; i <= n; i++) {
			if (visited[i])
				cnt++;
		}

		System.out.println(cnt);

	}

	static void dfs(int i, int ans) {
		if (ans == 2)
			return;
		for (Integer k : map.get(i)) {
			visited[k] = true;
			dfs(k, ans + 1);
		}
	}

}
