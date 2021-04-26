package baekjoon;

import java.io.*;
import java.util.*;

//식이 가장 최소가 되려면 앞에는 작고 뒤에가 크면 되겠지
//덧셈을 먼저 계산하면됨
public class Main_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("-"); // -기준으로 나누고나서
		int sum = Integer.MAX_VALUE;
		for (int i = 0; i < s.length; i++) {
			int tmp = 0;
			
			// 뺄셈으로 나눈 토큰들을 덧셈으로 분리해
			String[] plus = s[i].split("\\+");

			//그 다음 이것들을 다 더해
			for (int j = 0; j < plus.length; j++) {
				tmp += Integer.parseInt(plus[j]);
			}

			if (sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}

		}
		System.out.println(sum);

	}

}
