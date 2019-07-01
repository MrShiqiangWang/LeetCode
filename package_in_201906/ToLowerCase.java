package package_in_201906;

public class ToLowerCase {
	public String toLowerCase(String str) {
		StringBuilder stringBuffer = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(c>=65&&c<=90) {
				stringBuffer.append((char)(c+32));
			}else {
				stringBuffer.append(c);
			}
		}
		return stringBuffer.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println((int)'z');
		System.out.println((int)'Z');
		System.out.println((int)'a');
		System.out.println((int)'A');
	}
}
