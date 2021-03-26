package ssafy_algo;

import java.io.*;
import java.util.*;

public class Solution_3307 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine()); //수열의 길이
			int[] arr = new int[n]; // 수열 입력받는거 집어넣을 공간
			int[] dp = new int[n]; // 최장길이 저장 배열

			int max = 0;
			dp[0] = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 계속해서 인덱스를 늘려가며 최장길이 탐색
			for (int i = 1; i < n; i++) {
				dp[i] = 1; //dp배열 초기화
				for (int j = 0; j < i; j++) {
					if ( arr[i] > arr[j]  && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(dp[i], max);
			}
			System.out.println("#" + tc + " " + max);

		}

	}

}
