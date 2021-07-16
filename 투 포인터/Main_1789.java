package algo;

import java.io.*;
import java.util.*;

//1���� ���ذ��鼭 �־��� S�� ���� �ʴ� ������ ��� ������ �� ������ ���� ��!
public class Main_1789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();

		System.out.println(solve(n));
	}

	static int solve(long n) {
		long sum = 0;
		int addNum = 0;
		while (n >= sum) {
			sum += (++addNum);
		}

		return sum == n ? addNum : addNum - 1;
	}

}
