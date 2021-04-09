package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_13305 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] road = new long[N - 1]; // 도로 정보
		long[] price = new long[N]; // 리터당 가격

		for (int i = 0; i < N - 1; i++) {
			road[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			price[i] = sc.nextInt();
		}
		
		//가격을 내림차순일 경우에만 주유 슥삭 하면됨 

		long sum = 0;
		long min = price[0];// 이전 까지의 과정 중 주유 최소 비용 
		for (int i = 0; i < N - 1; i++) {
			if (price[i] < min) {
				min = price[i];
			}
			sum += min * road[i];

		}
		System.out.println(sum);

	}

}
