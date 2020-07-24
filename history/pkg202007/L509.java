package history.pkg202007;

public class L509 {

    private final Integer[] cache = new Integer[31];

    public int fib(final int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        return this.fib(N - 1) + this.fib(N - 2);
    }

    public int fib_1(final int N) {
        final int[] re = new int[N + 1];
        re[1] = 1;
        for (int i = 2; i < re.length; i++) {
            re[i] = re[i - 1] + re[i - 2];
        }
        return re[N];
    }

    public int fib_2(final int N) {
        this.cache[0] = 0;
        this.cache[1] = 1;
        if (N < 2) {
            return this.cache[N];
        }
        return this.fib_2X(N);
    }

    public int fib_3(final int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int pre = 0;
        int next = 1;
        int tmp = 0;
        for (int i = 2; i <= N; i++) {
            tmp = pre + next;
            pre = next;
            next = tmp;
        }
        return tmp;
    }

    private int fib_2X(final int n) {
        if (this.cache[n] != null) {
            return this.cache[n];
        }
        this.cache[n] = this.fib_2X(n - 1) + this.fib_2X(n - 2);
        return this.cache[n];
    }
}
