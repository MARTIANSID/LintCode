
import java.util.*;
class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans=new ArrayList<>();
        
        solve(n,"",ans,n,n);
        
        return ans;
       
    }
    public void solve(int n,String asf,List<String> ans,int close,int open){
        
        if(close==0&&open==0){
            ans.add(asf);
            return;
        }
        
        if(open<close&&close>0){
            solve(n,asf+")",ans,close-1,open);
        }
        
        if(open>0){
            solve(n,asf+"(",ans,close,open-1);
        }
        
    }
}