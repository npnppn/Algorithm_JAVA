package Im_ex;

import java.io.*;
import java.util.*;

public class Main_2559 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int length = (N - K)+1; //몇번 반복하는지.
		int max = Integer.MIN_VALUE;

		//N-K만큼 반복
		for (int i = 0; i < length; i++) {
			int sum = 0;
			//K번 반복하여 sum에 넣어줌
			for (int j = i; j < i+K; j++) {
				sum += arr[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
