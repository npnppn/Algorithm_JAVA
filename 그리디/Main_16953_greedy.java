package dfs_bfs;

import java.io.*;
import java.util.*;

//그리디로 접근할지?? bfs로 해야할지? 고민하다가 둘 다 해보기로!
public class Main_16953_greedy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		int cnt = 0;

		while (a != b) {
			if (a > b) {
				System.out.println("-1");
				System.exit(0);
			}

			// A->B가 아니라 B->A로 만들어나가자
			if (b % 10 == 1) {// 일의자리 1이 되는 경우
				b = b / 10;
			} else if (b % 2 == 0) {// 2로 나눠떨어지는경우
				b = b / 2;
			} else {
				System.out.println("-1");
				System.exit(0);
			}
			cnt++;

		}
		System.out.println(cnt + 1);

	}

}
