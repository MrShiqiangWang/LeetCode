package pkg202007;

public class L1491 {

    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            max = Math.max(salary[i], max);
            min = Math.min(salary[i], min);
            sum += salary[i];
        }
        sum -= max;
        sum -= min;
        return Integer.valueOf(sum).doubleValue() / (salary.length - 2);
    }
}
