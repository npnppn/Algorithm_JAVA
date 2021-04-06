package permu_combi2;

import java.io.*;
import java.util.*;

public class Main_15666 {
	static int n, m;
	static int[] selected;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		selected = new int[m];
		Arrays.sort(arr);

		combi(0, selected, 0);
		System.out.println(sb);

	}

	static void combi(int toselect, int[] selected, int startidx) {
		if (toselect == m) {
			for (int i : selected) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		} else {
			int num = 0; // 중복체크해주려고 이미 나온건지 확인하는 변수

			for (int i = startidx; i < n; i++) {
				if (num == arr[i]) {
					continue;
				}
				selected[toselect] = arr[i];
				combi(toselect + 1, selected, i); //자기 자신부터 시작하면 되겠지!
				num = arr[i];
			}

		}
	}

}
