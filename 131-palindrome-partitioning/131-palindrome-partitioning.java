class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        
        solve(s,0,ans,new ArrayList<>());
        
        return ans;
    }
    
    public void solve(String s,int index,List<List<String>> ans,List<String> result){
        
        if(index>=s.length()){
            List<String> d=new ArrayList<>(result);
            ans.add(d);
            return;
        }
        
        String str="";
        for(int i=index;i<s.length();i++){
            str+=s.charAt(i);
            if(isPalindrome(str)){
                result.add(str);
                solve(s,i+1,ans,result);
                result.remove(result.size()-1); 
            }
            
        }
    }
        public boolean isPalindrome(String str)
    {
 
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    } 
    
}