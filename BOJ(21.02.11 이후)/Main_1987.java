package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_1987 {
	private static int r;
	private static int c;
	private static int max = Integer.MIN_VALUE;
	private static int[][] arr;
	private static boolean[] visit = new boolean[26];
	private static int[] dx = { 0, 0, 1, -1 };// 동 서 남 북
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		String temp;
		for (int i = 0; i < r; i++) {
			temp = br.readLine();
			for (int j = 0; j < c; j++) {
				// 저장하는 값이 위치값이 아니라 문자값이므로 아스키코드 연산
				arr[i][j] = temp.charAt(j) - 'A';
			}
		}
		visit[arr[0][0]] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int count) {
		if (max < count)
			max = count;
		int nx = 0;
		int ny = 0;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c) // 맵 벗어나는지 판단
				continue;
			int num = arr[nx][ny];
			if (!visit[num]) {
				visit[num] = true;
				dfs(nx, ny, count + 1); // 카운트 하나 더하고 다시 탐색
				visit[num] = false;
			}
		}
	}
}
