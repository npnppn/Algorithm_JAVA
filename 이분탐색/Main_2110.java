package binary_search;

import java.io.*;
import java.util.*;

public class Main_2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		int left = 1;
		int right = arr[N - 1] - arr[0];
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int min = arr[0];
			int cnt = 1;

			for (int i = 0; i < N; i++) {
				// 집마다 거리 체크해서 공유기 설치 가능하면 갯수 추가
				if (arr[i] - min >= mid) {
					cnt++;
					min = arr[i]; // 설치한곳부터 다시 시작
				}
			}

			// 실제보다 많으면 오른쪽탐색
			if (cnt >= C) {
				result = mid;
				left = mid + 1;
			} else { // 실제보다 적으면 왼쪽탐색
				right = mid - 1;
			}

		}
		System.out.println(result);
	}

}
