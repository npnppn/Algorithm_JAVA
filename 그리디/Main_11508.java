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

		// 2+1 ���
		// 2 2 3 3
		// 4 5 5 5 5 6
		Arrays.sort(arr, (o1, o2) -> o2 - o1); // ������������ �����ϰ�

		int sum = 0;
		for (int i = 0; i < N; i++) {
			// ���� ���� ���� �����ϴϱ� ���� ���� �ִ� index�� 3���� ���� �� �������� 2�� ��ġ�� �־����
			if (i % 3 == 2)
				continue;
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
