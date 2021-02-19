package ssafy_algo;

import java.util.*;
import java.io.*;


/*순열을 만들면서 좌우 넣어봤는데 시간초과 뜸.
순열을 다 만들고나서 좌우 비교해야 통과됨.
*/

public class Solution_3234 {
	static int[] gram;
	static int N;
	static int nSum;
	static boolean[] select;
	static int cnt;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			gram = new int[N];
			nSum = 0;
			select = new boolean[N];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				gram[i] = Integer.parseInt(st.nextToken());
			}
			permutation(0, new int[N], new boolean[N]);

			System.out.println("#" + t + " " + cnt);
		}
	}

	private static void permutation(int select, int[] save, boolean[] visited) {
		if (select == N) {
			compare(1, save[0], 0, save);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				save[select] = gram[i];
				permutation(select + 1, save, visited);
				visited[i] = false;
			}
		}
	}

	private static void compare(int idx, int left, int right, int[] save) {

		if (idx == N) {
			cnt++;
			return;
		}

		compare(idx + 1, left + save[idx], right, save);
		if (save[idx] + right > left)
			return;
		compare(idx + 1, left, right + save[idx], save);
	}
}