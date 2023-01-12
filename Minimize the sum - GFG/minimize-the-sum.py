#User function Template for python3

import heapq

class Solution:
    def minimizeSum(self, N, arr):
        h=[]
        for ele in arr:
            heapq.heappush(h,ele)
        total=0
        while len(h) > 1:
            ele1=heapq.heappop(h)
            ele2=heapq.heappop(h)
            total=total+ele1+ele2
            heapq.heappush(h,ele1+ele2)
        return total
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    
    for _ in range(t):
        n = int(input())
        A = [int(x) for x in input().split()]
        ob=Solution()
        print(ob.minimizeSum(n, A))
# } Driver Code Ends