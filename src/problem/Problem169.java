package problem;

public class Problem169 implements Problem {

    /*
        Given an array nums of size n, return the majority element.
        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
        *Challenge:  Try to solve in O(1) space and O(n) time
     */

    /**
     *
     * @param nums int[] with either an odd length or a clear majority #
     * @return the number that appears the most amount of times (> n/2)
     */
    public int majorityElement(int[] nums) {
        // Majority will store the number that appears the most amount of times
        // Count is *not* the count of the # of occurrences of any element, rather it is a way to measure the weight of any given element relative to the number of elements in the array
        int majority = 0, count = 0;

        for (int i : nums) {
            if (count == 0) {
                majority = i;
            }
            /*
                Count increases if current number, i, is the majority
                If it is not, count decreases
                If count hits zero, a new majority is assigned
             */
            count += i == majority ? 1 : -1;
        }
        // Find the number than appears more than (n/2) times
        return majority;
    }

    @Override
    public void run() {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
