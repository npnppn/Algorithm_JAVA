package a0709;

import java.io.*;
import java.util.*;

public class Main_2981 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		//Arrays.sort(arr);

		int gcdVal = arr[1] - arr[0];
		for (int i = 2; i < N; i++) {
			gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]); // 직전의 최대 공약수와 다음 수의 최대공약수를 갱신
		}

		// 최대공약수의 약수들 찾기
		for (int i = 2; i <= gcdVal; i++) {
			// i가 최대공약수의 약수라면 출력
			if (gcdVal % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

	// 최대공약수 유클리드 호제법으로
	static int gcd(int a, int b) {
		while (b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}