package sort;

import java.io.*;
import java.util.*;

public class Main_2822 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		int[] arr2 = new int[8]; // 기존 배열 카피할 거
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = arr[i];
		}

		Arrays.sort(arr);
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 3; i < 8; i++) {
			ar.add(arr[i]);
		}
		// System.out.println(ar);
		for (int i : ar) {
			sum += i;
		}
		System.out.println(sum);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr2[i] == ar.get(j)) {
					System.out.print((i + 1) + " ");
				}
			}
		}
	}

}
