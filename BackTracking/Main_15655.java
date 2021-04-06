package permu_combi2;

import java.io.*;
import java.util.*;

public class Main_15655 {
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
		Arrays.sort(arr);
		selected = new int[m];
		combi(0, selected, 0);
		System.out.println(sb);

	}

	static void combi(int toselect, int[] selected, int startidx) {
		if (toselect == m) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = startidx; i < n; i++) {
			selected[toselect] = arr[i];
			combi(toselect + 1, selected, i + 1);
		}

	}

}
