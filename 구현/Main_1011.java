package brute_force;

import java.io.*;
import java.util.*;

//��Ģ�� ã���� �� Ǯ����!
public class Main_1011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			int dis = y - x;
			int max = (int) Math.sqrt(dis);

			// max*max < �Ÿ�  <=max*max +max�� ù��° ���� ����
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
