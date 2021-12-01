package array;

import java.io.*;
import java.util.*;

public class Main_2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		long result = (long) (a * b * c);
		int[] arr = new int[10];
		String s = Long.toString(result);
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - '0';
			arr[num]++;
		}
		for (int i : arr) {
			System.out.println(i);
		}

	}

}
