package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L412 {

    public List<String> fizzBuzz(final int n) {
        final List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            result.add(this.fizzBuzzOne(i));
        }
        return result;
    }

    private String fizzBuzzOne(final int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }
        else if (i % 5 == 0) {
            return "Buzz";
        }
        else if (i % 3 == 0) {
            return "Fizz";
        }
        else {
            return String.valueOf(i);
        }
    }
}
