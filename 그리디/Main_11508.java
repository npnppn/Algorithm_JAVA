package sort;

import java.io.*;
import java.util.*;

public class Main_11508 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 2+1 행사
		// 2 2 3 3
		// 4 5 5 5 5 6
		Arrays.sort(arr, (o1, o2) -> o2 - o1); // 내림차순으로 정렬하고

		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 가장 작은 수를 빼야하니까 가장 끝에 있는 index는 3으로 나눌 때 나머지가 2인 위치에 있어야지
			if (i % 3 == 2)
				continue;
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
