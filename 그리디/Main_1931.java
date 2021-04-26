package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1931 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 종료시간

		}

		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {

				// 종료 시간이 같은 경우 빠른순으로 정렬
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		int prev_end = 0;

		for (int i = 0; i < n; i++) {
			// 직전 종료시간이 다음 시작 시간보다 작거나 같다면 갱신
			if (prev_end <= arr[i][0]) {
				prev_end = arr[i][1];
				cnt++;
			}
		}

		System.out.println(cnt);

	}

}
