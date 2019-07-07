package package_in_201907;

public class IsLongPressedName {
	public boolean isLongPressedName(String name, String typed) {
		char names[] = name.toCharArray();
		char typeds[] = typed.toCharArray();

		int k = 0;
		for (int i = 0; i < typeds.length; i++) {
			if (typeds[i] == names[k]) {
				k++;
				if (k == names.length) {
					return true;
				}
			}
		}
		return false;
	}
}
