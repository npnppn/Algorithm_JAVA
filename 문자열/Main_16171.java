package string;

import java.util.*;
import java.io.*;

public class Main_16171 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String k = br.readLine();

		s = s.replaceAll("[0-9]", "");
		boolean flag = false;

		for (int i = 0; i <= s.length() - k.length(); i++) {
			if (s.substring(i, i + k.length()).equals(k)) {
				flag = true;
			}
		}

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
