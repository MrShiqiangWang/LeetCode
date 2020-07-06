package history.pkg201906;

import java.util.Arrays;

public class RandomPickWithBlackList {

    public static void main(final String[] args) {
        final int[] A = { 0 };
        System.out.println(new RandomPickWithBlackList(3, A).pick());
    }

    private final int N;

    private final int[] blacklist;

    public RandomPickWithBlackList(final int N, final int[] blacklist) {
        this.N = N;
        Arrays.sort(blacklist);
        this.blacklist = blacklist;
    }

    public int pick() {
        final double randomValue = Math.random();
        int floor = (int) Math.floor(randomValue * this.N);
        for (int i = 0; i < this.blacklist.length; i++) {
            if (this.blacklist[i] <= floor) {
                if (floor + 1 >= this.N) {
                    floor = 0;
                    i = 0;
                }
                else {
                    floor++;
                }
            }
            else {
                break;
            }
        }
        return floor;
    }
}
