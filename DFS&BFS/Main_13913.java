package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_13913 {
	static int N, K;
	static int[] visited;
	static int minTime = Integer.MAX_VALUE; // �ּҽð� �����صδ� ����
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		visited = new int[100001];
		parent = new int[100001];

		bfs(N);

		System.out.println(visited[K] - 1);

		// ��θ� �־�ΰ� ���ʷ� ���
		ArrayList<Integer> st = new ArrayList<>();
		int idx = K;
		while (idx != N) {
			st.add(idx);
			idx = parent[idx];
		}
		st.add(idx);

		while (!st.isEmpty()) {
			System.out.print(st.remove(st.size() - 1) + " ");
		}

	}

	static void bfs(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a); // ��ó�� �Է¹����� ť�� ��� Ž��
		visited[a] = 1;

		while (!q.isEmpty()) {
			int tmp = q.poll();

			if (tmp == K)
				return;

			for (int i = 0; i < 3; i++) {
				int next;
				// x-1 �̰ų� x+1 �̰ų� 2x�̰ų�..
				if (i == 0) {
					next = tmp + 1; // +1

				} else if (i == 1) {
					next = tmp - 1; // -1

				} else {
					next = tmp * 2; // x2

				}

				if (next >= 0 && next <= 100000) {
					if (visited[next] == 0) {
						q.add(next);
						visited[next] = visited[tmp] + 1;
						parent[next] = tmp;
					}
				}

			}
		}
	}
}