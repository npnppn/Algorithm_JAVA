package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_14248 {

	static int n;
	static int[] map;
	static int[] visited;
	static int[] dir = { 1, -1 };
	static int s;
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n];
		visited = new int[n];
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextInt();
		}
		s = sc.nextInt();

		bfs(s - 1);
		System.out.println(cnt);

	}

	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(num);
		visited[num] = 1;
		while (!q.isEmpty()) {
			num = q.poll();
			int tmp = map[num];
			for (int k : dir) {
				int nx = (k * tmp) + num;
				if (nx >= 0 && nx < n && visited[nx] == 0) {
					visited[nx] = -1;
					q.offer(nx);
					cnt++;
				}
			}
		}

	}

}
