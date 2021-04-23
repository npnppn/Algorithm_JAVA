package baekjoon;
import java.io.*;
import java.util.*;

public class Main_1713 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Student> list = new ArrayList<Student>();
		for(int i=0; i<n; i++) {
			list.add(new Student(0, 0));
		}
		
		int m = sc.nextInt();
		while(m-->0) {
			int rec = sc.nextInt();
			boolean st = false;
			for(int i=0; i<list.size(); i++)
				if(list.get(i).no == rec) {
					list.get(i).recommend++;
					st = true;
				}
			if(st) continue;
			list.add(new Student(rec, 1));
			int min = 1001;
			for(int i=0; i<list.size() - 1; i++)
				if(list.get(i).recommend < min)
					min = list.get(i).recommend;
			for(int i=0; i<list.size() - 1; i++)
				if(list.get(i).recommend == min) {
					list.remove(i);
					break;
				}
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++)
			if(list.get(i).no == 0) continue;
			else System.out.print(list.get(i).no + " ");

	}

	
	//정렬하기 위해서 컴패레터 사용
	static class Student implements Comparable<Student> {
		int no;
		int recommend;
		
		Student(int no, int recommend) {
			this.no = no;
			this.recommend = recommend;
		}
		
		@Override
		public int compareTo(Student s) {
			if(this.no > s.no)
				return 1; //오름차순
			return -1;
		}
	}

}