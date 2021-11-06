package two_pointer;

import java.io.*;
import java.util.*;

public class Main_11728 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[M];

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			b[i] = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();
		int left = 0;
		int right = 0;
		while (!(left == N || right == M)) {
			if (a[left] <= b[right]) {
				sb.append(a[left] + " ");
				left++;
			} else {
				sb.append(b[right] + " ");
				right++;
			}
		}

		if (left == N) {
			for (int i = right; i < M; i++) {
				sb.append(b[i] + " ");
			}
		}

		if (right == M) {
			for (int i = left; i < N; i++) {
				sb.append(a[i] + " ");
			}
		}
		System.out.println(sb);

	}

}
