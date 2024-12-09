class Solution:
    def majorityElement(self, nums):
        def majority_element_rec(left, right):
            if left == right:
                return nums[left]
            
            mid = (left + right) // 2
            left_majority = majority_element_rec(left, mid)
            right_majority = majority_element_rec(mid + 1, right)
            
            if left_majority == right_majority:
                return left_majority
            
            left_count = sum(1 for i in range(left, right + 1) if nums[i] == left_majority)
            right_count = sum(1 for i in range(left, right + 1) if nums[i] == right_majority)
            
            return left_majority if left_count > right_count else right_majority
        
        return majority_element_rec(0, len(nums) - 1)

