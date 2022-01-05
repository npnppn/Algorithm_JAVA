package sort;

import java.io.*;
import java.util.*;

//30의 배수가 되려면?
// 1. 0이 있어야하고, 2. 더했을 때 합이 3의배수!
public class Main_10610 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int sum = 0;
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			int num = ch[i] - '0';
			sum += num;
			sb.append(num);
		}

		// 30의 배수 판단
		if (ch[0] != '0' || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb.reverse());
		}
	}
}
