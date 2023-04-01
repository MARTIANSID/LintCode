class Solution {
    class pair{
        int val;
        int index;
        pair(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public long findScore(int[] nums) {
        int n=nums.length;
        HashSet<Integer> marked=new HashSet<>();
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.val == b.val)return a.index-b.index;
            return a.val-b.val;
        });
        
        for(int i=0;i<n;i++){
            pq.add(new pair(nums[i],i));
        }
        
        long score=0;
        
        while(pq.size()>0){
            pair p=pq.poll();
            if(marked.contains(p.index))continue;
            score+=p.val;
            marked.add(p.index);
            marked.add(p.index+1);
            marked.add(p.index-1);
            
        }
        return score;
    }
}