package history.pkg202007;

import java.util.Arrays;

public class L1046 {

    public int lastStoneWeight(int[] stones) {
        while (stones.length >= 2) {
            Arrays.sort(stones);
            stones = Arrays.copyOfRange(stones, stones.length - 2, stones.length);
        }
        return stones[0];
    }
}
