class Solution(object):
    def maxSubarraySumCircular(self, nums):
        n=len(nums)
        startIndex=-1
        currMax=0
        globalMax=-1000000
        globalMin=100000
        currMin=0
        total=0
        
        for i in range(0,n):
            total+=nums[i]
            currMin=min(currMin+nums[i],nums[i])
            currMax=max(currMax+nums[i],nums[i])
            globalMax=max(currMax,globalMax)
            globalMin=min(currMin,globalMin)
        if globalMin == total:
            return globalMax
        return max(globalMax,total-globalMin)
        
            
        