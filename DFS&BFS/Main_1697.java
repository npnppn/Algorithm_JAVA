package dfs_bfs;

import java.io.*;
import java.util.*;
//���� �κп��� �� ��Ǯ����. ����üũ
public class Main_1697 {
	static int N, K;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ����
		K = sc.nextInt(); // ����

		visited = new int[100001];
		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N);
		}
	}

	static void bfs(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visited[a] = 1;

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = tmp + 1; // ��ġ 1����
				} else if (i == 1) {
					next = tmp - 1; // ��ġ 1����
				} else {
					next = tmp * 2; // ��ġ 2������
				}

				// ���� ã������ ����
				if (next == K) {
					System.out.println(visited[tmp]);
					return;
				}

				// ���� �ȿ� �ְ� �湮���� �������̸� �湮
				if (next >= 0 && next < visited.length && visited[next] == 0) {
					q.add(next);
					visited[next] = visited[tmp] + 1;
				}

			}

		}

	}

}
