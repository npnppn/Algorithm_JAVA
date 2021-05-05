package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11659 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수의 개수
		int[] arr = new int[n + 1];
		arr[0] = 0;
		int m = sc.nextInt(); // 합을 구해야 하는 횟수
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i - 1] + sc.nextInt(); //1번부터 지금까지의 합을 구해
		}
		
		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(arr[end] - arr[start - 1]); //start~end 까지의 압 = 1부터 end까지의 합 - 1번부터 start-1까지의 합
		}

	}

}
