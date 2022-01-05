package sort;

import java.util.*;
import java.io.*;

//StringBuilder의 reverse 함수 사용하여 다시 int형으로 캐스팅할지 잠깐 고민했음
public class Main_5648 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}

		long[] newarr = new long[n];
		for (int i = 0; i < n; i++) {
			newarr[i] = swap(arr[i]);
		}
		Arrays.sort(newarr);
		for (long i : newarr) {
			System.out.println(i);
		}
	}

	// 숫자를 뒤집자
	// 1234 = 1*1000 + 2*100 + 3*10 + 4*1
	// 이게 4321이 되려면 %연산하고 곱해서 그걸 다 더하면 되겠네
	static long swap(long num) {
		long value = 0;
		while (num != 0) {
			value = value * 10 + num % 10;
			num = num / 10;
		}
		return value;

	}

}
