package permu_combi2;

import java.io.*;
import java.util.*;

public class Main_15652 {
	static int n, m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		selected = new int[m];
		combi(0, selected, 0);
		System.out.print(sb);
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
			selected[toselect] = i + 1;
			combi(toselect+1, selected, i); //자기 자신부터 시작하면 됨
		}

	}
}
