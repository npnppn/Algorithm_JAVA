package brute_force;

import java.io.*;
import java.util.*;

//규칙을 찾으면 잘 풀린다!
public class Main_1011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			int dis = y - x;
			int max = (int) Math.sqrt(dis);

			// max*max < 거리  <=max*max +max가 첫번째 묶인 구간
			if (max == Math.sqrt(dis)) {
				System.out.println(max * 2 - 1);
			} else if ((max * max) + max >= dis) {
				System.out.println(max * 2);
			}
			
			else {
				System.out.println(max * 2 + 1);
			}

		}

	}

}
