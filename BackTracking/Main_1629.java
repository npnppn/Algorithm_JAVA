package backtracking;

import java.io.*;
import java.util.*;

public class Main_1629 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		long res = 0;
		res = pow(a, b, c);
		System.out.println(res);
	}

	static long pow(long x, long y, long z) {
		// 기저조건
		if (y == 1)
			return x % z;

		long value = pow(x, y / 2, z);
		value = value * value % z;
		if (y % 2 == 0)
			return value;
		return value * x % z;
	}

}
