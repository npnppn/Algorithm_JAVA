package ssafy_algo;

import java.io.*;

public class Main_2748 {
	static int N;
	static long[] dx;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dx = new long[N + 1];
		dx[0] = 0;
		dx[1] = 1;

		for (int i = 2; i <= N; i++) { // 2번 숫자부터 반복 시작
			dx[i] = dx[i - 1] + dx[i - 2];
		}

		System.out.println(dx[N]);
	}
}