package shortest;

import java.util.*;
import java.io.*;

//INF설정할 때 간선 200000 x 가중치 1000 을 해야 오버플로우 발생x
public class Main_1504 {
	static class Node implements Comparable<Node> {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static int N, E;
	static ArrayList<ArrayList<Node>> a; // 인접리스트
	static int[] dist; // 최단거리
	static boolean[] check;
	static int INF = 200000 * 1000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		a = new ArrayList<>();
		dist = new int[N + 1];
		check = new boolean[N + 1];

		Arrays.fill(dist, INF);

		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			a.get(start).add(new Node(end, weight));// 시작에서 끝으로 가는 가중치
			a.get(end).add(new Node(start, weight));// 끝에서 시작으로 가는 가중치
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// 1 -> v1 -> v2 -> N으로 가는 경우
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);

		// 1 -> v2 -> v1 -> N으로 가는 경우
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);

		int answer = 0;
		if (res1 >= INF && res2 >= INF) {
			answer = -1;
		} else {
			answer = Math.min(res1, res2);
		}

		System.out.println(answer);
	}

	static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		check = new boolean[N + 1];
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node tmp = pq.poll();
			int now = tmp.end;
			if (!check[now]) {
				check[now] = true;

				for (Node node : a.get(now)) {
					if (!check[node.end] && dist[node.end] > dist[now] + node.weight) {
						dist[node.end] = dist[now] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}

		}
		return dist[end];
	}

}
