package countprimes;

import java.util.ArrayList;
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

    public int countPrimes1(int n) {
        int count = 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 2; i < n; i++) {
            if (isNotPrimes(primes, i)) {
                continue;
            }
            i++;
        }
        return n;
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