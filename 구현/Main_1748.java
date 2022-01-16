package implement;

import java.io.*;
import java.util.*;

public class Main_1748 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int plus = 1;
		int num = 10;

		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 자릿수 바뀌는 조건 => 10, 100, 1000, 10000, ...
			if (i % num == 0) {
				plus++;
				num *= 10;
			}
			cnt += plus;

		}
		System.out.println(cnt);
	}

}
