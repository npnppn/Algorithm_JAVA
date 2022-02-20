package shortest;

import java.io.*;
import java.util.*;

public class Main_14588 {
	static int arr[][];
	static int l[], r[];
	static int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];
		l = new int[n + 1];
		r = new int[n + 1];

		// 그래프 초기화
		for (int i = 1; i < n; i++) {
			for (int j = i; j <= n; j++) {
				if (i == j)
					continue;
				else {
					arr[i][j] = arr[j][i] = INF;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			l[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
		}

		// 선분으로 친구관계설정
		// 1. 왼쪽은 겹치고 오른쪽은 선분 밖에 2.오른쪽은 겹치고 왼쪽은 선분 밖에 3.하나가 다른거에 포함될 때
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if ((l[i] <= l[j] && l[j] <= r[i]) || (l[i] <= r[j] && r[j] <= r[i]) || (l[j] <= l[i] && l[i] <= r[j])
						|| (l[j] <= r[i] && r[i] <= r[j])) {
					arr[i][j] = arr[j][i] = 1;
				}
			}
		}

		// 플로이드
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int q = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < q; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (arr[a][b] == INF) {
				System.out.println(-1);
			} else {
				System.out.println(arr[a][b]);
			}

		}
	}
}