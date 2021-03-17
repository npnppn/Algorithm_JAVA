package Im_ex;

import java.io.*;
import java.util.*;

public class Main_2491 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt1 = 0; // 증가할때 더해줄것들
		int cnt2 = 0; // 감소할때 더해줄것들
		int result = 0; // 최종 결과값(최댓값)

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				// i와 그 다음번에 있는 숫자를 비교해
				// 증가할 때는 cnt1을 증가시킴
				if (arr[i] <= arr[j]) {
					cnt1++;
				} else
					cnt1 = 1;
				result = Math.max(result, cnt1);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				// i와 그 다음번에 있는 숫자를 비교해
				// 감소할 때는 cnt2을 증가시킴
				if (arr[i] >= arr[j]) {
					cnt2++;
				} else
					cnt2 = 1;
				result = Math.max(result, cnt2);
			}
		}
		System.out.println(result - 1);
	}
}
