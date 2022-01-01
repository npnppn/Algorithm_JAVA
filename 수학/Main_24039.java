package etc;

import java.io.*;
import java.util.*;

public class Main_24039 {
	public static boolean[] primeNum;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int startNum = Integer.parseInt(br.readLine());
		ArrayList<Integer> ar = new ArrayList<>();

		primeNum = new boolean[10001];
		getPrimeNum(); // 에라토스테네스의 체

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			if (!primeNum[i]) {
				ar.add(i);
			}
		}

		int res = 0;

		for (int i = 0; i < ar.size() - 1; i++) {
			res = ar.get(i) * ar.get(i + 1);
			if (res > startNum) {
				System.out.println(res);
				break;
			}
		}

	}

	public static void getPrimeNum() {
		primeNum[1] = true;

		for (int i = 2; i < primeNum.length; i++) {
			for (int j = 2; i * j < primeNum.length; j++) {
				primeNum[i * j] = true;
			}
		}
	}
}