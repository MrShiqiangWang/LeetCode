package history.pkg201906;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockSpanner {

    public static void main(final String[] args) {
        // [[],[31],[41],[48],[59],[79]]
        final StockSpanner spanner = new StockSpanner();
        spanner.next(31);
        spanner.next(41);
        spanner.next(48);
        spanner.next(59);
        spanner.next(79);
    }

    List<Integer> prices = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public StockSpanner() {

    }

    public int next(final int price) {
        int sum = 0;
        // 找历史�??
        if (this.prices.size() != 0) {
            int index = this.prices.size() - 1;
            int oldprice = this.prices.get(index);
            while (oldprice <= price && index >= 0) {
                final int size = this.map.get(index);
                sum += size;
                index = index - size;
                if (index >= 0) {
                    oldprice = this.prices.get(index);
                }
            }
        }
        sum++;
        this.prices.add(price);
        this.map.put(this.prices.size() - 1, sum);
        return sum;
    }
}
