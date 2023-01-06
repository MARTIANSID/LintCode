class Solution(object):
    def maxIceCream(self, costs, coins):
      costs.sort()
      cnt=0
      for cost in costs:
        coins-=cost
        if coins < 0:
          break
        else:
          cnt+=1
      return cnt