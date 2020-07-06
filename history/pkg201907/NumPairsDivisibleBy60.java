package history.pkg201907;

public class NumPairsDivisibleBy60 {

    public static void main(final String[] args) {
        final int[] nums = { 30, 20, 150, 100, 40 };

        System.out.println(new NumPairsDivisibleBy60().numPairsDivisibleBy60(nums));
    }

    public int numPairsDivisibleBy60(final int[] time) {
        final int[] index = new int[60];

        for (int i = 0; i < time.length; i++) {
            final int myIndex = time[i] % 60;
            index[myIndex] = index[myIndex] + 1;
        }

        int sum = 0;
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) {
                final int newIndex = (60 - i) % 60;
                if (newIndex > i) {
                    sum += (index[i] * index[newIndex]);
                }
                if (newIndex == i) {
                    sum += index[i] * (index[i] - 1) / 2;
                }
            }
        }
        return sum;
    }

    public int numPairsDivisibleBy60Low(final int[] time) {
        int sum = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
