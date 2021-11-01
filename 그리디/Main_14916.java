package greedy;

import java.io.*;
import java.util.*;

public class Main_14916 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 일단 5로 나누고 2씩빼면서 계산해봐. 암것도 계산 안되면 -1
		int cnt = 0;

		while (n > 0) {
			if (n % 5 == 0) {
				cnt = n / 5 + cnt;
				break;

			} else {
				n -= 2;
				cnt++;
			}
		}

		if (cnt < 0) {
			System.out.println("-1");
		} else {
			System.out.println(cnt);
		}

	}

}
