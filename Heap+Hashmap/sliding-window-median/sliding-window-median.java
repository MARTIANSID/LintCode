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
        
           
            
   
            min.remove(si);
            max.remove(si);
        
             si++;
        }
        
        double[] ans=new double[result.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=result.get(i);
        }
        
        return ans;
        
    }
    
    public void add(PriorityQueue<Integer> min,PriorityQueue<Integer> max,int index,int[] nums){
        if(min.size()==0&&max.size()==0){
            max.add(index);
        } else if(max.size()>min.size()){
            if(nums[max.peek()]<=nums[index]){
                min.add(index);
            }else{
              int x=  max.poll();
                max.add(index);
                min.add(x);
            }
        }else if(max.size()<min.size()){
                if(max .size()==0 ){
                    if(nums[min.peek()]>=nums[index]){
                            max.add(index);
                    }else{
                        int x=min.poll();
                        min.add(index);
                        max.add(x);
                    }
                }else{
                    
             if(nums[index]<=nums[min.peek()]){
                max.add(index);
            }else{
               int x= min.poll();
                min.add(index);
               max.add(x);
            }
                    
                    
                    
                }
        }
        
        else if(max.size()==min.size()){
            
            if(nums[index]<=nums[min.peek()]){
                max.add(index);
            }else{
               int x= min.poll();
                min.add(index);
               max.add(x);
            }
        }
        
    }
}