class Solution(object):
    def minimumRounds(self, tasks):
        dic={}
        cnt=0
        for ele in tasks:
            dic[ele]=dic.get(ele,0)+1
        for val in dic.values():
            if val < 2:
                return -1
            if val%3 == 1:
                val-=2
                cnt+=1
            cnt=cnt+val/3 +(val%3)/2;
        return cnt
        
        