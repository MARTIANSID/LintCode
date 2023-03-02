class Solution(object):
    def compress(self, arr):
        
        n=len(arr)
        groupSize=1
        ans=[]
        size=0
        for i in range(0, n-1):
            if(arr[i]==arr[i+1]):
                groupSize+=1;
            else:
                if(groupSize==1):
                    size+=1
                    ans.append(str(arr[i]))
                else:
                    size+=1+len((str(groupSize)))
                    ans.append(str(arr[i]))
                    for s in str(groupSize):
                        ans.append(s)
                    groupSize=1
        
        if(groupSize==1):
            size+=1
            ans.append(str(arr[n-1]))
        else:
            size+=1+len(str(groupSize))
            ans.append(str(arr[n-1]))
            for s in str(groupSize):
                ans.append(s)
        del arr[:]
        for ch in ans:
            arr.append(ch)
        
        return size
                
                
                
        