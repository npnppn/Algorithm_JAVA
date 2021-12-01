package array;

import java.io.*;
import java.util.*;

public class Main_11328 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			int[] aa = new int[26]; //영어 소문자로만 이루어져있으니까 26개만!
			int[] bb = new int[26];
			
			for (int i = 0 ;i<a.length(); i++) {
				aa[a.charAt(i) - 'a']++;
			}
			for (int i = 0 ;i<b.length(); i++) {
				bb[b.charAt(i) - 'a']++;
			}
			
			int cnt = 0;
			for (int i = 0; i < 26; i++) {
				cnt += Math.abs(aa[i] - bb[i]);
			}
			if (cnt == 0 ) {
				sb.append("Possible" + '\n');
			} else {
				sb.append("Impossible" + '\n');
			}

		}
		System.out.println(sb);

	}

}
