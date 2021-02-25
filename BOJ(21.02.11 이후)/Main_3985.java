package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 롤 케이크 길이
		int N = sc.nextInt(); // 방청객 수

		int result = 0; // 방청객 번호
		int[][] arr = new int[N][2]; //p번조각부터 k번 조각 담을 배열
		int[] expect = new int[L + 1]; //롤케이크 배열
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		// 가장 많은 조각 받는다 예상되는 사람 번호
		for (int i = 0; i < N; i++) {
			if (max < arr[i][1] - arr[i][0]) {
				max = arr[i][1] - arr[i][0];
				result = i + 1;
			}
		}
		System.out.println(result);

		// 실제로 가장 많은 조각 받은 사람 번호
		for (int i = 1; i <= N; i++) {
			for (int j = arr[i - 1][0]; j <= arr[i - 1][1]; j++) {
				if (expect[j] == 0) {
					expect[j] = i;
				}
			}
		}

		//가장 많은 조각을 받은 케이크 몇조각인지 계산
		max = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < expect.length; j++) {
				if (expect[j] == i) {
					cnt++; //1은 3개, 2는 2개, 3은 2개.. 이런식으로?
				}
			}
			if (cnt > max) {
				max = cnt;
				result = i; //cnt 가장 많은 사람 번호 출력
			}
		}
		System.out.println(result);

	}
}