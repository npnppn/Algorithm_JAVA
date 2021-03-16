package ssafy_algo;

import java.io.*;
import java.util.*;
//알파벳을 전부 입력 받으면 입력받은 알파벳 배열을 정렬한 상태에서 백트래킹

public class Main_1759 {
	public static int L;
	public static int C;

	public static int[] arr;
	public static boolean[] visited;

	public static final char[] MO_ARR = { 'a', 'e', 'i', 'o', 'u' };
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		arr = new int[C];
		visited = new boolean[C];
		sb = new StringBuilder();

		for (int i = 0; i < C; i++) {
			arr[i] = (int) st.nextToken().charAt(0);
		}
		Arrays.sort(arr); // 알파벳이 증가하는 형식이니 배열을 정렬한다.

		for (int i = 0; i < C; i++) {
			if (i + L > C)
				continue;
			visited[i] = true;
			backtracking(i, 1, (char) arr[i] + "");
			visited[i] = false;
		}

		System.out.println(sb.toString());
	}

	public static void backtracking(int idx, int cnt, String str) {
		if (idx >= arr.length || idx + L - cnt > C)
			return;

		if (cnt == L) {
			if (isAble())
				sb.append(str + "\n");
			return;
		}

		for (int i = idx + 1; i < C; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			backtracking(i, cnt + 1, str + (char) arr[i]);
			visited[i] = false;
		}

	}

	public static boolean isAble() {
		int MO_CNT = 0;
		int JA_CNT = 0;

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				if (isJa((char) arr[i])) {
					JA_CNT += 1;
				} else {
					MO_CNT += 1;
				}
			}
		}
		// 모음이 최소 한개 자음이 최소 두개 있어야 한다.
		if (MO_CNT == 0 || JA_CNT < 2)
			return false;

		return true;
	}

	public static boolean isJa(char c) {
		for (int i = 0; i < MO_ARR.length; i++) {
			if (c == MO_ARR[i])
				return false;
		}

		return true;
	}
}
