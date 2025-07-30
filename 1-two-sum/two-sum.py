class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hm = {}
        for i in range(len(nums)):
            sum_needed = target - nums[i]
            if sum_needed in hm:
                return [i, hm[sum_needed]]
            hm[nums[i]] = i
        return [0, 0]