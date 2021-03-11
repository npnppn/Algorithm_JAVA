package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_1592 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] arr = new int[N + 1];

		int cnt = 0; // 공을 던진 횟수
		arr[1] = 1; // 처음공은 1번사람이 받으니까 1 증가
		int idx = 1;
		while (true) {
			// 홀수이면 시계방향이니까 L만큼 더해줘얌
			if (arr[idx] % 2 == 1) {
				idx = idx + L;
			}
			// 짝수이면 반시계방향이니까 L만큼 빼줘야함
			else {
				idx = idx - L;
			}

			// 시계) 다음 받는 사람이 배열 벗어나면 인원만큼 나눈 나머지가 다음에 받는 사람..
			// 예를 들면 idx=7이고 N=5이면 다음엔 2번째 사람이 받음
			if (idx > N)
				idx %= N;

			// 반시계) 다음 받는 사람이 배열 벗어나면?
			else if (idx < 1)
				idx += N;

			arr[idx]++;
			cnt++;

			// 한 사람이 공을 M번 받으면 종료
			if (arr[idx] == M)
				break;
		}
		System.out.println(cnt);

	}
}
