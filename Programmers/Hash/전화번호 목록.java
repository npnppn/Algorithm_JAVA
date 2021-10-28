import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> hm = new HashMap<>();
		
		for( String input : phone_book ) {
			hm.put(input, input);
		}
		
		for ( String target : phone_book) { 
			for( int i=0; i< target.length(); i++) {
				if( hm.containsKey(target.substring(0,i)) ) {
					return false;
				}

			}
			
		}
        return answer;
    }
}
