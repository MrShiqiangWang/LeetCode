package package201907;

public class DistributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int index = 0;
        int can = 1;
        while (candies > 0) {
            if (index == num_people) {
                index = 0;
            }
            if (candies >= can) {
                result[index] = result[index] + can;
                candies -= can;
            }
            else {
                result[index] = result[index] + candies;
                candies = 0;
            }
            can++;
            index++;
        }
        return result;
    }
}
