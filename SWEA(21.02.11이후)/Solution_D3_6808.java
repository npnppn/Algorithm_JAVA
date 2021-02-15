package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D3_6808 {
	static boolean[] numeric = new boolean[19];
	static boolean[] check;
	static int[] bd1 = new int[9]; //규영이 카드
	static int[] bd2 = new int[9]; //인영이 카드
	static int cnt, ans, musoongcnt; //전체가지수, 이긴 가지수, 무승부 가지수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
		
		for (int t = 1; t <= T; t++) {
			ans = cnt = musoongcnt = 0;
			check = new boolean[9];
			numeric = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				bd1[i] = Integer.parseInt(st.nextToken());
				numeric[bd1[i]] = true; // 규영이가 선택한 카드는 true로 체크
			}
			
			int tmp = 0;
			for (int i = 1; i <= 18; i++) {
				if (!numeric[i]) // 카드가 체크가 안되어있는 경우, bd2에 카드 숫자 넣는다.
					bd2[tmp++] = i;
			}
			permu(0, 0, 0);
			sb.append("#" + t + " " + ans + " " + (cnt - ans - musoongcnt) + "\n"); // ans는 이긴가지수,
			// cnt-ans-musoongcnt 는 전체가지수에서 이긴가지수와 비긴가지수 뺀 가지수.
		}
		System.out.println(sb.toString());
	}
	
	public static void permu(int toselect, int sum1, int sum2) {
		if (toselect == 9) { // 9라운드가 지나고, 값 비교를 통해
			cnt++; // 모든 가지수
			if (sum1 > sum2)
				ans++; // 이긴 가지수
			if (sum1 == sum2)
				musoongcnt++; // 비긴 가지수 증가
			return;
		}
		
		for (int i = 0; i < 9; i++) { // 한 라운드당 9개의 숫자 중, 이전 라운드에서 선택이 안된 숫자를 선택.
			if (!check[i]) {
				check[i] = true;
				if (bd1[toselect] > bd2[i]) {
					permu(toselect + 1, sum1 + bd1[toselect] + bd2[i], sum2); // bd1의 숫자가 클 경우, sum1에 값을 더해준다.
				} else {
					permu(toselect + 1, sum1, sum2 + bd1[toselect] + bd2[i]); // bd2의 숫자가 클 경우, sum2에 값을 더해준다.
				}
				check[i] = false;
			}
		}
	}
}