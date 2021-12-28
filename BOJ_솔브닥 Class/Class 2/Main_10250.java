package class2;

import java.io.*;
import java.util.*;

//n을 h로 나눈 나머지 값이 층 수 / N 을 H 로 나눈 몫 +1이 호 수
public class Main_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();

			if (n % h == 0) {
				System.out.println((h * 100) + (n / h)); // 층 + 호수
			} else {
				System.out.println(((n % h) * 100) + ((n / h) + 1));
			}
		}

	}

}
