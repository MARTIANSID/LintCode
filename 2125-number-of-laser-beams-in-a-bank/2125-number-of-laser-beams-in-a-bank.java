class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        
        int prev=0,ans=0;
        for(String s:bank){
          int curr=  count(s);
            if(curr!=0&&prev!=0){
                ans+=curr*prev;
            }
            if(curr!=0)prev=curr;
        }
        return ans;
    }
    private int count(String str){
        int c=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')c++;
        }
        return c;
    }
}