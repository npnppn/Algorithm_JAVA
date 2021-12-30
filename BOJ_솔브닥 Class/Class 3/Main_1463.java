package class3;

import java.io.*;
import java.util.*;
//만드는 경로의 수를 dp배열에 저장해 나가자
//i-1로 뺴준 연산 횟수에 +1  dp[i] = dp[i-1] +1;
//i/2로 나눈 수의 연산값과 1번에서 구한 연산값 중 최솟값 if(i%2==0) 
//i/3 로 나눈 수의 연산값과 1번에서 구한 연산값 중 최솟값 if(i%3==0) 

public class Main_1463 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
		}

		System.out.println(dp[n]);
	}

}
