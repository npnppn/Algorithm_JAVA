package binarysearch;

import java.io.*;
import java.util.*;

public class Main_1822 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		TreeSet<Integer> tr = new TreeSet<>();
		for (int i = 0; i < a; i++) {
			tr.add(sc.nextInt());
		}
		for (int j = 0; j < b; j++) {
			int num = sc.nextInt();
			if (tr.contains(num)) {
				tr.remove(num);
			}
		}
		System.out.println(tr.size());
		for (int i : tr) {
			System.out.print(i + " ");
		}
	}

}
