class Solution {
    public String getHappyString(int n, int k) {
        List<String> ans=new ArrayList<>();
        dfs(ans,"",n,-1);
        
        return ans.size()<k?"":ans.get(k-1);
    }
    
    public void dfs(List<String> ans,String asf,int n,int prev){
        
        if(asf.length()==n){
            ans.add(asf);
            return;
        }
        
        for(int i=0;i<3;i++){
            if(i!=prev){
                dfs(ans,asf+(char)(i+'a'),n,i);
                
            }
        }
    }
}