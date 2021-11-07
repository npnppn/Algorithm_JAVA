package recursion;

import java.io.*;
import java.util.*;

public class Main_18222 {
	static long k;
	static long[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextLong();
		arr = new long[128];

		// 0 01 0110 01101001 -> 2의제곱순으로 문자열 길이가 정해짐
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (long) Math.pow(2, i);
		}

		System.out.println(divide(k));

	}

	static long divide(long k) {
		if (k == 0)
			return 1;
		if (k == 1)
			return 0;

		long result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (k > arr[i])
				result = arr[i];
			else
				break;

		}
		return 1 - divide(k - result);

	}
}