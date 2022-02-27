class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans=new ArrayList<>();
        
        solve(n,0,ans,"");
        
        return ans;
    }
    
    public void solve(int open,int close,List<String> ans,String asf){
        
        if(open==0&&close==0){
            ans.add(asf);
            return;
        }
        
        if(open>0)
        solve(open-1,close+1,ans,asf+"(");
        if(close>0)
        solve(open,close-1,ans,asf+")");
    }
}