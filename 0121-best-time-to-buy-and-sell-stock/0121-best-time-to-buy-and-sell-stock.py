class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        prev = prices[0]
        maximum , profit = 0 , 0
        for ele in prices:
            if ele > prev:
                profit = ele - prev
            else:
                prev = ele
                profit = 0
            maximum = max(maximum,profit)
        return maximum
            
        