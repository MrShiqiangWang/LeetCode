package package_in_201906;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockSpanner {

    public static void main(String[] args) {
        // [[],[31],[41],[48],[59],[79]]
        StockSpanner spanner = new StockSpanner();
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

    public int next(int price) {
        int sum = 0;
        // 找历史�??
        if (prices.size() != 0) {
            int index = prices.size() - 1;
            int oldprice = prices.get(index);
            while (oldprice <= price && index >= 0) {
                int size = map.get(index);
                sum += size;
                index = index - size;
                if (index >= 0) {
                    oldprice = prices.get(index);
                }
            }
        }
        sum++;
        prices.add(price);
        map.put(prices.size() - 1, sum);
        return sum;
    }
}
