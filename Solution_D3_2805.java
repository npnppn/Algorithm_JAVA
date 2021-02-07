package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D3_2805 {

	public static void main(String[] args) {
		
//위, 아래로 나누어 증가하는 부분과 감소하는 부분을 나누기.
// 그 후에 아래와 같이 별은 중간에서부터 시작하므로 중간을 나누어 그것을 기준으로 열의 위치를 잡음.		
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int sum = 0;
			
			//위쪽
			for (int i = 1; i <= n / 2; i++) {
				String s = sc.next();
				for (int j = i; j < n - i; j++) {
					sum += s.charAt(j) - '0';
				}
			}
			
			//아래쪽
			for (int i = n / 2; i >= 0; i--) {
				String s = sc.next(); //농작물 가치
				for (int j = i; j < n - i; j++) {
					sum += s.charAt(j) - '0';
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
