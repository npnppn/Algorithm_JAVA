package greedy;

import java.io.*;
import java.util.*;

public class Main_20300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}

		// 정렬해서 가장 큰거를 기준으로 삼고 앞에 2개 더한것들이랑 비교해보면 될 듯
		Arrays.sort(arr);
		long max = arr[n - 1];
		long total = 0;

		//짝수일 떄 인덱스가 0과 n 사이, 1과 n-1 이렇게 비교해나감
		if (n % 2 == 0) {
			for (int i = 0; i < n / 2; i++) {
				max = Math.max(max, arr[i] + arr[n - 1 - i]);
			}
		} else {
			for (int i = 0; i < (n - 1) / 2; i++) {
				max = Math.max(max, arr[i] + arr[n - 2 - i]);
			}
		}
		System.out.println(max);

	}

}
