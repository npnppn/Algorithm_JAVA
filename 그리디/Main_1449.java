package sort;

import java.io.*;
import java.util.*;

public class Main_1449 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		// 다음 구멍과 현재 구멍의 차이 +1과 테이프 길이를 비교해보자
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				cnt++;
				continue;
			}

			int hole = arr[i++];
			while (n > i) {
				if (arr[i] - hole + 1 <= l) {
					i++;
				} else {
					break;
				}
			}
			cnt++;
			i--;
		}

		System.out.println(cnt);

	}

}
