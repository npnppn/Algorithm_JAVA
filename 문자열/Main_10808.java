package array;

import java.io.*;
import java.util.*;
//�ƽ�Ű�ڵ带 ���ڷ� �ٲٴ°� �ٽ�
public class Main_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'a';
			arr[num]++;
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
