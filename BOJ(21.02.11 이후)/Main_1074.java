package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_1074 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		n = (int) Math.pow(2, n);
		int x = 0;
		int y = 0;
		int ans = 0;

		while (n > 1) {
			n /= 2;
			// 1 왼쪽 위
			if (r < x + n && c < y + n) {
				// 아무것도 추가x
			}
			// 2 오른쪽 위
			else if (r < x + n && c >= y + n) {
				ans += n * n * 1; // 횟수 추가
				y += n; // 오른쪽 위로 위치 이동
			}
			// 3 왼쪽 아래
			else if (r >= x + n && c < y + n) {
				ans += n * n * 2;
				x += n;
			}
			// 4 오른쪽 아래
			else {
				ans += n * n * 3;
				x += n;
				y += n;
			}
		}
		System.out.println(ans);
	}

}
