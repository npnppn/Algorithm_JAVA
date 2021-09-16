package binary_search;

import java.io.*;
import java.util.*;

public class Main_2470 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;

		int max = 2000000000; // ������ �ִ� �� ����� 10000000 �̴ϱ�!
		int first = 0; // ���� ���
		int second = 0; // �� ū ���

		// �������ͷ� ������ �ٿ�����
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (Math.abs(sum) < max) {
				first = arr[left];
				second = arr[right];
				max = Math.abs(sum);
			}

			if (sum > 0) {
				right--;
			} else {
				left++;
			}

		}
		StringBuilder sb = new StringBuilder();
		sb.append(first + " " + second);
		System.out.println(sb);
	}
}