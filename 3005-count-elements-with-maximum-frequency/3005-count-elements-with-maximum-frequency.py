class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        hash_map = {}
        highest = 0
        
        for ele in nums:
            hash_map[ele] = hash_map.get(ele,0)+1;
            highest = max(highest,hash_map[ele])
        
        total = 0
        
        for key in hash_map.keys():
            freq = hash_map[key]
            if freq == highest:
                total+=freq
        return total
            