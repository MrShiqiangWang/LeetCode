package pkg202007;

public class L509 {

    public int fib(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public int fib_1(int N) {
        int[] re = new int[N + 1];
        re[1] = 1;
        for (int i = 2; i < re.length; i++) {
            re[i] = re[i - 1] + re[i - 2];
        }
        return re[N];
    }

    public int fib_3(int N) {
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

    private Integer[] cache = new Integer[31];

    public int fib_2(int N) {
        cache[0] = 0;
        cache[1] = 1;
        if (N < 2) {
            return cache[N];
        }
        return fib_2X(N);
    }

    private int fib_2X(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        cache[n] = fib_2X(n - 1) + fib_2X(n - 2);
        return cache[n];
    }
}
