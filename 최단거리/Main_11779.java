package shortest;

import java.io.*;
import java.util.*;

//최소비용과 역추적까지. 경로 출력할 때 end넣고 start부터 출력하니까 스택활용하면 간단
public class Main_11779 {
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

	static int n, m;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> a = new ArrayList<>();
	static int[] road; // 역추적길
	static int INF = 987654321;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		visited = new boolean[n + 1];
		dist = new int[n + 1];
		road = new int[n + 1];
		Arrays.fill(dist, INF);
		for (int i = 0; i <= n; i++) {
			a.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			a.get(start).add(new Node(end, weight));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int result = 0;
		result = dij(v1, v2);
		System.out.println(result);
		// System.out.println(Arrays.toString(road));

		// 역추적 시작
		Stack<Integer> stack = new Stack<>();
		while (true) {
			stack.push(v2);
			v2 = road[v2];
			if (v2 == v1) {
				stack.push(v2);
				break;
			}
		}
		System.out.println(stack.size());

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
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
						road[node.end] = now; // 이전노드 기록
						pq.add(new Node(node.end, dist[node.end]));

					}
				}
			}
		}

		return dist[end];
	}

}
