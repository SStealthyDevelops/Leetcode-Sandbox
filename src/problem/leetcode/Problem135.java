package problem.leetcode;

import problem.Problem;

import java.util.Arrays;

public class Problem135 implements Problem {


    /*
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

    You are giving candies to these children subjected to the following requirements:
        - Each child must have at least one candy.
        - Children with a higher rating get more candies than their neighbors.
        - Return the minimum number of candies you need to have to distribute the candies to the children.
     */

    // THIS DOES NOT WORK :(
    public int candy(int[] ratings) {
        assert ratings.length > 0;
        if (ratings.length == 1) return 1; // If there is only one child, only one candy needs to be returned
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0) {
                if (ratings[i] > ratings[i - 1]) candies[i] = Math.max(candies[i], candies[i - 1] + 1);
                // If the candies[i] is more than the candies[i - 1], make candies[i - 1] MAX OF: candies[i] + 1 or candies[i -1] + 1
                // If the previous index is more than the current index, keep it as is
                if (ratings[i] < ratings[i - 1]) candies[i - 1] = candies[i - 1] > candies[i] ? candies[i - 1] : Math.max(candies[i] + 1, candies[i-1] + 1);
            }
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                if (i < ratings.length - 2 && ratings[i + 1] > ratings[i+2]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 2);
                }
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }

        }

        System.out.println(Arrays.toString(candies));

        int totalCandies = 0;
        for (int i = 0; i < ratings.length; i++) {
            totalCandies += candies[i];
        }
        return totalCandies;
    }


    @Override
    public void run() {
        int m = candy(new int[]{1,3,4,5,2}); // Expect 11
        System.out.println(m);
        int d = candy(new int[]{1,2,87,87,87,2,1}); // 13
        System.out.println(d);
        int e = candy(new int[]{1,6,10,8,7,3,2}); // 18 [1, 2, 5, 4, 3, 2, 1] 
        System.out.println(e);
    };
}
