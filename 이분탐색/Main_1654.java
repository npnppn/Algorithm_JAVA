package binary_search;

import java.io.*;
import java.util.*;

public class Main_1654 {
//Ư�� ������ ���� Ư�� ���̸� ã��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();

		int[] arr = new int[K];
		long max = 0; // �ִ� ����

		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		Arrays.sort(arr);
		
		long right = max;
		long left = 1;
		long mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			long cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				cnt += (arr[i] / mid);
			}

			if (cnt < N) { // �ִ� ���̸� ���̰�
				right = mid - 1;
			} else {// �ּ� ���̸� �÷�����
				left = mid + 1;
			}

		}
		System.out.println(right);
	}
}
