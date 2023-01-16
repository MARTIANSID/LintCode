class Solution(object):
    def insert(self, intervals, newInterval):
        
        if(len(intervals)==0):
            return [newInterval]
        
        mx=newInterval[1]
        mn=newInterval[0]
        ans=[]
        added=False
        
        
        for interval in intervals:
            s,e=interval[0],interval[1]
            
            if mn<=e and mx>=s:
                mx=max(mx,e)
                mn=min(mn,s)
            elif added!=True and mx<s:
                ans.append([mn,mx])
                ans.append(interval)
                added=True
            else:
                ans.append(interval)
            
        if added!=True:
            ans.append([mn,mx])
            
        return ans
            
                
                
        