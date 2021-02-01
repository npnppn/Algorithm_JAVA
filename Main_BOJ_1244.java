package ssafy_algo;

import java.util.Scanner;

public class Main_BOJ_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 스위치 개수
		int[] light = new int[num + 1]; // 스위치 배열
		for (int i = 1; i <= num; i++) {
			light[i] = sc.nextInt(); // 스위치 입력받음
		}
		int st = sc.nextInt(); // 학생 수

		while (st-- > 0) {
			int gender = sc.nextInt(); // 성별, 1이면남자 / 2이면여자
			int idx = sc.nextInt();

			// 남자
			if (gender == 1) {
				// 받은 수의 배수이면 바꿈
				for (int i = idx; i <= num; i += idx) {
					if (light[i] == 0) {
						light[i] = 1;
					} else
						light[i] = 0;
				}
			}
			// 여자
			else {
				// 여자는 받은 수를 기준으로 인접한 양쪽이 다르다면 대칭을 이룰 수 없음.
				if ((idx == 1 || idx == num) || light[idx - 1] != light[idx + 1]) {
					if (light[idx] == 0) {
						light[idx] = 1;
					} else
						light[idx] = 0;
				}

				else {
					int left = idx - 1;
					int right = idx + 1;
					if (light[idx] == 0) {
						light[idx] = 1;
					} else
						light[idx] = 0;
					// 양쪽 끝의 번호에 해당하는 수를 받을때도 대칭을 이룰 수 없음.
					while (left > 0 && right <= num) {
						if (light[left] == light[right]) {
							if (light[left] == 0) {
								light[left] = 1;
							} else
								light[left] = 0;

							if (light[right] == 0) {
								light[right] = 1;
							} else
								light[right] = 0;
							--left;
							++right;
						} else {
							break;
						}
					}
				}
			}
		}
		for (int i = 1; i <= num; i++) {
			System.out.print(light[i] + " ");
			if (i % 20 == 0) { // 20줄 이상이면 다음줄로
				System.out.println();
			}
		}
	}

}
