package baekjoon;

import java.io.*;
import java.util.*;

public class Main_3943 {
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			max = num;
			while (num != 1) {
				num = (num % 2 == 0) ? num / 2 : (num * 3) + 1;
				max = Math.max(max, num);
			}
			System.out.println(max);
		}

	}
}
