package shortest;

import java.io.*;
import java.util.*;

//다익스트라 연습
public class Main_1916 {

	static class Node implements Comparable<Node> {
		int end, weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static int N, M;
	static boolean[] visited;
	static int[] dist;
	static ArrayList<ArrayList<Node>> a = new ArrayList<>();
	static int INF = 987654321;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(dist, INF);
		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			a.get(start).add(new Node(end, weight));
		}

		st = new StringTokenizer(br.readLine());
		int startPos = Integer.parseInt(st.nextToken());
		int endPos = Integer.parseInt(st.nextToken());

		int result = 0;
		result = dij(startPos, endPos);
		System.out.println(result);
	}

	static int dij(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node tmp = pq.poll();
			int now = tmp.end;

			if (!visited[now]) {
				visited[now] = true;

				for (Node node : a.get(now)) {
					if (!visited[node.end] && dist[node.end] > dist[now] + node.weight) {
						dist[node.end] = dist[now] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}

		}
		return dist[end];

	}

}
