class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return nums[a]-nums[b];
        });
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
             pq.add(i);
            if(i>=k){
             nums[pq.poll()]=-(int)1e6;
            }
        }
        int[] ans=new int[k];
        int index=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=-(int)1e6)
            ans[index++]=nums[i];
        }
        return ans;
        
    }
}