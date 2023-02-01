class Solution {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(n,0,0,"",0);
        
        return result;
    }
    public void solve(int n,int close,int open,String ans,int index){
        
        if(index == 2*n){
            if(close == open)
            result.add(ans);
            return;
        }
        
        if(open>close){
            solve(n,close+1,open,ans+")",index+1);
        }
        
        solve(n,close,open+1,ans+"(",index+1);
    }
}