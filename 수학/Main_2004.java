package math;

import java.io.*;
import java.util.*;

public class Main_2004 {

	// nCr = n! / r! * (n-r)! 이므로
	// 우선 n!에서 사용된 2와 5의 개수를 더하고
	// 그다음은 r!
	// 그 다음은 (n-r)!에서 사용된 2와 5의 개수는 빼주면 끝

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		long cnt2 = count2(N) - count2(M) - count2(N - M);
		long cnt5 = count5(N) - count5(M) - count5(N - M);

		System.out.println(Math.min(cnt2, cnt5));
	}

	// 5의 배수 구하기
	public static long count5(int num) {
		long tmp = 0;
		if (num < 5)
			return 0;
		for (long i = 5; i <= num; i = i * 5) {
			tmp = tmp + (num / i);
		}
		return tmp;
	}

	// 2의 배수 구하기
	public static long count2(int num) {
		long tmp = 0;
		if (num < 2)
			return 0;
		for (long i = 2; i <= num; i = i * 2) {
			tmp = tmp + (num / i);
		}
		return tmp;
	}

}