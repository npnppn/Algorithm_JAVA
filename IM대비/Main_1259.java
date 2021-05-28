import java.util.*;
import java.io.*;

public class Main_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			char[] arr = sc.next().toCharArray();
			if (arr.length == 1) {
				//0이 입력되면 종료해.
				if (arr[0] - '0' == 0)
					break;
				else {
					System.out.println("yes");
				}
			}

			int mid = arr.length / 2;

			for (int i = 0; i < mid; i++) {
				int start = arr[i] - '0'; //앞에거에서 하나씩 증가할 것임
				int reverse = arr[(arr.length - 1) - i] - '0'; //뒤에거에서 하나씩 감소할거임
				if (start != reverse) { //다르면 팰린드롬 아님
					System.out.println("no");
					break;
				}
				if (i == mid - 1) { //같으면 팰린드롬임
					System.out.println("yes");
				}
			}
		}
	}
}