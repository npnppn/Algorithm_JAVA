package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_BOJ_10448 {

	static int[] samkaksoo;
	static int[] sum;

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;

		samkaksoo = new int[50];
		sum = new int[5000];
		for (int i = 1; i < 50; i++) {
			samkaksoo[i] = i * (i + 1) / 2;
		}

		for (int i = 1; i < 50; i++) {
			for (int j = 1; j < 50; j++) {
				for (int k = 1; k < 50; k++) {
					sum[samkaksoo[i] + samkaksoo[j] + samkaksoo[k]] = 1;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			if (sum[N] == 1) {
				System.out.println(1);
			} else
				System.out.println(0);
		}

	}

}
