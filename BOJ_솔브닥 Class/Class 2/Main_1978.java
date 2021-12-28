package class2;

import java.io.*;
import java.util.*;

//1000까지니까 에라토스테네스 안써도 ok
public class Main_1978 {
	static int cnt;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cnt = 0;

		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (k == 1) {
				continue;
			}

			flag = true;
			for (int j = 2; j <= Math.sqrt(k); j++) {
				if (k % j == 0) {
					flag = false;
				}
			}
			if (flag) {
				cnt++;
			}

		}
		System.out.println(cnt);
	}
}
