package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1325 {
	
	static int[] computer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		//각 컴퓨터(정점)별로 해킹할 수 있는 컴퓨터 수를 셈 -> 그 중에 최대값을 가진 컴퓨터를 출력
		computer = new int[N + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			dfs(i, visited, list);
			//System.out.println();
		}
		
		//최대로 해킹할 수 있는 컴퓨터 수를 구함
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, computer[i]);
		}
		
		//가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터가 여러개일수도 있기 때문에 for문을 돌면서 각 컴퓨터 번호를 출력
		for (int i = 1; i <= N; i++) {
			//System.out.println("i : " + i + ", value : " + computer[i] + "\n");
			if (computer[i] == max) {
				bw.write(i + " ");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int start, boolean[] visited, ArrayList<Integer>[] list) {
		visited[start] = true;
		//System.out.print(start + " ");

		for (int node : list[start]) {
			if (!visited[node]) {
				computer[node]++;
				dfs(node, visited, list);
			}
		}
		
	}

}