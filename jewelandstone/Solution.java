package jewelandstone;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int numJewelsInStones(String J, String S) {
		Set<Character> character = new HashSet<Character>();
		for (int i = 0; i < J.length(); i++) {
			character.add(J.charAt(i));
		}
		
		int number=0;
		for(int j=0;j<S.length();j++) {
			if(character.contains(S.charAt(j))) {
				number++;
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Solution solution=new Solution();
		solution.numJewelsInStones("ababab", "");
	}
}
