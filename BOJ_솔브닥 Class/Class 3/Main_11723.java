package class3;

import java.io.*;
import java.util.*;

public class Main_11723 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int num = 0;
			switch (str.nextToken()) {
			
			case "add":
				num = Integer.parseInt(str.nextToken());
				set.add(num);
				break;
			
			case "remove":
				num = Integer.parseInt(str.nextToken());
				set.remove(num);
				break;
			
			case "check":
				num = Integer.parseInt(str.nextToken());
				if(set.contains(num)) {
					sb.append(1);
					sb.append("\n");
				} else {
					sb.append(0);
					sb.append("\n");
				}
				break;
			
				
			case "toggle":
				num = Integer.parseInt(str.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				}
				break;
			
			case "all":
				for (int k =1; k<=20; k++) {
					set.add(k);
				}
				break;
				
			case "empty":
				set.clear();
				break;
			}
			
			
		}
		System.out.println(sb);

	}

}
