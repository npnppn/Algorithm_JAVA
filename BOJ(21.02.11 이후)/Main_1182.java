package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_1182 {
	private static int N;
	private static int S;
	private static int cnt = 0;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			backtracking(arr[i], i);
		}

		System.out.println(cnt);
	}

	private static void backtracking(int total, int depth) {
		if (depth == N - 1 && total == S) {
			cnt++;
		}
		depth++;
		
		//첫번째 원소를 선택할 것인지 말것인지 결정하는게 중요
		if (depth < N) {
			backtracking(total + arr[depth], depth); //지금 위치의 원소 선택하고 다음 깊이로 재귀
			backtracking(total, depth); //지금 위치의 원소는 빼고 다음 깊이로 재귀
		}
	}
}
