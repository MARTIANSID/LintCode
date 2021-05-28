class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int si=0;
        int ei=0;
        int n=s.length();
           int cost=0; 
            int max=0;
          while(ei<n){
                  cost+=(Math.abs(s.charAt(ei)-t.charAt(ei)));
                ei++;
               if(cost>maxCost){
                       while(cost>maxCost){
                               cost-=(Math.abs(s.charAt(si)-t.charAt(si)));
                               si++;
                       }
               }else{
                       max=Math.max(max,ei-si);
               }
                
                  
                  
          }
            return max;
    }
}