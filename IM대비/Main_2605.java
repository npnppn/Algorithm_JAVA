package im;

import java.io.*;
import java.util.*;

public class Main_2605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> al = new ArrayList<Integer>();

		int n = sc.nextInt();
		al.add(-1);

		for (int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			al.add(i - num, i);

		}

		for (int i = 1; i <= al.size()-1; i++) {
			System.out.print(al.get(i) + " ");
		}
	}

}
