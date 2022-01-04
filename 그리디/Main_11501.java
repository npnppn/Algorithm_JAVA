package greedy;

import java.io.*;
import java.util.*;

public class Main_11501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		long ans[] = new long[tc];

		for (int n = 0; n < tc; n++) {
			int days = sc.nextInt();
			long stocks[] = new long[days];
			long max = Integer.MIN_VALUE;
			for (int i = 0; i < days; i++) {
				stocks[i] = sc.nextInt();
			}

			// 가장 비쌀 때보다 현재 가격이 크면 그게 최대
			for (int i = days - 1; i >= 0; i--) {
				if (stocks[i] > max) {
					max = stocks[i];
				} else {
					ans[n] += (max - stocks[i]); // 팔 때 이득
				}
			}
		}
		for (long i : ans) {
			System.out.println(i);
		}

	}

}
