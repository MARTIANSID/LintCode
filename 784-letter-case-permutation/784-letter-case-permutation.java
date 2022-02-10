class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        
        solve(s,ans,"",0);
        
        return ans;
    }
    
    public void solve(String s,List<String> ans,String asf,int index){
        
        if(index==s.length()){
            ans.add(asf);
            
            return;
        }
        
        char ch=s.charAt(index);
        
        if(!Character.isDigit(ch)){
            
            solve(s,ans,asf+Character.toUpperCase(ch),index+1);
            
            solve(s,ans,asf+Character.toLowerCase(ch),index+1);

            
        }else{
            solve(s,ans,asf+ch,index+1);
        }
             
            
        
        
    }
}