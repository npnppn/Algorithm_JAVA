package Im_ex;

import java.io.*;
import java.util.*;

/* 주사위밑면이 어떤 부분일 경우 윗면이 어떤 부분이 온다는 것 알아야되겠네
 처음 시작은 6개 전부 다 체크
 아래부분이랑 위 제외할때 최대값 구하기
 다음 함수의 매개변수에 현재 위에 올 숫자와 이때까지의 합과 현재 옆면 중 최댓값을 인자로 넘겨 전달
완탐으로 다 돌아봐도 6^2 *10000이라 시간초과는 안 날듯
*/
public class Main_2116 {

	static int result, n;
	static int map[][];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][6];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 6; i++) {
			visit = new boolean[7];
			visit[map[0][i]] = true;
			int num = i;
			int find = 0;
			if (i == 0) {
				find = map[0][5];
			} else if (i == 1) {
				find = map[0][3];
			} else if (i == 2) {
				find = map[0][4];
			} else if (i == 3) {
				find = map[0][1];
			} else if (i == 4) {
				find = map[0][2];
			} else if (i == 5) {
				find = map[0][0];
			}
			visit[find] = true;
			int max = 0;
			for (int j = 6; j >= 1; j--) {
				if (!visit[j]) {
					max = j;
					break;
				}
			}
			next(1, find, max);

		}
		System.out.println(result);
	}

	private static void next(int next, int who, int sum) {
		visit = new boolean[7];
		if (next == n) {
			result = Math.max(result, sum);
			return;
		}
		visit[who] = true;
		int k = 0;
		for (int i = 0; i < 6; i++) {
			if (who == map[next][i]) {
				k = i;
			}
		}
		int find = 0;
		if (k == 0) {
			find = map[next][5];
		} else if (k == 1) {
			find = map[next][3];
		} else if (k == 2) {
			find = map[next][4];
		} else if (k == 3) {
			find = map[next][1];
		} else if (k == 4) {
			find = map[next][2];
		} else if (k == 5) {
			find = map[next][0];
		}
		visit[find] = true;
		int max = 0;
		for (int i = 6; i >= 1; i--) {
			if (!visit[i]) {
				max = i;
				break;
			}
		}
		next(next + 1, find, sum + max);
	}

}
