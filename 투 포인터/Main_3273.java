package binary_search;

import java.io.*;
import java.util.*;

public class Main_3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}
		Arrays.sort(arr);
		int target = sc.nextInt();
		int left = 0;
		int right = N - 1;
		int cnt = 0;
		while (left < right) {
			if (arr[left] + arr[right] >= target) {
				if (arr[left] + arr[right] == target) {
					cnt++;
				}
				//합한게 더 타겟보다 크면 최대값를 줄이고
				right--;
			} else { //타켓이 더 큰거면 최솟값을 늘려
				left++;
			}
		}
		System.out.println(cnt);

	}
}
