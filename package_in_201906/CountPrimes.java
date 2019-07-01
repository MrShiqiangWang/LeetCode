package package_in_201906;

import java.util.List;

public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    public int countPrimesSpace(int n) {
        int spaces[] = new int[n];
        for (int i = 2; i < n; i++) {
            spaces[i] = 1;
        }
        for (int i = 3; i < n; i++) {
            if (spaces[i] == 1) {
                for (int j = i + 1; j * i < n; j++) {
                    spaces[j * i] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (spaces[i] == 1) {
                count++;
            }
        }
        return count;
    }

    private boolean isNotPrimes(List<Integer> primes, int n) {
        for (int i = 0; i < primes.size(); i++) {
            if (n % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPrimes(int n) {
        if (n == 2) {
            return true;
        }
        if (n == 3) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
