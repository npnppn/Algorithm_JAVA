package binarysearch;

import java.io.*;
import java.util.*;

public class Main_14719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int[] arr = new int[w];
		int answer = 0;
		for (int i = 0; i < w; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < w - 1; i++) {
			int leftMax = 0; // 왼쪽에서 높은 벽돌 높이
			int rightMax = 0; // 오른쪽에서 높은 벽돌 높이

			// 왼쪽
			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, arr[j]);
			}
			// System.out.println(leftMax);

			// 오른쪽
			for (int j = i + 1; j < w; j++) {
				rightMax = Math.max(rightMax, arr[j]);
			}
			// System.out.println(rightMax);

			if (arr[i] < leftMax && arr[i] < rightMax) {
				answer += (Math.min(leftMax, rightMax) - arr[i]);
			}

		}

		System.out.println(answer);

	}

}
