class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        n = len(nums)
        i , j  = 0 ,  n-1
        
        while i < j:
            if nums[i] == val:
                while nums[j] == val:
                    j-=1
                    if i == j:
                        return i
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                i+=1
            else:
                i+=1
        if i == j and nums[i]!= val:
            return i+1
        
        return i
        
        