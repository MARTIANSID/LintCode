class Solution {
    public long numberOfWeeks(int[] milestones) {
        
        int n=milestones.length;

       
        
        //greedy algorithm
        
        long sum=0,max=-(long)1e9;
        for(int ele:milestones){
            sum+=ele;
            max=Math.max(max,ele);
        }
    
     
    long rem=sum-max;
        
        if(max>rem){
            return 2*rem+1;
        }else{
            return sum;
        }
        
        
        
        
    }
}