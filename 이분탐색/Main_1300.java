package binary_search;

import java.io.*;
import java.util.*;

public class Main_1300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		long left = 1, right = K;
		long ans = 0;

		// 이분 탐색
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;

			// mid보다 작거나 같은 수는 몇 개인지 계산.
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}

			if (cnt < K) {
				left = mid + 1;
			} else {
				ans = mid;
				right = mid - 1;
			}
		}

		System.out.println(ans);

	}

}
