package binary_search;

import java.io.*;
import java.util.*;

public class Main_1072 {
//int로 하니까 값 클때 이상한 값이 나온다.. 다 Long으로 바꾸면?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long X = Long.parseLong(st.nextToken());
		Long Y = Long.parseLong(st.nextToken());

		Long Z = (Y * 100) / X; // 승리 확률
		// System.out.println(Z);

		if (Z >= 99) { // 99프로랑 100프로는 변할게 없음
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
