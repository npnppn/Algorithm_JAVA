package data_structure;

import java.io.*;
import java.util.*;

public class Main_17298 {

	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Stack<Integer> left = new Stack<>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			while (!left.isEmpty() && arr[left.peek()] < arr[i]) {
				arr[left.pop()] = arr[i];
			}
			left.push(i);
		}
		
		while (!left.isEmpty()) {
			arr[left.pop()] = -1;
		}

		for (int i : arr) {
			sb.append(i + " ");
		}

		System.out.println(sb);

	}

}
