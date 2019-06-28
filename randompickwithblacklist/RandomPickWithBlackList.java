package randompickwithblacklist;

import java.util.Arrays;

public class RandomPickWithBlackList {

    private int N;

    private int[] blacklist;

    public static void main(String[] args) {
        int[] A = { 0 };
        System.out.println(new RandomPickWithBlackList(3, A).pick());
    }

    public RandomPickWithBlackList(int N, int[] blacklist) {
        this.N = N;
        Arrays.sort(blacklist);
        this.blacklist = blacklist;
    }

    public int pick() {
        double randomValue = Math.random();
        int floor = (int) Math.floor(randomValue * N);
        for (int i = 0; i < this.blacklist.length; i++) {
            if (blacklist[i] <= floor) {
                if (floor + 1 >= N) {
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
