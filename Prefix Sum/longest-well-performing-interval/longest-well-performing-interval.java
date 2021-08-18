class Solution {
    public int longestWPI(int[] hours) {
     HashMap<Integer,Integer> map=new HashMap<>();
        
        
        int currSum=0,max=0;
     for(int i=0;i<hours.length;i++){
         currSum+=hours[i]>8?1:-1;
         if(currSum>0){
             max=i+1;
         }else{
             map.putIfAbsent(currSum,i);
             if(map.containsKey(currSum-1)){
                 max=Math.max(max,i-map.get(currSum-1));
             }
         }
     }
        return max;
        
        
    }
}






// [1,1,-1,-1]