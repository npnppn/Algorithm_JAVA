package dfs_bfs;

import java.io.*;
import java.util.*;
//큐에서 어떤값을 넣고 빼야하는지를 잘 몰랐다. 나중에 한번더 풀어보기.
public class Main_1707 {
	static int v, e;
	static ArrayList<Integer>[] al;
	static int visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			v = sc.nextInt();
			e = sc.nextInt();
			visit = new int[v + 1];
			al = new ArrayList[v + 1];

			for (int i = 0; i <= v; i++) {
				al[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				al[x].add(y);
				al[y].add(x);
			}

			bfs();
		}
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= v; i++) {
			if (visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}

			while (!q.isEmpty()) {
				int now = q.poll();
				for (int j = 0; j < al[now].size(); j++) {
					if (visit[al[now].get(j)] == 0) {
						q.add(al[now].get(j));
					}

					if (visit[al[now].get(j)] == visit[now]) {
						System.out.println("NO");
						return;
					}

					if (visit[now] == 1 && visit[al[now].get(j)] == 0)
						visit[al[now].get(j)] = 2;
					else if (visit[now] == 2 && visit[al[now].get(j)] == 0)
						visit[al[now].get(j)] = 1;
				}
			}
		}

		System.out.println("YES");
	}

}