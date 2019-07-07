package package_in_201907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeightShelves {

	public static void main(String[] args) {
		int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
		System.out.println(new MinHeightShelves().minHeightShelves(books, 4));
	}

	public int minHeightShelves(int[][] books, int shelf_width) {
		List<Integer> result = new ArrayList<>();
		minHeightShelves(books, shelf_width, 0, 0, result);

		Collections.sort(result);
		return result.get(0);
	}

	private void minHeightShelves(int[][] books, int shelf_width, int height, int index, List<Integer> result) {
		if (index >= books.length) {
			result.add(height);
			return;
		}

		int currentHeight = 0;
		int currentWidth = 0;
		while (books[index][0] + currentWidth <= shelf_width) {
			if (currentHeight < books[index][1]) {
				currentHeight = books[index][1];
			}

			minHeightShelves(books, shelf_width, currentHeight + height, index + 1, result);
			currentWidth += books[index][0];
			index++;
			if (index == books.length) {
				break;
			}
		}
	}

}
