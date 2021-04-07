package dp;

import java.io.*;
import java.util.*;

public class Main_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;

		while (true) {

			// 5로 나눠떨어지면 바로 출력
			if (N % 5 == 0) {
				cnt += N / 5;
				System.out.println(cnt);
				break;
			}

			// 5로 안나눠떨어지면 3씩빼서 첫번째 if문으로 가는거 반복
			else {
				N -= 3;
				cnt++;

			}

			// 음수 되버리면 -1출력
			if (N < 0) {
				System.out.println("-1");
				break;
			}

		}

	}

}
