class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> min=new PriorityQueue<>((a,b)->{
            return Integer.compare(nums[a],nums[b]);
        });
        
        PriorityQueue<Integer> max=new PriorityQueue<>((a,b)->{
            return Integer.compare(nums[b],nums[a]);
        });
         int ei=0,si=0,n=nums.length;
        
        List<Double> result=new ArrayList<>();
        while(ei<n){
            while(ei-si<k-1){
                    add(min,max,ei,nums);
                ei++;
                
            }
            
            add(min,max,ei,nums);
            ei++;

        if(k%2!=0)    
         result.add((double)nums[max.peek()]);
        else{
            int val1=nums[max.peek()];
            int val2=nums[min.peek()];
            result.add((double)(((double)val1+(double)val2)/2));
        }
        
           
            
    if(nums[si]>nums[max.peek()]){
       min.remove(si);
       
   }else{
        max.remove(si);
       
    }
    rebalance(min,max);
             si++;
        }
        
        double[] ans=new double[result.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=result.get(i);
        }
        
        return ans;
        
    }
    
    
    public void rebalance(PriorityQueue<Integer> min,PriorityQueue<Integer> max){
        if(min.size()==max.size())return;
        if(min.size()>max.size()){
           if(min.size()>max.size()){
                max.add(min.poll());
           }
        }else{
            if(max.size()>min.size()+1){
                min.add(max.poll());
            }
        }
    }
    
    
    
    
    
    public void add(PriorityQueue<Integer> min,PriorityQueue<Integer> max,int index,int[] nums){
         if(max.size()==min.size()){
            min.offer(index);
            max.offer(min.remove());
        }
        else{
            max.offer(index);
            min.offer(max.remove());
        }
        
    }
}