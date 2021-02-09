package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_BOJ_2563 {

	public static void main(String[] args) throws Exception, IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int cnt = 0;
		int[][] map = new int[100][100];
		int N = Integer.parseInt(br.readLine()); // 색종이 수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 왼쪽
			int b = Integer.parseInt(st.nextToken()); // 아래쪽

			// a,b ~ a+10,b+10까지 다 map[a][b] = 1로 만들어주기만하면
			for (int k = b; k < b + 10; k++) {
				for (int j = a; j < a + 10; j++) {
					map[k][j] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) { // 1부터 100까지 map[a][b] 가 1인거만 체크
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}