class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int ei=0,si=0,n=s.length(),max=0,cost=0;
        
        while(ei<n){
            cost+=Math.abs(s.charAt(ei)-t.charAt(ei));
            ei++;
            if(cost>maxCost){
                cost-=Math.abs(s.charAt(si)-t.charAt(si));
                si++;
            }
            max=Math.max(max,ei-si);
        }
        return max;
    }
}