class Solution {
    public long continuousSubarrays(int[] nums) {
        int n=nums.length;
        
        PriorityQueue<Integer> min=new PriorityQueue<>((a,b)->{
            return nums[a]-nums[b];
        });
        PriorityQueue<Integer> max=new PriorityQueue<>((a,b)->{
            return nums[b]-nums[a];
        });
        
        
        int si=0,ei=0;
        long cnt=0;
        
        while(ei<n){
            min.add(ei);
            max.add(ei);
            int ele=nums[ei++];
          
            
            while(nums[max.peek()]-nums[min.peek()]>2){
                while(max.peek()<=si)max.poll();
                while(min.peek()<=si)min.poll();
                si++;
            }
            cnt+=(ei-si);
        }
        return cnt;
    }
}



