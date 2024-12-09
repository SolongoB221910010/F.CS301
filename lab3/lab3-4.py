
class Solution(object):
    def sortedArrayToBST(self, nums):
        
        def convertToBST(left, right):
            if left > right:
                return None
            
            mid = (left + right) // 2
            
            root = TreeNode(nums[mid])
            
            root.left = convertToBST(left, mid - 1)
            root.right = convertToBST(mid + 1, right)
            
            return root
        
        return convertToBST(0, len(nums) - 1)
