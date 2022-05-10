class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        boolean[] visited=new boolean[10];
        
        solve(k,n,ans,new ArrayList<>(),0,0,visited,0);
        
        return ans;
        
    }
    
    public void solve(int k,int n,List<List<Integer>> ans,List<Integer> result,int sum,int index,boolean[] visited,int j){
        
     if(index == k){
         if(sum == n){
             List<Integer> temp=new ArrayList<>(result);
             ans.add(temp);
             return;
         }
         return;
     }
        
        if(sum > n)return;
        
        for(int i=j+1;i<=9;i++){
            if(visited[i])continue;
            visited[i]=true;
            result.add(i);
            solve(k,n,ans,result,sum+i,index+1,visited,i);
            visited[i]=false;
            result.remove(result.size()-1);
        }
        
        
    }
}