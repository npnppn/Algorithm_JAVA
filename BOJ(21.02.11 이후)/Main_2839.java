package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_2839 {

	public static void main(String[] args) throws Exception, IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int N = Integer.parseInt(br.readLine());

		// 5로 나누어 떨어질 때
		if (N % 5 == 0) {
			System.out.println(N / 5);
			return; //결과값 그대로 리턴
		}

		// 5a+3b로 나누어 떨어질때, 18을 예로 들면 5kg짜리 3개 + 3kg짜리 1개 해서 총 4개 가능
		else {
			int mok = N / 5;
			for (int i = mok; i > 0; i--) {
				int tmp = N - (i * 5);
				if (tmp % 3 == 0) {
					System.out.println(i + (tmp / 3));

					return;
				}
			}
		}

		// 3으로 나누어 떨어질때
		if (N % 3 == 0) {
			System.out.println(N / 3);
			return;
		}

		// 기타
		else {
			System.out.println(-1);
		return;
		}

	}

}
