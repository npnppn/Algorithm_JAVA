package ssafy_algo;

import java.io.*;
import java.util.*;

public class Solution_D3_3499 {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int x = 0;
			int y = 0;
			// 홀수일 때
			if (n % 2 == 1) {
				x = n / 2 + 1;
				y = n / 2;
			}
			// 짝수일때
			else {
				x = n / 2;
				y = n / 2;
			}
			// 절반으로 나누어 다시 두 배열에 나누고
			// 두 배열을 교차해가면서 출력!
			String[] arr1 = new String[x];
			String[] arr2 = new String[y];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < x; i++) {
				arr1[i] = tk.nextToken();
			}
			for (int i = 0; i < y; i++) {
				arr2[i] = tk.nextToken();
			}

			String[] ResultArray = new String[n];

			for (int i = 0; i < n; i++) {
				//짝수이면
				if (i % 2 == 0) {
					ResultArray[i] = arr1[i / 2];
				}
				//홀수이면
				else {
					ResultArray[i] = arr2[i / 2];
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(ResultArray[i] + " ");
			}
			System.out.println();
		}

	}
}
