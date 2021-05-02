package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9184 {
	static int a, b, c;
	static int[][][] dp = new int[21][21][21]; //담을 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {//-1 -1 -1이 입력되면 종료해야함
				break;
			}

			w(a, b, c); //dp돌려
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c))
					.append("\n");

		}
		System.out.println(sb);

	}

	static int w(int a, int b, int c) {
		if (inRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}

		//문제 첫번째 조건
		if (a <= 0 || b <= 0 || c <= 0) { 
			return 1;
		}

		//문제 두번째 조건
		if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}

		//문제 세번째 조건
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		
		//문제 네번째 조건
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	
	 //배열을 참조하려 할 때 a, b, c 중 하나라도 범위 밖의 수가 나올 수 있기 때문에 이를 체크를 해줘야함
	static boolean inRange(int a, int b, int c) {
		return (0 <= a) && (a <= 20) && (0 <= b) && (b <= 20) && (0 <= c) && (c <= 20);
	}

}
