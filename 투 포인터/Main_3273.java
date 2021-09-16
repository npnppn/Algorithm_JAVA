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
				//���Ѱ� �� Ÿ�ٺ��� ũ�� �ִ밪�� ���̰�
				right--;
			} else { //Ÿ���� �� ū�Ÿ� �ּڰ��� �÷�
				left++;
			}
		}
		System.out.println(cnt);

	}
}
