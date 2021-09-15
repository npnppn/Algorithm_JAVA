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
				// ������ �Ÿ� üũ�ؼ� ������ ��ġ �����ϸ� ���� �߰�
				if (arr[i] - min >= mid) {
					cnt++;
					min = arr[i]; // ��ġ�Ѱ����� �ٽ� ����
				}
			}

			// �������� ������ ������Ž��
			if (cnt >= C) {
				result = mid;
				left = mid + 1;
			} else { // �������� ������ ����Ž��
				right = mid - 1;
			}

		}
		System.out.println(result);
	}

}
