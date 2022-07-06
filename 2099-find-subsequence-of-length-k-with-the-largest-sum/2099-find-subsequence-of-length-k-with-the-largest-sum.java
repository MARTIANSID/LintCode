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
             sum-=pq.poll();
            }
        }
        List<Integer> indices=new ArrayList<>();
        while(pq.size()>0)indices.add(pq.poll());
        Collections.sort(indices);
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=nums[indices.get(i)];
        }
        return ans;
        
    }
}