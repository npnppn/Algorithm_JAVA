package greedy;

import java.io.*;
import java.util.*;

public class Main_1758 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		// 원래 주려고 생각했던 돈 - 받은 등수 의 최잿값?
		long sum = 0;
		int rank = 0;
		for (int i = n - 1; i > -1; i--) {
			if (arr[i] - rank <= 0) {
				break;
			} else {
				sum += arr[i] - rank;
				rank++;
			}
		}
		System.out.println(sum);
	}

}
