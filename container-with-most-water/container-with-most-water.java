class Solution {
    public int maxArea(int[] height) {
   
            
            int si=0;
            int ei=height.length-1;
            
            int max=0;
            while(si<ei){
                   int h1=height[si];
                   int h2=height[ei];
                    
                   max=Math.max(max,Math.min(h1,h2)*(ei-si));
                    
                   if(h2>h1){
                           si++;
                   }else{
                           ei--;
                   }
                    
            }
            
            return max;
            
                
    }
}