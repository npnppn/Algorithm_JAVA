import java.io.*;
import java.util.*;

//‘1’은 스위치가 켜져 있음을, ‘0’은 꺼져 있음
//남자 : 자신의 배수면 스위치 상태 바꾸기
//여자: 좌우대칭이면서 많은 스위치 구간 찾아서 상태 바꾸기
public class Main_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() + 1; // 스위치 갯수
		int[] arr = new int[n];
		for (int i = 1; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt(); // 학생수
		for (int i = 1; i <= k; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();

			// 남자이면
			if (gender == 1) {
				for (int j = number; j < n; j += number) {
					if (arr[j] == 0)
						arr[j] = 1;
					else
						arr[j] = 0;
				}
			}

			// 여자이면
			else {
				int left = number - 1;
				int right = number + 1;

				while (true) {
					if (left < 1 || right >= n)
						break;
					if (arr[left] != arr[right])
						break;
					left--;
					right++;

				}

				left++;
				right--;

				for (; left <= right; left++) {
					if (arr[left] == 1)
						arr[left] = 0;
					else
						arr[left] = 1;
				}

			}

		}

		for (int j = 1; j < n; j++) {
			System.out.print(arr[j] + " ");
			if (j % 20 == 0)
				System.out.println();
		}
	}
}