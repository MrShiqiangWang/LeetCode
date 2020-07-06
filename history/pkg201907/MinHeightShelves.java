package history.pkg201907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeightShelves {

    public static void main(final String[] args) {
        final int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
        System.out.println(new MinHeightShelves().minHeightShelves(books, 4));
    }

    public int minHeightShelves(final int[][] books, final int shelf_width) {
        final List<Integer> result = new ArrayList<>();
        this.minHeightShelves(books, shelf_width, 0, 0, result);

        Collections.sort(result);
        return result.get(0);
    }

    private void minHeightShelves(final int[][] books, final int shelf_width, final int height, int index, final List<Integer> result) {
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

            this.minHeightShelves(books, shelf_width, currentHeight + height, index + 1, result);
            currentWidth += books[index][0];
            index++;
            if (index == books.length) {
                break;
            }
        }
    }

}
