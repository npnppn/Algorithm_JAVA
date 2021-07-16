package algo;

import java.io.*;
import java.util.*;

//1부터 더해가면서 주어진 S를 넘지 않는 선까지 모두 더했을 때 마지막 더한 값!
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
