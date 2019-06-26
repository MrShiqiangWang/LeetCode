package canplaceflowers;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		int[] flowerbed = { 0, 1, 0 };
		System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 1));
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) {
			return true;
		}
		if (flowerbed.length == 0) {
			if (n > 0) {
				return false;
			}
			return true;
		}

		if (flowerbed.length == 1) {
			if (n > 1) {
				return false;
			}
			if (n == 1) {
				if (flowerbed[0] == 0) {
					return true;
				}
				return false;
			}
		}
		for (int i = 0; i < flowerbed.length; i++) {
			if (n == 0) {
				return true;
			}
			if (i == 0) {
				if (flowerbed[0] == 0 && flowerbed[1] == 0) {
					flowerbed[i] = 1;
					n--;
				}
				continue;
			}
			if (i == flowerbed.length - 1) {
				if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
					flowerbed[i] = 1;
					n--;
				}
				continue;
			}

			if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
				flowerbed[i] = 1;
				n--;
				continue;
			}
		}
		if (n == 0) {
			return true;
		}
		return false;
	}
}
