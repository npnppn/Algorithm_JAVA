package greedy;

import java.io.*;
import java.util.*;

public class Main_20365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		int rCnt = 0;
		int bCnt = 0;
		for (int i = 0; i < s.length(); i++) {

			if (i == 0) {
				if (s.charAt(i) == 'B') {
					bCnt++;
				} else {
					rCnt++;
				}
			}

			else {
				if (s.charAt(i - 1) == s.charAt(i))
					continue;
				else {
					if (s.charAt(i) == 'B') {
						bCnt++;
					} else {
						rCnt++;
					}
				}
			}
		}

		int res = 0;
		if (rCnt >= bCnt) {
			res = bCnt + 1;
		} else {
			res = rCnt + 1;
		}

		System.out.println(res);

	}

}
