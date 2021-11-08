package backt;

import java.io.*;
import java.util.*;

public class Main_14712 {
	static int[][] map;
	static int n, m;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		dfs(0);
		System.out.println(res);

	}

	static void dfs(int cnt) {
		if (cnt == n * m) {
			res++;
			return;
		}
		int x = cnt % m + 1;
		int y = cnt / m + 1;

		// ���� �� ������ 1 �÷��� �ٽ� �ݺ�
		if (map[y - 1][x] == 1 && map[y][x - 1] == 1 && map[y - 1][x - 1] == 1) {
			dfs(cnt + 1);
		} else {
			dfs(cnt + 1); // ���� ���ϰ� ������ ��
			map[y][x] = 1;
			dfs(cnt + 1); // ���� �ϰ� ������ ��
			map[y][x] = 0;
		}

	}

}
