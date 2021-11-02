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

		// �����ؼ� ���� ū�Ÿ� �������� ��� �տ� 2�� ���Ѱ͵��̶� ���غ��� �� ��
		Arrays.sort(arr);
		long max = arr[n - 1];
		long total = 0;

		//¦���� �� �ε����� 0�� n ����, 1�� n-1 �̷��� ���س���
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
