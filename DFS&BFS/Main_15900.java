package algo;

import java.io.*;
import java.util.*;

public class Main_15900 {
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;
	public static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		adjList = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// ����� ��������Ʈ ������ְ�
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}

		visited = new boolean[N + 1];
		dfs(1, 0, visited); // Ʈ�� ������ Ž����

		if (answer % 2 == 0) {// ���� ��忡�� ���� �������� ������ ���� ¦���� ������ ��
			System.out.println("No");
		} else { // Ȧ���� �����̰� �¸�
			System.out.println("Yes");
		}

	}

	//dfs
	public static void dfs(int cur, int cnt, boolean[] visited) {
		visited[cur] = true;
		
		for (int next : adjList[cur]) {
			if (!visited[next]) {
				dfs(next, cnt + 1, visited);
			}
		}

		//����� 1�̸� ��������� �Ŵϱ�
		if (adjList[cur].size() == 1) {
			answer += cnt;
		}
	}

}