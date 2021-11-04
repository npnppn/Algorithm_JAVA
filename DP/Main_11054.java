package dp;

import java.io.*;
import java.util.*;

public class Main_11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dpLeft = new int[n + 1];
		int[] dpRight = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		dpLeft[1] = arr[1];
		dpRight[1] = arr[n];

		// ���ʿ��� �����ϴ� ������������ ���غ���
		for (int i = 1; i <= n; i++) {
			dpLeft[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					dpLeft[i] = Math.max(dpLeft[j] + 1, dpLeft[i]);
				}

			}
		}

		// �����ʿ��� �����ϴ� �������� ���غ���
		for (int i = n; i > 0; i--) {
			dpRight[i] = 1;
			for (int j = n; j > i; j--) {
				if (arr[i] > arr[j]) {
					dpRight[i] = Math.max(dpRight[j] + 1, dpRight[i]);
				}
			}

		}

		// �� �� ���Ѵ��� -1�ϸ� �ǰڱ�
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = Math.max(sum, dpRight[i] + dpLeft[i]);
		}

		System.out.println(sum-1);

	}

}
