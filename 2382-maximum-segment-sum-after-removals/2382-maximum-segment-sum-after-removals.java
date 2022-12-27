import java.util.HashSet;

class Solution {
    public int findParent(int u, int[] parent) {
        if (parent[u] == u) {
            return u;
        }
       int x= findParent(parent[u], parent);
       parent[u]=x;
       return x; 
    }

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        int[] parent = new int[n];
        long[] sumOfComponents=new long[n];
        long[] ans=new long[n];
        long max=0;
        for(int i=0;i<n;i++)parent[i]=i;
       HashSet<Integer> set=new HashSet<>(); 

        for(int i=n-1;i>=0;i--){
           ans[i]=max;
           int removedIndex=removeQueries[i];
           set.add(removedIndex);
           int p1=findParent(removedIndex, parent);
           if(removedIndex+1<n && set.contains(removedIndex+1)){
                int p2=findParent(removedIndex+1, parent);
                parent[p2]=p1;
                sumOfComponents[p1]+=sumOfComponents[p2];
           }
           if(removedIndex-1>=0 && set.contains(removedIndex-1)){
                int p3=findParent(removedIndex-1, parent);
                parent[p3]=p1;
                sumOfComponents[p1]+=sumOfComponents[p3];
           }
           sumOfComponents[p1]+=nums[removedIndex];
           max=Math.max(max,sumOfComponents[p1]);
        }
        return ans;
    }
}