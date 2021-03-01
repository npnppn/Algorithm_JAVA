package ssafy_algo;
//보충문제인데 좀 어려웠음. 나중에 한번더 풀어보기!
import java.io.*;
import java.util.*;

public class Main_Jungol_1205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int joker = 0; // 0의 갯수
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 0)
				joker++;
		}
		Arrays.sort(arr);

		// 0아닌거부터 세다가 연속된거 아니면 0하나 쓰고 숫자 늘리고, 0없으면 끝내기
		if (joker == N) {
			System.out.println(joker);
		} else {
			int max = 0;
			for (int i = joker; i < N; i++) {
				int jok = joker;
				int len = 1;
				int val = arr[i];
				for (int j = i + 1; j < N; j++) {
					if (arr[j] - val == 0)
						continue;
					else if (arr[j] - val <= jok + 1) {
						int diff = arr[j] - val - 1;
						jok = jok - diff;
						len = len + diff + 1;
						val = arr[j];
					} else {
						break;
					}
				}
				max = Math.max(max, len+jok);
			}
			System.out.println(max);
		}
	}
}
