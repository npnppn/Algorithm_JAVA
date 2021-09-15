package data_structure;

import java.io.*;
import java.util.*;

//트리맵 잘 모르겠어서 구글링으로 찾아봄.. 어렵넹
//이중 우선순위 큐 연산은 2번 : 삽입할 때 한번, 데이터 삭제 한번(우선순위 높은것 , 우선순위 낮은것)
//D 1 : Q에서 최댓값을 삭제 연산
//D -1 : Q에서 최솟값을 삭제 연산
public class Main_7662 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int k = sc.nextInt();
			TreeMap<Integer, Integer> ts = new TreeMap<>();
			
			for (int i = 0; i < k; i++) {
				char c = sc.next().charAt(0);
				int n = sc.nextInt();

				if (c == 'I') {
					ts.put(n, ts.getOrDefault(n, 0) + 1);
				} else if (!ts.isEmpty()) {
					int key;
					if (n == 1) {
						//최댓값 제거
						key = ts.lastKey();
						if (ts.get(key) > 1)
							ts.put(key, ts.get(key) - 1);
						else
							ts.pollLastEntry();
					}
					//최솟값 제거
					else {
						key = ts.firstKey();
						if (ts.get(key) > 1)
							ts.put(key, ts.get(key) - 1);
						else
							ts.pollFirstEntry();
					}
				}
			}
			if (ts.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(ts.lastKey() + " " + ts.firstKey());

		}
	}
}