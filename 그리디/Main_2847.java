package greedy;

import java.io.*;
import java.util.*;

public class Main_2847 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1])
				continue;
			else {
				int value = 0;
				value = arr[i] - arr[i + 1] + 1;
				cnt += value;
				arr[i] = arr[i] - value;

			}
		}
		System.out.println(cnt);

	}

}
