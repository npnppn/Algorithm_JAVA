package ssafy_algo;

import java.util.*;
import java.io.*;

/* 0 : 현재 속도 유지.
1 : 가속
2 : 감속
*/

public class Solution_D2_1940 {

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 커맨드 수
			int sum = 0;
			int v = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());

				if (command != 0) {
					int accel = Integer.parseInt(st.nextToken()); // 가속도

					if (command == 1) { // 가속
						v += accel;
					} else { 
						if (v < accel) {//속도0
							v = 0;
						} else { //감속
							v -= accel;
						}
					}

				}
				sum += v;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
