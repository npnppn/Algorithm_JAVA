import java.io.*;
import java.util.*;

public class Main_1764 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 돋도 못한 사람
		int m = sc.nextInt(); // 보도 못한 사람

		HashSet<String> name = new HashSet<String>();
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			name.add(sc.next());
		}
		for (int i = 0; i < m; i++) {
			String s = sc.next();
			if(name.contains(s)) {
				result.add(s);
			}
		}

		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result.size() + "\n");
		//System.out.println(sb);
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + "\n");
		}
		System.out.println(sb);

	}

}
