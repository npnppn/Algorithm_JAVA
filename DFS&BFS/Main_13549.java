package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_13549 {
	static int N, K;
	static boolean[] visited = new boolean[100001];
	static int minTime = Integer.MAX_VALUE;
	static int max = 100000;

	static class Node {
		int x;
		int time;

		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs();
		System.out.println(minTime);

	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x] = true;

			if (node.x == K)
				minTime = Math.min(minTime, node.time);

			// *2부터 진행해야 최소로 탐색을 하니까
			if (node.x * 2 <= max && visited[node.x * 2] == false)
				q.offer(new Node(node.x * 2, node.time));

			if (node.x + 1 <= max && visited[node.x + 1] == false)
				q.offer(new Node(node.x + 1, node.time + 1));
			if (node.x - 1 >= 0 && visited[node.x - 1] == false)
				q.offer(new Node(node.x - 1, node.time + 1));
		}
	}

}
