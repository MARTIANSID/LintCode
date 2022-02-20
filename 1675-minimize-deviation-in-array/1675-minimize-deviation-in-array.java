class Solution {
    public int minimumDeviation(int[] nums) {
        int n=nums.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });

        int diff=(int)1e9,min=(int)1e9;
        
        for(int ele:nums){
            if(ele%2==0){
                pq.add(ele);
                min=Math.min(min,ele);
            }else{
                pq.add(ele*2);
                min=Math.min(2*ele,min);
            }
        }
        
        while(pq.peek()%2!=1){
               int ele= pq.poll();
                pq.add(ele/2);
                min=Math.min(min,ele/2);
                diff=Math.min(diff,pq.peek()-min);
        }
        
      
    
        
        return diff;
        
        
     } 
}



