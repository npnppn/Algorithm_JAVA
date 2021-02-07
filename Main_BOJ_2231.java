package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2231 {

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int m = 0;
		for (int i = 0; i < n; i++) {
			int m1 = i;
			int n1 = i; //분해합을 저장할 변수

			while (m1 > 0) {
				n1 += m1 % 10; //자릿수를 더하고
				m1 /= 10; //다음 자릿수로 이동
			}

			if (n1 == n) {
				m = i;
				break;
			}
		}

		System.out.println(m);
	}

}
