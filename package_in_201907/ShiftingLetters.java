package package_in_201907;

public class ShiftingLetters {

	public static void main(String[] args) {
		String string = "mkgfzkkuxownxvfvxasy";
		int shifts[] = { 505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950,
				81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912,
				116899933, 983296461, 536563513 };

		new ShiftingLetters().shiftingLetters(string, shifts);
	}

	public String shiftingLetters(String S, int[] shifts) {
		int[] shiftCounts = new int[shifts.length];

		// ����ÿ��shift��Ҫ�ƶ���λ��
		for (int i = shifts.length - 1; i > 0; i--) {
			// ���i Ϊshifts.length - 1
			if (i == shifts.length - 1) {
				shiftCounts[i] = shifts[i] % 26;
			}
			// ����Ϊ��ǰ���ַ���+1�ַ�֮��
			else {
				shiftCounts[i] = shifts[i] + shiftCounts[i + 1] % 26;
			}
		}

		// �޸�ÿ���ַ���λ��

		char[] sChars = S.toCharArray();

		for (int i = 0; i < sChars.length; i++) {
			int count = ((int) sChars[i]) - 97 + shiftCounts[i];

			char v = (char) (count % 26 + 97);

			sChars[i] = v;
		}

		String result = new String(sChars);
		return result;
	}
}
