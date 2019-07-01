package package_in_201906;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		String[] result=s.trim().split(" ");
		if(result.length==0) {
			return 0;
		}
		return result[result.length-1].length();
	}
}
