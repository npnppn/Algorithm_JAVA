package swea;
//원리는 이해되는데 구현을 스스로 완벽하게 못했음..
import java.io.*;
import java.util.*;

public class Solution_4014 {
	private static int n, x;
	private static int[][] map1, map2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map1 = new int[n][n];
			map2 = new int[n][n];
			for (int i = 0; i < n; i++) {// 입력
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					map1[i][j] = num;
					map2[j][i] = num;
				}
			}
			int answer = solution();
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int solution() {
		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer += isOk(map1[i]);
			answer += isOk(map2[i]);
		}
		return answer;
	}

	private static int isOk(int[] array) { // 활주로 건설할 수 있으면 1, 없으면 0 리턴
		boolean[] check = new boolean[n];
		for (int i = 0; i < n - 1; i++) {
			int prev = array[i];
			int next = array[i + 1];
			if (Math.abs(prev - next) > 1)
				return 0; // 2 이상 차이나면 return 0
			if (check[i + 1] || prev == next)
				continue; // 평지거나 이미 지형이 있다면 패스

			if (prev > next) { // 내려갈 때 : 3 3 2 2 1 1
				for (int j = i + 1; j <= i + x; j++) { // 지형 설치 // n을 넘어가거나, 평지가 아니거나, 이미 지형이 있으면 return 0
					if (j == n || array[j] != next || check[j])
						return 0; // 지형의 마지막은 값 그대로 가져가기 위한 if문
					if (j != i + x)
						array[j] = next + 1;
					check[j] = true; // 지형 설치 체크
				}
			} else { // 올라갈 때 : 1 1 2 2 3 3
				for (int j = i; j > i - x; j--) {
					if (j < 0 || array[j] != prev || check[j])
						return 0;
					if (j != i - x + 1)
						array[j] = prev + 1;
					check[j] = true;
				}
			}
		}
		return 1;
	}
}
