package string;

import java.io.*;
import java.util.*;

public class Main_14405 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		boolean f = false;

		for (int i = 0; i < str.length(); i++) {
			boolean innerF = false;
			if (i + 1 < str.length()
					&& (str.substring(i, i + 2).equals("pi") || str.substring(i, i + 2).equals("ka"))) {
				i++;
				if (!f)
					f = true;
				innerF = true;
			} else if (i + 2 < str.length() && str.substring(i, i + 3).equals("chu")) {
				i += 2;
				if (!f)
					f = true;
				innerF = true;
			}
			if (!f || !innerF) {
				System.out.println("NO");
				System.exit(0);
			}

		}
		System.out.println("YES");
	}
}
