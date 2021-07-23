class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
    int n=gas.length;
        
        int petrol=0,start=0;
        for(int i=0;i<2*gas.length;i++){
            petrol+=gas[i%n]-cost[i%n];
           
            if(i-start==n-1&&petrol>=0)return start;
            if(petrol<=0){
                petrol=0;
                start=i+1;
               
                
            }
        }
     
        return -1;
    }
}