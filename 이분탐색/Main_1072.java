package binary_search;

import java.io.*;
import java.util.*;

public class Main_1072 {
//int�� �ϴϱ� �� Ŭ�� �̻��� ���� ���´�.. �� Long���� �ٲٸ�?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long X = Long.parseLong(st.nextToken());
		Long Y = Long.parseLong(st.nextToken());

		Long Z = (Y * 100) / X; // �¸� Ȯ��
		// System.out.println(Z);

		if (Z >= 99) { // 99���ζ� 100���δ� ���Ұ� ����
			System.out.println(-1);
		} else {
			Long start = (long) 1;
			Long end = X;
			Long mid = (long) 0;
			while (start <= end) {
				mid = (start + end) / 2;
				Long percent = (Y + mid) * 100 / (X + mid);
				if (percent > Z) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}

			}
			System.out.println(start);

		}
	}
}
