package problem;

import java.util.Arrays;

public class Problem80 implements Problem {


    /** Remove duplicates in-place such that max occurrences of any number is 2
     *
     * @param nums int[] in NON-DECREASING order
     * @return new array length
     * Runtime: O(n)
     * Space: 0(1)
     */
    /* Explanation:
     *  - Two pointer approach (j is first pointer and i is second pointer)
     *  - j starts at one (nothing to check for first two items)
     *  - i starts at one and increments through all values in nums
     *  - j increments whenever there are more than 3 of the same # in a row, and overwrites the data at its index in such cases
     *  - j increments the same amount of non-duplicated data is present, so it returns the length of the new array
     */
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    // One test case to check answer-- Answer checked and submitted on Leetcode
    @Override
    public void run() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6};
        int i = removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, i)));
    }

}
