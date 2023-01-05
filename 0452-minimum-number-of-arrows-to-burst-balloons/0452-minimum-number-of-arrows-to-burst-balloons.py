class Solution(object):
    def findMinArrowShots(self, points):
      points.sort(key=lambda x:x[1])
      prev=points[0][1]
      arrows=1
      for p in points:
        start=p[0]
        end=p[1]
        if prev < start:
          arrows+=1
          prev=end
      return arrows

