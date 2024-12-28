from typing import List


class Solution:
    """
    Rotate array in place.
    Example:
        [1, 2, 3, 4, 5, 6, 7] --> [5, 6, 7, 1, 2, 3] for k = 3
    """
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(0,k):
            nums.insert(0, 0)
        for i in range(k, 0, -1):
            nums[i-1] = nums.pop()