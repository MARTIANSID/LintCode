class Solution(object):
    def minDeletionSize(self, strs):
        cnt=0
        col=['']*len(strs[0])
        for s in strs:
            for i in range(0,len(s)):
                col[i]+=s[i]
        for s in col:
            if s != ''.join(sorted(s)):
                cnt+=1
        return cnt
        """
        :type strs: List[str]
        :rtype: int
        """
        