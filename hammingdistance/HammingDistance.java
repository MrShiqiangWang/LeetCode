package hammingdistance;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        for (int n = result; n > 0; n /= 2) {
            if (n % 2 == 1) {
                count++;
            }
        }
        return count;
        
    }
}
