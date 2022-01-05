package sort;

import java.io.*;
import java.util.*;

//LinkedHashmap은 입력된 순서대로 Key가 보장된다. 기억하자!
public class Main_2910 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		HashMap<Integer, Integer> hm = new LinkedHashMap<>();

		// 숫자랑 갯수를 해시맵에 저장해두고
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (hm.containsKey(num)) {
				hm.put(num, hm.get(num) + 1);
			} else {
				hm.put(num, 1);
			}
		}
		// System.out.println(hm);

		// 갯수들 정렬하고
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i : hm.keySet()) {
			ar.add(i);
		}

		Collections.sort(ar, new Comparator<Integer>() {

			public int compare(Integer a, Integer b) {
				return Integer.compare(hm.get(b), hm.get(a));
			}
		});

		// 갯수 정렬한대로 출력
		Iterator<Integer> it = ar.iterator();
		while (it.hasNext()) {
			Integer k = it.next();
			for (int i = 0; i < hm.get(k); i++) {
				System.out.print(k + " ");
			}

		}
	}
}
