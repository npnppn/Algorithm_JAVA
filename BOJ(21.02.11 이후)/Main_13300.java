package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[7][2];
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			// 여학생이면 0번 인덱스에 1증가
			if (gender == 0) {
				arr[sc.nextInt()][0]++;
			}
			// 남학생이면 0번 인덱스에 1증가
			else if (gender == 1) {
				arr[sc.nextInt()][1]++;
			}
		}

		int cnt = 0;

		// 여학생 탐색
		for (int i = 1; i < 7; i++) {
			// 학생 수가 없으면 패스
			if (arr[i][0] == 0)
				continue;
			// K보다 작거나 같으면 cnt++
			else if (arr[i][0] <= K)
				cnt++;
			// K로 나눴는데 나머지가0이면 몫만큼 cnt증가
			else if (arr[i][0] % K == 0)
				cnt += arr[i][0] / K;
			// 나머지가 0아니면 몫만큼 증가하고 cnt++
			else if (arr[i][0] % K != 0) {
				cnt += arr[i][0] / K;
				cnt++;
			}
		}

		// 남학생 탐색
		for (int i = 1; i < 7; i++) {
			// 학생 수가 없으면 패스
			if (arr[i][1] == 0)
				continue;
			// K보다 작거나 같으면 cnt++
			else if (arr[i][1] <= K)
				cnt++;
			// K로 나눴는데 나머지가0이면 몫만큼 cnt증가
			else if (arr[i][1] % K == 0)
				cnt += arr[i][1] / K;
			// 나머지가 0아니면 몫만큼 증가하고 cnt++
			else if (arr[i][1] % K != 0) {
				cnt += arr[i][1] / K;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}