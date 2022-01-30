package bfsdfs;

import java.io.*;
import java.util.*;

// 더이상 방문할 필요가 없는 노드를 구분해서 쓸데없는 탐색을 막는것이 문제의 핵심!
// 재귀 종료할 때 마지막에 finished를 트루로 바꿔주는걸 안해서 계속 틀렸다. 
public class Main_9466 {

	static int t, n, cnt;
	static int[] arr;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				if (!finished[i]) {
					dfs(i);
				}
			}

			System.out.println(n - cnt);

		}
	}

	static void dfs(int num) {
		if (visited[num]) {
			finished[num] = true; // 팀형성 완료하고 팀원 증가
			cnt++;
		} else {
			visited[num] = true; // 새로 팀원 꾸리기 시작
		}

		if (!finished[arr[num]]) { // 학생들 중 팀원 안정해졌으면 탐색
			dfs(arr[num]);
			visited[num] = false;
		}

		finished[num] = true; // 모든작업이 끝나면 사용하지 않으니까 true바꿔주기. 이부분때문에 계속 틀렸다.
	}

}
