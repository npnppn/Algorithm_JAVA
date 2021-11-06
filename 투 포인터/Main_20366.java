package two_pointer;

import java.io.*;
import java.util.*;

public class Main_20366 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;

		// 투포인터로 범위 좁혀나가자
		for (int i = 0; i < N - 3; i++) {
			for (int j = i + 3; j < N; j++) {
				int left = i + 1;
				int right = j - 1;

				while (left <= right) {
					int result = (arr[left] + arr[right]) - (arr[i] + arr[j]);

					if (min > Math.abs(result)) {
						min = Math.abs(result);
					}

					if (result > 0) {
						right = right - 1;

					} else {
						left = left + 1;
					}
				}

			}

		}
		System.out.println(min);

	}

}
