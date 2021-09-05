package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_12851 {
	static int N, K;
	static int[] visited;
	static int minTime = Integer.MAX_VALUE; // �ּҽð� �����صδ� ����
	static int cnt = 0; // �ּҽð� ���� ���� ����� ��

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		
		visited = new int[100001];
		if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		bfs(N);

		System.out.println(minTime);
		System.out.println(cnt);
	}

	static void bfs(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a); // ��ó�� �Է¹����� ť�� ��� Ž��
		visited[a] = 1;

		while (!q.isEmpty()) {
			int tmp = q.poll();

			if (minTime < visited[tmp]) // �湮�� �ð��� �ּҽð����� ũ�� ����
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

				
				if (next == K) {
					// System.out.println(visited[tmp]);
					minTime = visited[tmp]; // �� �湮�ð��� �ּҽð��̴ϱ� �̰� �ϴ� ����
					cnt++;

				}

				if (next >= 0 && next <= 100000) {
					if (visited[next] == 0 || visited[next] == visited[tmp] + 1) {
						q.add(next);
						visited[next] = visited[tmp] + 1;
					}
				}

			}
		}
	}
}