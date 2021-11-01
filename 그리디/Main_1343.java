package greedy;

import java.io.*;
import java.util.*;

public class Main_1343 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		s = s.replace("XXXX", "AAAA");
		s =s.replace("XX", "BB");
		
		if (s.contains("X")) {
			System.out.println(-1);
		} else {
			System.out.println(s);
		}

	}

}
