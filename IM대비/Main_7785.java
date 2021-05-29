import java.util.*;
import java.io.*;

public class Main_7785 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		HashSet<String> result = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			String input = sc.next();

			if (input.equals("enter")) {
				result.add(name); // enter있으면 명단에 넣어
			} else {
				result.remove(name); // leave면 명단에서 없애야지
			}

		}
		List<String> list = new ArrayList<>();
		Iterator<String> it = result.iterator();
		while (it.hasNext())
			list.add(it.next());

		Collections.sort(list, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		// 역순으로 출력
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
			// System.out.println(result.get(i));
		}
		System.out.println(sb);

	}

}
