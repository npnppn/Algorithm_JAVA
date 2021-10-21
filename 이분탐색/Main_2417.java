package binary_search;

import java.io.*;
import java.util.*;

public class Main_2417 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long left = 0;
		long right = n;
		long min = Long.MAX_VALUE;

		while (left <= right) {
			long mid = (left + right) / 2;
			long value = (long) Math.pow(mid, 2);

			if (value >= 0) {
				if (value >= n) {
					min = Math.min(mid, min);
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

		}
		System.out.println(min);

	}

}
