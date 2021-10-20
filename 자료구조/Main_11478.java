package data_structure;

import java.io.*;
import java.util.*;

public class Main_11478 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Set<String> word = new HashSet<>();
		String name = "";
		for (int i = 0; i < str.length(); i++) {
			name = "";
			for (int j = i; j < str.length(); j++) {
				name += str.substring(j, j + 1);
				word.add(name);
			}
		}
		System.out.println(word.size());

	}

}
