package ssafy_algo;
import java.io.*;
import java.util.*;

public class Main_17413 {
	
	//스택 출력함수
	static void print(Stack st) {
		while(!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();
		
		String s = sc.nextLine();
		boolean check = false;
		
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '<') { //태그 안을 의미
				print(st); //태그 전까지 문자 뒤집기
				check = true;
				System.out.print(s.charAt(i));
			}
			else if(s.charAt(i) == '>') {
				check = false; //태그 탈출
				System.out.print('>');
			}
			else if(check) { //태그 밖
				System.out.print(s.charAt(i));
			}
			
			else {
				if(s.charAt(i) == ' ') {
					print(st);
					System.out.print(' ');
				}
				
				else {
					st.push(s.charAt(i));
				}
				
			}
		}
		print(st);
		
	}
}