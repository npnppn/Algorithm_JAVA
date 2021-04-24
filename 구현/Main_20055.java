package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055 {

	static int n, k, map[], left, right;
	static boolean robot[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		k = Integer.parseInt(stz.nextToken());
		map = new int[2 * n];
		robot = new boolean[n];
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++)
			map[i] = Integer.parseInt(stz.nextToken());
		left = 0;
		right = n;

		int count = 0;
		while (k > 0) {
			count++;
			moveBelt();
			moveRobot();
			newRobot();
		}

		System.out.println(count);
	}

	// left, right의 값을 1씩 감소시킵니다. 원형 구조이므로 -1의 값이 된다면 2*n-1(우측)으로 이동
	// 벨트가 회전하면 로봇도 이동해야 하므로 우측으로 1칸씩 당겨줌. 내구도 소모는 없습니다.
	public static void moveBelt() {
		left--;
		right--;
		if (left == -1)
			left = 2 * n - 1;
		if (right == -1)
			right = 2 * n - 1;

		for (int i = n - 2; i >= 0; i--) {
			if (robot[i]) {
				robot[i] = false;
				if (i + 1 < n - 1)
					robot[i + 1] = true;
			}
		}
	}

	// 로봇이 우측으로 이동할 수 있다면 이동합니다. 단, 우측에 내구도가 있으며 로봇이 있으면 안 됩니다.
	// 로봇이 이동했다면 내구도를 1 감소시키고 0이 됐다면 k의 값을 1 감소시킵니다.
	public static void moveRobot() {
		for (int i = n - 2; i >= 0; i--) {
			if (robot[i]) {
				int next = left + i + 1;
				if (next >= 2 * n)
					next -= 2 * n;
				if (!robot[i + 1] && map[next] >= 1) {
					robot[i] = false;
					if (i + 1 < n - 1)
						robot[i + 1] = true;
					map[next]--;
					if (map[next] == 0)
						k--;
				}
			}
		}
	}

	// 벨트의 시작 부분(left)에 새 로봇을 놓습니다. 로봇이 놓였다면 내구도를 1 감소시킵니다.
	public static void newRobot() {
		if (!robot[0] && map[left] > 0) {
			robot[0] = true;
			map[left]--;
			if (map[left] == 0)
				k--;
		}
	}

}