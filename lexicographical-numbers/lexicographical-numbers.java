class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>();
        
        for(int i=1;i<=9;i++){
            if(i<=n){
                ans.add(i);
                 dfs(i,ans,n);
            }
           
        }
        
        return ans;
      
    }
    
    public void dfs(int i,List<Integer> ans,int n){
        
        for(int j=0;j<=9;j++){
            if(i*10+j<=n){
                ans.add(i*10+j);
                dfs(i*10+j,ans,n);
            }
        }
    }
}